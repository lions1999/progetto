package logic.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.stage.Stage;
import logic.controller.ViewController;
import logic.model.Post;
import logic.model.UserSingleton;

public class HomePageView extends Application implements Initializable {

	private ViewController view = new ViewController();
	UserSingleton sg = UserSingleton.getInstance();
	
    @FXML
    private VBox scrollBox;
       
    @Override
	  public void initialize(URL location, ResourceBundle resources){
    	List<Post> list = sg.getAdministrator().getPostList(); 
		for(int i=0; i<list.size();i++ ) {
			sg.setPost(list.get(i));
			Pane pane = view.getPage("Post");
			scrollBox.getChildren().add(pane);
		}
    }
    
	@Override
	public void start(Stage primaryStage) {		
		view.loadPage("HomePage", primaryStage);
	}	
	
	
}
