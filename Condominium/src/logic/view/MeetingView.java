 package logic.view;

import javafx.application.Application;
import javafx.stage.Stage;
import logic.controller.ViewController;
import logic.model.UserSingleton;

public class MeetingView extends Application{

	
	private ViewController view = new ViewController();
	private static UserSingleton sg = UserSingleton.getInstance();
	
	@Override
	public void start(Stage primaryStage) {		
		view.loadPage("Meeting", primaryStage);
	}	
	
	
}
