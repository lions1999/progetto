package logic.view;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.controller.ViewController;
import logic.model.UserSingleton;

public class MainView extends Application implements Initializable {
    
	private MainViewController mainController = new MainViewController();
	private ViewController view = new ViewController();
	private static UserSingleton sg = UserSingleton.getInstance();
	private PostView post = new PostView();
    
    @FXML
    private BorderPane mainPage;
	@FXML
	private Label lbTitle;
 	@FXML
 	private ImageView imgUser;
 	@FXML
	private Label lbnome;
	@FXML
	private Button btnHome;
	@FXML
	private Button btnMessage;
	@FXML
	private Button btnMeeting;
	@FXML
	private Button btnApartmentinfo;
	@FXML
	private Button btnSignout;
	@FXML
	private Label tfCondominiumCode;
	@FXML
	private Label tfEmail;
	@FXML
	private VBox scrollbarBox;
	@FXML
	private Button btnAddPost;
	@FXML
	private ImageView imgUserPost;
    @FXML
    void btnHomeClick(ActionEvent event) {
    	Pane pane = view.getPage("HomePage");
    	mainPage.setCenter(pane);
    }
    @FXML
    void btnInfoClick(ActionEvent event) {
    	Pane pane = view.getPage("AptInfo");
    	mainPage.setCenter(pane);
    }
    @FXML
    void btnMeetingClick(ActionEvent event) {
    	Pane pane = view.getPage("Meeting");
    	mainPage.setCenter(pane);
    }
    @FXML
    void btnSignOutClick(ActionEvent event) {
    	LoginView log = new LoginView();
    	log.start((Stage) btnSignout.getScene().getWindow());	
    	sg.clearState();
    }
	
    @Override
    public void initialize(URL location, ResourceBundle resources){
    	lbnome.setText(sg.getAdministrator().getName());		  			
	  } 

	  
	@Override
	public void start(Stage primaryStage) throws Exception{		
		view.loadPage("Main", primaryStage);
		primaryStage.centerOnScreen();
	}
		
	public static void main(String[] args) {
		launch(args);
	}

}
