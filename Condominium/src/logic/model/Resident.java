package logic.model;

import logic.controller.exception.InvalidInputException;

public class Resident extends User{

	public Resident(String userID, String name, String email, String password,String cc)  throws InvalidInputException{
		super( userID,  name,  email,  password, cc);
		// TODO Auto-generated constructor stub
	}
}
