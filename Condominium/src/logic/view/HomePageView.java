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
import logic.controller.HomePageController;
import logic.controller.ViewController;
import logic.model.Post;
import logic.model.UserSingleton;

public class HomePageView extends Application implements Initializable {

	private ViewController view = new ViewController();
	private static UserSingleton sg = UserSingleton.getInstance();
	private HomePageController controller = new HomePageController();
	private PostView post = new PostView();
	
	
	//scrollBox.getChildren().add
    @FXML
    private VBox scrollBox;
    
    
    @Override
	  public void initialize(URL location, ResourceBundle resources){
    	  	
    	try {
    		
    		controller.getListofPost(sg.getAdministrator().getCondominiumCode());
			List<Post> list = sg.getList();
			for(int i = 0; i<= list.size(); i++){
				post.setUpPost(list.get(i).getText());
				Pane pane = view.getPage("Post");
				
				scrollBox.getChildren().add(pane);
			}
		
		}catch(Exception e) {
			
		}
    	
    	/*try {
		controller.getListofPost(sg.getAdministrator().getCondominiumCode());
		List<Post> list = sg.getList();
		Node[] node = new Node[list.size()];
		for(int i = 0; i< list.size(); i++){
			//node[i] = FXMLLoader.load(getClass().getResource("/logic/view/fxml/Post.fxml"));
			//post.createPost(list.get(i).getUser(), list.get(i).getText(), list.get(i).getImage(), "ciao");
			 scrollbarBox.getChildren().add(node[i]);

		}
		}catch(Exception e) {
			
		}*/

		
        /*Node[] nodes = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getResource("/logic/view/fxml/Post.fxml"));

                //give the items some effect

                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #0A0E3F");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color : #02030A");
                });
                
                scrollbarBox.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
    	
    }

    public void loadPosts(List<Post> list) {
    	
    }
    
    
	@Override
	public void start(Stage primaryStage) {		
		view.loadPage("HomePage", primaryStage);
	}	
	
	
}
