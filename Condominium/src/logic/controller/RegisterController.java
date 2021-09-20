package logic.controller;

import java.sql.SQLException;
import logic.bean.UserBean;
import logic.controller.exception.InvalidInputException;
import logic.dao.SqlDAO;
import logic.model.User;

public class RegisterController{

	private String roleId;
	private SqlDAO ourDb = new SqlDAO();
	
	public void registration(UserBean bean) throws SQLException,InvalidInputException{
		try {
		String name = bean.getName() + bean.getSurname();
		if(bean.getRole().equals("Owner")) {
			this.roleId = "2";
			System.out.println("OWNER -------->"+roleId);
		}
		if(bean.getRole().equals("Resident")) {
			this.roleId = "3";
			System.out.println("RESIDENT -------->"+roleId);
		}
		User user = new User("",name,bean.getEmail(),bean.getPassword(),bean.getCondominiumCode());
		System.out.println("INIZIALIZZO QUERY");
		ourDb.addRegistrationUser(user,roleId);
		}catch(SQLException e){
			
		}
	}
	
    
}
