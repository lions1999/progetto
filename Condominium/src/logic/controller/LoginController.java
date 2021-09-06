package logic.controller;

import java.sql.SQLException;
import logic.bean.UserBean;
import logic.controller.exception.InvalidInputException;
import logic.dao.SqlDAO;
import logic.model.UserSingleton;
import logic.model.Administrator;
import logic.model.Owner;
import logic.model.Resident;

public class LoginController {
	private SqlDAO ourDb = new SqlDAO();
	private static UserSingleton sg = UserSingleton.getInstance();
	
	public void login(UserBean bean) throws InvalidInputException, SQLException {
		if (checkBean(bean)) {			
			sg.setUserID(ourDb.checkUserID(bean.getEmail(), bean.getCondominiumCode()));
			sg.setCode(bean.getCondominiumCode());
			sg.setRole(ourDb.checkRole(ourDb.checkRoleId(sg.getUserID())));
				switch (sg.getRole()) {
					case ADMINISTRATOR:						
						Administrator admin = ourDb.loadAdminbyID(sg.getUserID());						
						sg.setAdministrator(admin);
						break;
					case OWNER:
						Owner owner = ourDb.loadOwnerByID(sg.getUserID());
						sg.setOwner(owner);
						break;
					case RESIDENT:
						Resident resident = ourDb.loadResidentByID(sg.getUserID());
						sg.setResident(resident);
						break;				
					default:
						break;
				}
		} else {
			throw new InvalidInputException("Wrong password");
		}		
	}
		
	public boolean checkBean(UserBean bean) throws SQLException{
		return ourDb.checkLogin( bean.getEmail(),bean.getCondominiumCode()).equals(bean.getPassword());
	}
	
}




