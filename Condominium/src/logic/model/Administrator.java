package logic.model;

import java.util.List;

public class Administrator extends User {

	public Administrator(String userID, String name, String email, String password,	String condominiumCode,List<Post> post) {
		super( userID,  name,  email,  password, condominiumCode, post);
		// TODO Auto-generated constructor stub
	}

}
