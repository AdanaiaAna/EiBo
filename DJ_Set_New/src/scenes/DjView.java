package scenes;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DjView extends BorderPane {
	
	public DjView() {
		
		HBox overall = new HBox();
		
		// -----------------1. Spalte --------------------------
		
		VBox buttons_1 = new VBox();
		
		HBox hbox_buttons_1_1 = new HBox();
		HBox hbox_buttons_1_2 = new HBox();
		HBox hbox_extra_buttons_1 = new HBox();
		
		buttons_1.getChildren().addAll(hbox_buttons_1_1,hbox_buttons_1_2, hbox_extra_buttons_1);
		
		Button button_1_1 = new Button("Drums 1"); 
		Button button_1_2 = new Button("Drums 2");
		Button button_1_3 = new Button("Drums 3");
		Button button_1_4 = new Button("Drums 4");
		
		Button button_1_5 = new Button("Extra Drums 1");
		Button button_1_6 = new Button("Extra Drums 2");
		
		hbox_buttons_1_1.getChildren().addAll(button_1_1, button_1_2 );
		hbox_buttons_1_2.getChildren().addAll( button_1_3, button_1_4);
		
		hbox_extra_buttons_1.getChildren().addAll(button_1_5,button_1_6);
		
		this.setLeft(buttons_1);
		
		
		//buttons_1.getChildren().addAll(button_1_1, button_1_2 , button_1_3, button_1_4);
		buttons_1.setId("buttons_1");

		
		// ------------------2. Spalte --------------------------
		
		
		
		VBox buttons_2 = new VBox();
		
		HBox hbox_buttons_2_1 = new HBox();
		HBox hbox_buttons_2_2 = new HBox();
		HBox hbox_extra_buttons_2 = new HBox();
		
		
		
		
		Button button_2_1 = new Button("Gitarre 1"); 
		Button button_2_2 = new Button("gitarre 2");
		Button button_2_3 = new Button("Gitarre 3");
		Button button_2_4 = new Button("Gitarre 4");
		
		Button button_2_5 = new Button("Extra Gitarre 1");
		Button button_2_6 = new Button("Extra Gitarre 2");
		
		
		hbox_buttons_2_1.getChildren().addAll(button_2_1, button_2_2 );
		hbox_buttons_2_2.getChildren().addAll( button_2_3, button_2_4);
		
		
		hbox_extra_buttons_2.getChildren().addAll(button_2_5,button_2_6);
		
		buttons_2.getChildren().addAll(hbox_buttons_2_1,hbox_buttons_2_2, hbox_extra_buttons_2);
		this.setCenter(buttons_2);
		
		
		buttons_2.setId("buttons_2");
		
		
		// --------------------------------------------------------------
		
		
		overall.getChildren().addAll(buttons_1, buttons_2);
		this.setCenter(overall);
		
		// --------------------------------------------------------------
		
		
		
		VBox buttons_3 = new VBox();
		
		VBox buttons_4 = new VBox();
		
		
		//this.getChildren().addAll(buttons_1, hbox_buttons_1);
		
		
		
	
	}

}





