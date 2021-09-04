package logic.controller;

import java.sql.SQLException;
import java.util.List;

import logic.dao.SqlDAO;
import logic.model.Post;
import logic.model.UserSingleton;

public class HomePageController{
	
	
	private SqlDAO ourDB = new SqlDAO();
	private static UserSingleton sg = UserSingleton.getInstance();
	private List<Post> listPost;
	
	
    public void getListofPost(String condominiumCode) throws SQLException{
    	try {
    		List<String> listId = ourDB.checkListPost(condominiumCode);
    		for (int i = 0; i < listId.size(); i++) {
    			Post post = ourDB.checkPost(listId.get(i));
    			listPost.add(post);
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	sg.setList(listPost);
    }

}

