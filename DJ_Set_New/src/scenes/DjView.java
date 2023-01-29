package scenes;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class DjView extends BorderPane {
	
	Button button_1_1;
	Button button_1_2;
	Button button_1_3;
	Button button_1_4;
	ToggleButton record_start;
	Label time;
	
	/**
	 * 
	 */
	public DjView() {
		
		HBox overall = new HBox();
		
		// -----------------1. Spalte --------------------------
		
		VBox buttons_1 = new VBox();
		
		HBox hbox_buttons_1_1 = new HBox();
		HBox hbox_buttons_1_2 = new HBox();
		HBox hbox_extra_buttons_1 = new HBox();
		
		buttons_1.getChildren().addAll(hbox_buttons_1_1,hbox_buttons_1_2, hbox_extra_buttons_1);
		
		button_1_1 = new Button("Drums 1"); 
		button_1_2 = new Button("Drums 2");
		button_1_3 = new Button("Drums 3");
		button_1_4 = new Button("Drums 4");
		
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
		
		
		// ---------------------- 3. Spalte ------------------------------
		
				VBox buttons_3 = new VBox();
				
				HBox hbox_buttons_3_1 = new HBox();
				HBox hbox_buttons_3_2 = new HBox();
				
				Button button_3_1 = new Button("Bass 1"); 
				Button button_3_2 = new Button("Bass 2");
				Button button_3_3 = new Button("Bass 3");
				Button button_3_4 = new Button("Bass 4");
				
				hbox_buttons_3_1.getChildren().addAll(button_3_1, button_3_2);
				hbox_buttons_3_2.getChildren().addAll(button_3_3, button_3_4);
				
				/*button_3_1.getStyleClass().add("round_button");
				button_3_2.getStyleClass().add("round_button");
				button_3_3.getStyleClass().add("round_button");
				button_3_4.getStyleClass().add("round_button"); */
				
				button_3_1.setId("button_3_round");
				button_3_2.setId("button_3_round");
				button_3_3.setId("button_3_round");
				button_3_4.setId("button_3_round");
				
				Button stop = new Button("Stop");
				stop.setId("stop_btn");
				
				Slider slider = new Slider(0, 1, 0.5);
				
				buttons_3.getChildren().addAll(hbox_buttons_3_1, hbox_buttons_3_2, stop, slider);
				
				buttons_3.setId("buttons_3");
		
				
		// ------------------------ 4. Spalte --------------------------------
				
				VBox buttons_4 = new VBox();
				
				record_start = new ToggleButton("⏹"); 
				time = new Label("00:00");
				time.setVisible(false);
				time.setId("time-label");
				time.setManaged(false);
				Button button_4_1 = new Button("1");
				Button button_4_2 = new Button("2");
				Button button_4_3 = new Button("3");
				Button button_4_4 = new Button("4");
				
				
				this.setRight(buttons_4);
				
				buttons_4.getChildren().addAll(record_start, time, button_4_1, button_4_2, button_4_3, button_4_4);
				
				buttons_4.setId("buttons_4");
				record_start.setId("record_btn");		
				
		// --------------------------------------------------------------
		
		
		overall.getChildren().addAll(buttons_1, buttons_2,buttons_3,buttons_4);
		this.setCenter(overall);
		
		HBox.setHgrow(buttons_1, Priority.ALWAYS);
		HBox.setHgrow(buttons_2, Priority.ALWAYS);
		HBox.setHgrow(buttons_3, Priority.ALWAYS);
		HBox.setHgrow(buttons_4, Priority.ALWAYS);
		
		// --------------------------------------------------------------
		
		
		
		
		
		
		
		
		//this.getChildren().addAll(buttons_1, hbox_buttons_1);
		
		
		
	
	}

}





