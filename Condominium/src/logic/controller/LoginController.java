package logic.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logic.bean.UserBean;
//import logic.controller.exception.DatabaseException;
import logic.controller.exception.InvalidInputException;
import logic.dao.SqlDAO;
import logic.model.UserSingleton;
import logic.model.Administrator;

public class LoginController {
	private SqlDAO ourDB = new SqlDAO();
	private static UserSingleton sg = UserSingleton.getInstance();
	private String userId;
	
	public void login(UserBean bean) throws InvalidInputException, SQLException {
		if (checkBean(bean)) {			
			userId = ourDB.checkUserID(bean.getEmail(), bean.getCondominiumCode());
			sg.setRole(ourDB.checkRole(ourDB.checkRoleId(userId)));
				switch (sg.getRole()) {
					case ADMINISTRATOR:
						Administrator admin = ourDB.loadAdminbyID(userId);
						sg.setAdministrator(admin);
						break;
					case OWNER:
						break;
					case RESIDENT:
						break;				
					default:
						break;
				}
		} else {
			throw new InvalidInputException("Wrong password");
		}		
	}
		
	public boolean checkBean(UserBean bean) throws SQLException{
		return ourDB.checkLogin( bean.getEmail(),bean.getCondominiumCode()).equals(bean.getPassword());
	}
	
}




