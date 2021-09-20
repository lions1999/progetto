package logic.view;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import logic.dao.SqlDAO;
import logic.model.UserSingleton;

public class PostView  implements Initializable{

	UserSingleton sg = UserSingleton.getInstance();
	private SqlDAO ourDb = new SqlDAO(); 
	private String postId;
	
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
    @FXML
    private Button btnDelete;
    
    @FXML
    void onDeletePress(ActionEvent event) {
    	switch (sg.getRole()) {
		case ADMINISTRATOR:						
			try {
				if(confirmationDisplay()) {
				ourDb.deletePost(btnDelete.getAccessibleText());
				btnDelete.setVisible(false);
				}
				
			}catch(Exception e) {
				
			}
			break;
		case OWNER:
			alertDisplay("ONLY ADMINISTRATOR CAN DO THAT");
			break;				
		case RESIDENT:
			alertDisplay("ONLY ADMINISTRATOR CAN DO THAT");
			break;				
    	}
    }
    
    @Override
	public void initialize(URL location, ResourceBundle resources){
    	postId = sg.getPost().getId();
    	btnDelete.setAccessibleText(postId);
    	usrName.setText(sg.getPost().getUser());
    	posTxt.setText(sg.getPost().getText());
    	posTxt.setEditable(false);
    	InputStream input = sg.getPost().getImage();
    	try {
    	if (input != null && input.available() > 1) {
            Image imge = new Image(input);          
            postImg.setImage(imge);
    	}
    	}catch(Exception e){
    		
    	}
    }
    private void alertDisplay(String message){
    	AlertBox alert = new AlertBox();
    	alert.display("Condominium/HomePage/error!", message);
    }
    
    private boolean confirmationDisplay() {
    	ConfirmBox box = new ConfirmBox();
    	boolean i = box.display("Condominium/HomePage/Confirm","Are you sure about it?");
    	return i;
    }


}