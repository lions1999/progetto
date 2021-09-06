package logic.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import logic.controller.ViewController;
import logic.dao.SqlDAO;
import logic.model.Post;
import logic.model.UserSingleton;

public class HomePageView  implements Initializable {

	private SqlDAO ourDb = new SqlDAO();
	private ViewController view = new ViewController();
	UserSingleton sg = UserSingleton.getInstance();
	
    @FXML
    private VBox scrollBox;
       
    @Override
	  public void initialize(URL location, ResourceBundle resources){
    	Pane addPost = view.getPage("AddPost");
    	scrollBox.getChildren().add(addPost);
    	try {
    	List<Post> posts = ourDb.checkListPost(sg.getCode());
    	int j = posts.size();
    	String s = Integer.toString(j);
    	sg.setPostId(s);
		for(int i=j-1; i>=0;i--) {
			sg.setPost(posts.get(i));
			Pane pane = view.getPage("Post");
			scrollBox.getChildren().add(pane);
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
	
    }
    
	
}
