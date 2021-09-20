package logic.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    
	private ViewController view = new ViewController();
	private static UserSingleton sg = UserSingleton.getInstance();
    
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
    	paneSize(pane);
    	mainPage.setCenter(pane);
    }
    
    @FXML
    void btnInfoClick(ActionEvent event) {
    	Pane pane ;
    	switch (sg.getRole()) {
		case ADMINISTRATOR:						
			pane = view.getPage("Organize Condominium");
			paneSize(pane);
			mainPage.setCenter(pane);
			break;
		case OWNER:
			pane = view.getPage("RateResident");
			paneSize(pane);
			mainPage.setCenter(pane);
			break;				
		case RESIDENT:
			pane = view.getPage("AptInfo");
			paneSize(pane);
	    	mainPage.setCenter(pane);
			break;				
    	}   	
    }
    
    @FXML
    void btnMeetingClick(ActionEvent event) {
    	Pane pane ;
    	switch (sg.getRole()) {
		case ADMINISTRATOR:						
	    	pane = view.getPage("OrganizeMeeting");
	    	paneSize(pane);
	    	mainPage.setCenter(pane);
			break;
		case OWNER:
			pane = view.getPage("RequestMeeting");
			paneSize(pane);
			mainPage.setCenter(pane);
			break;				
		case RESIDENT:
			alertDisplay("Sorry only owner can do that");
			break;				
    	}   	
;
    }
    @FXML
    void btnSignOutClick(ActionEvent event) {
    	LoginView log = new LoginView();
    	log.start((Stage) btnSignout.getScene().getWindow());	
    	sg.clearState();
    }
	
    @Override
    public void initialize(URL location, ResourceBundle resources){
    	Pane pane = view.getPage("HomePage");
    	paneSize(pane);
    	mainPage.setCenter(pane);
       	btnColor(btnHome);
       	btnColor(btnMeeting);
       	btnColor(btnSignout);
       	btnColor(btnApartmentinfo); 
       	tfCondominiumCode.setText(sg.getCode());
       	switch (sg.getRole()) {
			case ADMINISTRATOR:						
				lbnome.setText(sg.getAdministrator().getName());
				btnApartmentinfo.setText("Condominium Info");
				btnMeeting.setText("Organize Meeting");
				break;
			case OWNER:
				lbnome.setText(sg.getOwner().getName());
				btnMeeting.setText("Request Meeting");
				btnApartmentinfo.setText("Rate Resident");
				break;				
			case RESIDENT:
				lbnome.setText(sg.getResident().getName());
				break;				
       	}
    }

	private void paneSize(Pane pane) {
		pane.setMinHeight(1052);
    	pane.setMinWidth(1360);
	}  
       
	private void alertDisplay(String message){
    	AlertBox alert = new AlertBox();
    	alert.display("Condominium/HomePage/error!", message);
    }
	
    private void btnColor(Button btn) {
    	btn.setOnMouseEntered(event -> {
       		btn.setStyle("-fx-background-color : #0A0E3F");
        });
    	btn.setOnMouseExited(event -> {
       		btn.setStyle("-fx-background-color : #0C39FF");
        });
    }
    
    
	@Override
	public void start(Stage primaryStage) throws Exception{		
		view.loadPage("Main", primaryStage);
		primaryStage.centerOnScreen();
	}

}
