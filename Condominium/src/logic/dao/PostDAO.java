package logic.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import logic.dao.queries.SimpleQueries;

public class PostDAO {
	
	
	public  InputStream checkImagePost(String i,String j) throws Exception {		
		
        Statement stmt = null;
        Connection conn = null;     
        ResultSet rs = null;
        InputStream input = null;
       
        
        try {
        	
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/condominiumdb","root","");
            
            stmt = conn.createStatement();
            
            rs = SimpleQueries.selectPostImage(stmt,i,j);
                                   	
            if(rs.next()) {
            	
            	input = rs.getBinaryStream("Image");
            }
            
        } finally {
        	
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
        }
        
        return input;
	}
}
