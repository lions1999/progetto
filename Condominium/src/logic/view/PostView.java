package logic.view;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import logic.model.UserSingleton;

public class PostView  implements Initializable{

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
    	posTxt.setText(sg.getPost().getText());
    	posTxt.setEditable(false);
    	InputStream input = sg.getPost().getImage();
    	try {
    	if (input != null && input.available() > 1) {
            Image imge = new Image(input);
            postImg.setPreserveRatio(true);
            postImg.setFitHeight(200);
            postImg.setFitWidth(590);
            postImg.setImage(imge);
    	}
    	}catch(Exception e){
    		
    	}
    }
    


}