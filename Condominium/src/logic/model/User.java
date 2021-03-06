package logic.model;

import logic.controller.exception.InvalidInputException;
import logic.util.InputChecker;

public class User {

	private String userID;
    private String name;
	private String email;
	private String password;
	private String cc;
	
	public  User(String userID,String name,String email,String password, String cc) throws InvalidInputException{
		this.setUserID(userID);
		this.setName(name);
		this.setEmail(email);
		this.setPassword(password);
		this.setCode(cc);
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

    public void setEmail(String email)  throws InvalidInputException{
    	InputChecker.checkEmail(email);
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getCode() {
        return cc;
    }

    public void setCode(String cc) {
        this.cc = cc;
    }
}
