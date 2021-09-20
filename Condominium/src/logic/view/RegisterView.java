package logic.view;

import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logic.bean.UserBean;
import logic.controller.RegisterController;
import logic.controller.ViewController;
import logic.controller.exception.InvalidInputException;
import logic.model.Role;

public class RegisterView extends Application{
	 
	private ViewController view = new ViewController();	
	private Role role;
	private String noRole = "No Role Selected";
	private String roleId;

    @FXML
    private TextField tfName;
    @FXML
    private TextField tfSurname;
    @FXML
    private TextField tfEmail;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private PasswordField tfOkPwd;
    @FXML
    private MenuItem mnuResident;
    @FXML
    private MenuItem mnuOwner;
    @FXML
    private Label lbRole;
    @FXML
    private TextField tfCondominiumCode;
    @FXML
    private Button btnSignup;
    @FXML
    private Button btnSignin;
    @FXML
    void onMnuResidentClick() {
    	lbRole.setText(mnuResident.getText());
    }
    @FXML
    void onMnuOwnerClick() {
    	lbRole.setText(mnuOwner.getText());
    }
    @FXML
    void onSigninClick() {
    	LoginView reg = new LoginView();
    	reg.start((Stage) btnSignup.getScene().getWindow());
    }

    @FXML
    void onSignupClick()throws InvalidInputException, SQLException{
    		UserBean bean = registerBean(tfName.getText(),tfSurname.getText(),tfEmail.getText(),tfPassword.getText(),lbRole.getText(),tfCondominiumCode.getText());
    		RegisterController controller = new RegisterController();
    		try {
    			controller.registration(bean);  		
    		} catch ( InvalidInputException e){
    			clearState();
    			alertDisplay("Not enough/Incorrect Credentials");
    		}
    }
    
    private void alertDisplay(String message){
    	AlertBox alert = new AlertBox();
    	alert.display("Condominium/Register/error!", message);
    }
    
    private void clearState(){ 
    	tfName.setText("");
    	tfSurname.setText("");
    	tfEmail.setText("");
    	tfPassword.setText("");
    	tfOkPwd.setText("");
    	lbRole.setText(noRole);
    	tfCondominiumCode.setText("");
    }
    
    public UserBean registerBean(String name,String surname,String email, String password,String role,String condominiumCode) {
		UserBean user = new UserBean();
		user.setName(name);
		user.setSurname(surname);
		user.setEmail(email);
		user.setPassword(password);
		user.setRole(role);
		user.setcondominiumCode(condominiumCode);
		return user;
	}

    public void start(Stage primaryStage){
		view.loadPage("Register", primaryStage);
	}

	public static void main(String[] args) {
		launch(args);
	}

}


    

	
    
