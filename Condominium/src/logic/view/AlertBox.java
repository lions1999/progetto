package logic.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

	public void display(String title,String message) {
		Stage window = new Stage();
		
		//Layouyt
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(450);
		window.setMinHeight(150);
		
		//alertIcon
		Image icon = new Image("/logic/view/images/WarningIcon.png");
		ImageView image = new ImageView(icon);
		
		//Label 
		Label label = new Label(message,image);		
		label.setFont(new Font("System",18));
		label.setTextFill(Color.RED);
		
		//Button
		Button btn = new Button("OK");
		btn.setOnAction(e->window.close());
		
		//Structure
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label,btn);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
 
}
