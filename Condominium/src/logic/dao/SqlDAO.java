package logic.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.model.Administrator;
import logic.model.Owner;
import logic.model.Post;
import logic.model.Resident;
import logic.dao.queries.SimpleQueries;
import logic.model.Role;

public class SqlDAO {
				
	private static final String URL = "jdbc:mysql://localhost:3306/condominium_db";
	private static final String USER = "condominium";
	private static final String PASSWORD = "ispw2021";
	
	private PreparedStatement pstmt;
	private Statement stmt;
	private Connection conn;
	
	private Role role;
	private String roleId;
	private String usrName;
	private String getID;
	private String pwd;
	private String condominium;
	
	public SqlDAO() {
		this.stmt = null;
		this.conn = null;
		this.pstmt = null;
	}
	
	private void connect() throws SQLException {
		 DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		 conn = DriverManager.getConnection(URL,USER,PASSWORD);
		 stmt = conn.createStatement();
	}
	
	private void disconnect() throws SQLException{
        if (stmt != null)
            stmt.close();
        if (conn != null)
            conn.close();
	}
	
	public Administrator loadAdminbyID(String id) throws SQLException {
		Administrator admin = null;
		try {
			connect();
			ResultSet rs = SimpleQueries.loadAdminbyID(stmt,id);
			if(rs.next()) {
				String userId = id;
				String userName = rs.getString("user_name");
				String userEmail = rs.getString("user_email");
				String userPwd = rs.getString("user_pwd");			
				admin = new Administrator(userId,userName,userEmail,userPwd);
            }									
		} finally {
			disconnect();
		}
		return admin;
	}
	
	public Owner loadOwnerByID(String id) throws SQLException {
		Owner owner = null;
		try {
			connect();
			ResultSet rs = SimpleQueries.loadOwnerbyID(stmt,id);
			if(rs.next()) {
				String userId = id;
				String userName = rs.getString("user_name");
				String userEmail = rs.getString("user_email");
				String userPwd = rs.getString("user_pwd");			
				owner = new Owner(userId,userName,userEmail,userPwd);
            }									
		} finally {
			disconnect();
		}
		return owner;
	}

	public Resident loadResidentByID(String id) throws SQLException {
		Resident resident = null;
		try {
			connect();
			ResultSet rs = SimpleQueries.loadResidentbyID(stmt,id);
			if(rs.next()) {
				String userId = id;
				String userName = rs.getString("user_name");
				String userEmail = rs.getString("user_email");
				String userPwd = rs.getString("user_pwd");			
				resident = new Resident(userId,userName,userEmail,userPwd);
            }									
		} finally {
			disconnect();
		}
		return resident;
	}
	
		
	public String checkUserID(String email,String condominiumCode) throws SQLException{
		 try {        	
	        	connect();           
	            ResultSet rs = SimpleQueries.selectUserID(stmt, email,condominiumCode);           
	            if(rs.next()) {
	            	this.getID = rs.getString("user_id");
	            }
	        } finally {       	
	        	disconnect();
	        }
	        return this.getID;
	}
		
	public  String checkLogin(String email,String condominiumCode) throws SQLException {		                
        try {        	
        	connect();           
            ResultSet rs = SimpleQueries.selectLogin(stmt, email, condominiumCode);           
            if(rs.next()) {
            	this.pwd = rs.getString("user_pwd");
            }
        } finally {       	
        	disconnect();
        }
        return this.pwd;
	}
	
		
	public  Role checkRole(String id) throws SQLException {				
        try {
        	
        	connect();            
            ResultSet rs = SimpleQueries.selectRole(stmt,id);                                    
            if(rs.next()) {
            	this.role = Role.valueOf(rs.getString("role_name"));
            }            
        } finally {
        		disconnect();
        }
        return this.role;
	}
	
	public String checkRoleId(String id) throws SQLException{
		try {
        	connect();            
            ResultSet rs = SimpleQueries.selectRoleId(stmt,id);                                    
            if(rs.next()) {
            	this.roleId = rs.getString("user_role");
            }            
        } finally {
        		disconnect();
        }
        return this.roleId;
	}
		
	public  String checkCondominium(String condCode) throws SQLException {		       
		try {    	
			connect();         
			ResultSet rs = SimpleQueries.selectCondominiumList(stmt, condCode);                        
			if(rs.next()) {
				this.condominium = rs.getString("Via");
			}        
	    } finally {    	
	            disconnect();
	    }
	    	return this.condominium;
		}

	public String checkNameByID(String id)throws SQLException {
		try {    	
			connect();         
			ResultSet rs = SimpleQueries.selectNameByID(stmt, id);                        
			if(rs.next()) {
				this.usrName = rs.getString("user_name");
			}        
	    } finally {    	
	            disconnect();
	    }
		return this.usrName;
	}
	
	public List<Post> checkListPost(String codiceCondominio)throws SQLException{
		List<Post> list = new ArrayList<>();
		Post post = null;
		ResultSet rs = null;
		try {
			connect();
			rs = SimpleQueries.selectListPost(stmt,codiceCondominio);
			while(rs.next()) {			
				String postUsr = rs.getString("post_usr");
				String postText = rs.getString("post_txt");
				InputStream postImg = rs.getBinaryStream("post_img");			
				post = new Post(checkNameByID(postUsr),postText,postImg);
				list.add(post);				
			}
		} finally {
			disconnect();
		}   
		return list;
	}
	
	public void addPost(String postId,String usrId,String txt,File file,String cc) throws SQLException{
		try {
			try {
				InputStream input = new FileInputStream(file);
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				conn = DriverManager.getConnection(URL,USER,PASSWORD);
				String sql = "INSERT INTO posts (post_id, post_usr, post_cc, post_txt, post_img) VALUES (?, ?, ?, ?, ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, postId);
				pstmt.setString(2, usrId);
				pstmt.setString(3, cc);
				pstmt.setString(4, txt);
				pstmt.setBinaryStream(5, input, (int) file.length());				
				pstmt.executeUpdate();
			}catch (Exception e) {
				
			}
			
		} finally {
			disconnect();
		}
	}

}
	
