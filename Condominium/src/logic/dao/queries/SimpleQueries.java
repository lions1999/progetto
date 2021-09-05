package logic.dao.queries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SimpleQueries {
		
	public static ResultSet selectListPost(Statement stmt,String condominiumCode) throws SQLException{
		String sql="SELECT post_usr,post_txt,post_img,post_lbl FROM posts where post_id IN (SELECT  post_id FROM `posts` WHERE post_cc='"+condominiumCode+"')";
		System.out.println(sql);
		return stmt.executeQuery(sql);
	}
	
	public static ResultSet selectNameByID(Statement stmt, String id)  throws SQLException {
		String sql= "SELECT user_name FROM users WHERE user_id='"+id+"'";
		System.out.println(sql);
		return stmt.executeQuery(sql);
	}
	
	public static ResultSet loadAdminbyID(Statement stmt, String id)  throws SQLException {
		String sql= "SELECT user_name,user_email,user_pwd,user_role,user_cc FROM users WHERE user_id='"+id+"'";
		System.out.println(sql);
		return stmt.executeQuery(sql);
	}
	
    public static ResultSet selectUserID(Statement stmt, String email,String condominiumCode)  throws SQLException {
		String sql= "SELECT user_id from users where user_email='"+email+"'and user_cc='"+condominiumCode+"'";
		System.out.println(sql);
		return stmt.executeQuery(sql);	
    }
		
    public static ResultSet selectCondominiumList(Statement stmt, String condominiumCode) throws SQLException  {
        String sql = "SELECT * FROM condominiums where CodiceCondominio = '" + condominiumCode + "'";
        System.out.println(sql);
        return stmt.executeQuery(sql);
    }
    
    public static ResultSet selectCondominiumCode(Statement stmt, String email) throws SQLException {
    	String sql = "SELECT CodiceCondominioFK from users where Email='"+email+"'";
    	System.out.println(sql);
        return stmt.executeQuery(sql);
    }
    
    public static ResultSet selectLogin(Statement stmt, String email,String condominiumCode)  throws SQLException {
		String sql= "SELECT user_pwd from users where user_email='"+email+"'and user_cc='"+condominiumCode+"'";
		System.out.println(sql);
		return stmt.executeQuery(sql);	
    }
	
    public static ResultSet selectRole(Statement stmt,String id) throws SQLException  {
        String sql = "SELECT role_name FROM role WHERE role_id='"+id+"'";
        System.out.println(sql);
        return stmt.executeQuery(sql);
    }
    
    public static ResultSet selectRoleId(Statement stmt,String id) throws SQLException  {
        String sql = "SELECT user_role FROM users WHERE user_id='"+id+"'";
        System.out.println(sql);
        return stmt.executeQuery(sql);
    }
    
    public static ResultSet selectPostImage(Statement stmt,String id,String condominiumCode) throws SQLException  {
        String sql = "SELECT Image FROM posts where ID='"+id+"' and CodiceCondominioFK='"+condominiumCode+"'";
        System.out.println(sql);
        return stmt.executeQuery(sql);
    }
}
