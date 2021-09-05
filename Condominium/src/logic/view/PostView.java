package logic.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import logic.controller.ViewController;
import logic.model.UserSingleton;

public class PostView extends Application implements Initializable{

	private ViewController view = new ViewController();
	UserSingleton sg = UserSingleton.getInstance();
	
    @FXML
    private AnchorPane rootId;

    @FXML
    private Label usrName;

    @FXML
    private ImageView usrImg;

    @FXML
    private TextField posTxt;

    @FXML
    private ImageView postImg;
    
    @Override
	  public void initialize(URL location, ResourceBundle resources){
    	usrName.setText(sg.getPost().getUser());
    }
    
    @Override
	public void start(Stage primaryStage) {		
		view.loadPage("Post", primaryStage);
		
    }
}