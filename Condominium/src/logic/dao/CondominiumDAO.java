
package logic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.dao.queries.SimpleQueries;
import logic.model.User;

public class CondominiumDAO {
	
//	public  List<User> retreiveByCondominumList(String CodiceCodnominio) throws Exception {
//        // STEP 1: dichiarazioni
//        Statement stmt = null;
//        Connection conn = null;
//        List<User> listOfUser = new ArrayList<User>();
//        
//        try {
//            // STEP 2: loading dinamico del driver mysql
//            Class.forName("com.mysql.jdbc.Driver");
//
//            // STEP 3: apertura connessione
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/condominiumdb","root","");
//
//            // STEP 4: creazione ed esecuzione della query
//            stmt = conn.createStatement();
//            
//            ResultSet rs = SimpleQueries.selectCondominiumList(stmt, CodiceCodnominio);
//
//            if (!rs.first()){ // rs empty
//            	Exception e = new Exception("No Condomnium Found matching with code: "+CodiceCodnominio);
//            	throw e;
//            }
//            
//            // riposizionamento del cursore
//            rs.first();
//            do{
//                // lettura delle colonne "by name"
//                String nome = rs.getString("Nome");
//            	String cognome = rs.getString("Cognome");
//                
//                User a = new User(nome, cognome);
//                
//                listOfUser.add(a);
//
//            }while(rs.next());
//            
//            // STEP 5.1: Clean-up dell'ambiente
//            rs.close();
//        } finally {
//            // STEP 5.2: Clean-up dell'ambiente
//            try {
//                if (stmt != null)
//                    stmt.close();
//            } catch (SQLException se2) {
//            }
//            try {
//                if (conn != null)
//                    conn.close();
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }
//        }
//
//        return listOfUser;
//    }

}
