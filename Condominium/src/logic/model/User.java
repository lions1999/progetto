package logic.model;

public class User {

	private String userID;
    private String name;
	private String email;
	private String password;
	
	public  User(String userID,String name,String email,String password){
		this.setUserID(userID);
		this.setName(name);
		this.setEmail(email);
		this.setPassword(password);
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
    
	
}
