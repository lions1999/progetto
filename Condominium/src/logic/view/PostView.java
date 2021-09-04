package logic.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class PostView implements Initializable{

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
    	
    }
    
    public void setUpPost(String name) {
    	usrName.setText(name);
    }
		
}
