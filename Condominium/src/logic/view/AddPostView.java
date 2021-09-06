package logic.view;

import java.awt.FlowLayout;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;
import java.util.ResourceBundle;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import logic.controller.AddPostController;
import logic.controller.ViewController;
import logic.dao.SqlDAO;
import logic.model.UserSingleton;


public class AddPostView implements Initializable{

	
	MainView main = new MainView();
	private AddPostController controller = new AddPostController();
	private File file;
	UserSingleton sg = UserSingleton.getInstance();
	private SqlDAO ourDb = new SqlDAO();
	
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
    		btnAddPost.setText("file Selected");
    	}  
    }

    @FXML
    void onPublishClick(ActionEvent event) {
		if(btnAddPost.getText().equals("Add File")) {
			alertDisplay("NO FILE ADDED");
		}
	     else if(txtfield.getText().isEmpty()) {	
	    	 alertDisplay("NO TEXT");
	    } else {
	    	try {
	    		ourDb.addPost(sg.getPostId(),sg.getUserID(),txtfield.getText(),this.file,sg.getCode());
	    		main.btnHomeClick(event);
	    	} catch(Exception e) {
	    		
	    	}
	    }
    }
      
    @Override
    public void initialize(URL location, ResourceBundle resources){
    	btnAddPost.setOnMouseEntered(event -> {
    	btnAddPost.setStyle("-fx-background-color : #0A0E3F");
    });
    btnAddPost.setOnMouseExited(event -> {
    	btnAddPost.setStyle("-fx-background-color : #0C39FF");
    });

    }
    private void alertDisplay(String message){
    	AlertBox alert = new AlertBox();
    	alert.display("Condominium/Register/error!", message);
    	btnAddPost.setText("Add File");
    	txtfield.setText("");
    }

}
