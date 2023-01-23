package scenes;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class DjView extends BorderPane {
	
	public DjView() {
		//hi
		Label label = new Label("Mein Label");
		
		VBox buttons_1 = new VBox();
		Button button_1_1 = new Button(); 
		Button button_1_2 = new Button("halohalo");
		Button button_1_3 = new Button();
		Button button_1_4 = new Button();
		
		buttons_1.getChildren().addAll(button_1_1, button_1_2 , button_1_3, button_1_4);
		buttons_1.setId("buttons_1");

		button_1_1.setText("Hello World"); 
		
		
		VBox buttons_2 = new VBox();
		Button button_2_1 = new Button(); 
		Button button_2_2 = new Button();
		Button button_2_3 = new Button();
		Button button_2_4 = new Button();
		
		buttons_1.getChildren().addAll(button_2_1, button_2_2 , button_2_3, button_2_4);
		
		
		VBox buttons_3 = new VBox();
		
		VBox buttons_4 = new VBox();
		//this.getChildren().addAll(buttons_1, buttons_2);
		
		this.setCenter(buttons_1);
		
		// fuck my life
	}

}





