package logic.model;

import java.util.List;

public class UserSingleton {

	private Administrator administrator = null;
	/*private Resident resident = null;
	private Owner owner = null;*/	
	private Role role;
	private String code;	
	private Post post;

	private static UserSingleton instance = null;

	private UserSingleton() {
	}

	public static UserSingleton getInstance() {
		if (instance == null)
			instance = new UserSingleton();
		return instance;
	}
	
/*	public void setUserID(int id) {
		this.id = id;
	}
	
	public int getUserID() {
		return this.id;
	}*/

	public void setAdministrator(Administrator user) {
		this.administrator = user;
	}

	public Administrator getAdministrator() {
		return this.administrator;
	}


	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public Post getPost() {
		return this.post;
	}
	
	public void setPost(Post post) {
		 this.post = post;
	}

	public void clearState() {
		this.setCode(null);
		this.setRole(null);
		this.setAdministrator(null);
		this.setPost(null);
	}

}
