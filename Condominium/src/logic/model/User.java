package logic.model;

import java.util.List;

public class User {

	private String userID;
    private String name;
	private String email;
	private String password;
	private String condominiumCode;
	private List<Post> post;
	
	public  User(String userID,String name,String email,String password,String condominiumCode, List<Post> post){
		this.setUserID(userID);
		this.setName(name);
		this.setEmail(email);
		this.setPassword(password);
		this.setcondominiumCode(condominiumCode);
		this.setPostList(post);
	}
	
	public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getCondominiumCode() {
        return condominiumCode;
    }

    public void setcondominiumCode(String condominiumCode) {
        this.condominiumCode = condominiumCode;
    }
    
    public List<Post> getPostList(){
    	return this.post;
    }
    
    public void setPostList(List<Post> post){
    	this.post = post;
    }
	
}
