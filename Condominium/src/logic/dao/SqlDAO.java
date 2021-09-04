package logic.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.model.Administrator;
import logic.model.Post;
import logic.dao.queries.SimpleQueries;
import logic.model.Role;

public class SqlDAO {
				
	private static final String URL = "jdbc:mysql://localhost:3306/condominium_db";
	private static final String USER = "condominium";
	private static final String PASSWORD = "ispw2021";
	
	private Statement stmt;
	private Connection conn;
	
	private Role role;
	private String roleId;
	private String getID;
	private String pwd;
	private String condominiumCode;
	private String condominium;
	
	public SqlDAO() {
		this.stmt = null;
		this.conn = null;
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
				String userCc = rs.getString("user_cc");				
				admin = new Administrator(userId,userName,userEmail,userPwd,userCc,null);
            }									
		} finally {
			disconnect();
		}
		return admin;
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
		
	public String checkCondominiumCode(String email) throws SQLException {			               
        try {      	
            connect();            
            ResultSet rs = SimpleQueries.selectCondominiumCode(stmt, email);                                 
            if(rs.next()) {
            	this.condominiumCode = rs.getString("CodiceCondominioFK");
            }            
        } finally {        	
                disconnect();
        }
        return this.condominiumCode;
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

	public  InputStream checkImagePost(String id,String codiceCondominio) throws SQLException {			 
		ResultSet rs = null;
		InputStream input = null;     
		try {   	
			connect();       
			rs = SimpleQueries.selectPostImage(stmt,id,codiceCondominio);                              	
			if(rs.next()) {       	
				input = rs.getBinaryStream("Image");
			}      
		} finally {
			disconnect();
		}   
		return input;
	}

	public Post checkPost(String postId) throws SQLException{
		Post post = null;
		ResultSet rs = null; 
		try {   	
			connect();       
			rs = SimpleQueries.selectPost(stmt,postId);                              	
			if(rs.next()) {       	
				String postUsr = rs.getString("post_usr");
				String postText = rs.getString("post_txt");
				InputStream postImg = rs.getBinaryStream("post_img");			
				post = new Post(postUsr,postText,postImg);
			}      
		} finally {
			disconnect();
		}   
		return post;
	}
	
	
	public List<String> checkListPost(String codiceCondominio)throws SQLException{
		List<String> list = new ArrayList<>();
		ResultSet rs = null;
		try {
			connect();
			rs = SimpleQueries.selectListPost(stmt,codiceCondominio);
			while(rs.next()) {				
				String postId = rs.getString("post_id");
				list.add(postId);
			}
		} finally {
			disconnect();
		}   
		return list;
	}
	
}
	
