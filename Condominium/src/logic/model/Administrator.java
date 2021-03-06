package logic.model;

import java.util.List;

import logic.controller.exception.InvalidInputException;

public class Administrator extends User {

	private List<Request> list;
	
	public Administrator(String userID, String name, String email, String password,String cc,List<Request> list)  throws InvalidInputException{
		super( userID,  name,  email,  password, cc);
		this.setListRequest(list);
	}
	
	public List<Request> getListRequest(){
		return this.list;
	}
	
	public void setListRequest(List<Request> list) {
		this.list = list;
	}

}
