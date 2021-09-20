package logic.view;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import logic.controller.AddPostController;
import logic.dao.SqlDAO;
import logic.model.UserSingleton;

public class AddPostView implements Initializable{
	
	private SqlDAO ourDb = new SqlDAO();
	private AddPostController controller = new AddPostController();
	private File file;
	UserSingleton sg = UserSingleton.getInstance();
	
	
    @FXML
    private TextField txtfield;
    @FXML
    private Button btnAddPost;
    @FXML
    private ImageView imgUserPost;
    @FXML
    private Button btnPublish;
    
    @FXML
    void addFileClick(ActionEvent event) {
    	this.file = controller.selectFile();
    	if (this.file != null) {
    		btnAddPost.setText("File Selected");
    	}  
    }
   
    @FXML
    void onPublishClick(ActionEvent event) {
		if(btnAddPost.getText().equals("Add File")) {
			alertDisplay("No file selected");
		}
	     else if(txtfield.getText().isEmpty()) {	
	    	 alertDisplay("No text written");
	    } else {
	    	try {
	    		ourDb.addPost(sg.getPostId(),sg.getUserID(),txtfield.getText(),this.file,sg.getCode());
	    	//	alertDisplay("To visualize your post, please refresh the page");
	    		btnPublish.setDisable(true);
	    	} catch(Exception e) {
	    		
	    	}
	    }
    }
      
    @Override
    public void initialize(URL location, ResourceBundle resources){
    	btnColor(btnPublish);
    	btnColor(btnAddPost);
    }
    
    private void btnColor(Button btn) {
    	btn.setOnMouseEntered(event -> {
       		btn.setStyle("-fx-background-color : #0A0E3F");
        });
    	btn.setOnMouseExited(event -> {
       		btn.setStyle("-fx-background-color : #0C39FF");
        });
    }
    
    private void alertDisplay(String message){
    	AlertBox alert = new AlertBox();
    	alert.display("Condominium/HomePage/error!", message);
    	btnAddPost.setText("Add File");
    	txtfield.setText("");
    }

}
