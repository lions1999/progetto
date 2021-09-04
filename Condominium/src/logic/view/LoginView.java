package logic.view;

import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.CommunicationException;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logic.bean.UserBean;
import logic.controller.LoginController;
import logic.controller.ViewController;
import logic.controller.exception.DatabaseException;
import logic.controller.exception.ExceptionHandler;
import logic.controller.exception.InvalidInputException;

public class LoginView extends Application implements Initializable{
	
		private ViewController view = new ViewController();
				
		@FXML
		private TextField tfemail;
		@FXML
		private TextField tfpassword;
	    @FXML
	    private Button btnSignin;
	    @FXML
	    private Button btnSignup;
	    @FXML
	    private TextField tfcc;	    

	    @FXML
	    private void onSignupClick() throws Exception{	    	
	    	RegisterView reg = new RegisterView();
	    	reg.start((Stage) btnSignup.getScene().getWindow());	   
	    	
	    }
	    	    
	    @FXML
	    private void onSigninClick() {
	    	UserBean bean = loginBean(tfemail.getText(), tfpassword.getText(),tfcc.getText());
			LoginController controller = new LoginController();
			try {
				controller.login(bean);
				MainView home = new MainView();
				home.start((Stage) btnSignin.getScene().getWindow());
			} catch (InvalidInputException | DatabaseException e) {
				ExceptionHandler.handle(e);
			} catch (CommunicationException e ){
				alertDisplay("DataBase comunication ERROR!");
				e.printStackTrace();
			}  catch (Exception e) {
				e.printStackTrace();
			}
		}

		public UserBean loginBean(String email, String password, String condominiumCode) {
			UserBean user = new UserBean();
			user.setEmail(email);
			user.setPassword(password);
			user.setcondominiumCode(condominiumCode);
			return user;
		}
		
		 private void alertDisplay(String message){
		    AlertBox alert = new AlertBox();
		    alert.display("Condominium/Login/error!", message);
		}

		  @Override
		  public void initialize(URL location, ResourceBundle resources){
		 
			tfemail.setText("admin");
			tfpassword.setText("admin");
			tfcc.setText("67890");
		  }
		 
		 
		@Override
		public void start(Stage primaryStage) {		
			view.loadPage("Login", primaryStage);
			primaryStage.centerOnScreen();
		}	
		
		public static void main(String[] args) {
			launch(args);
		}
}

