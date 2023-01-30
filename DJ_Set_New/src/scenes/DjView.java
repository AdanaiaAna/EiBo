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
	
	// Drums
	Button drum_1;
	Button drum_2;
	Button drum_3;
	Button drum_4;
	
	Button drum_extra_1;
	Button drum_extra_2;
	
	//Gitarre 1
	Button guitar_1_1;
	Button guitar_1_2;
	Button guitar_1_3;
	Button guitar_1_4;
	
	// Gitarre 2
	Button guitar_2_1;
	Button guitar_2_2;
	Button guitar_2_3;
	Button guitar_2_4;
	
	//Bass_Gitarre
	Button bass_1;
	Button bass_2;
	Button bass_3;
	Button bass_4;
	
	//  Oneshots
	Button oneShot_1;
	Button oneShot_2;
	Button oneShot_3;
	Button oneShot_4;
	
	
	
	ToggleButton record_start;
	Label time;
	
	/**
	 * 
	 */
	public DjView() {
		
		HBox overall = new HBox();
		
		// -----------------1. Spalte --------------------------
		
		VBox row_1 = new VBox();
		
		HBox hbox_drums_1 = new HBox();
		HBox hbox_drums_2 = new HBox();
		HBox hbox_drums_extra = new HBox();
		
		row_1.getChildren().addAll(hbox_drums_1,hbox_drums_2, hbox_drums_extra);
		
		drum_1 = new Button("Drum 1"); 
		drum_2 = new Button("Drum 2");
		drum_3 = new Button("Drum 3");
		drum_4 = new Button("Drum 4");
		
		drum_extra_1 = new Button("Extra Drum 1");
		drum_extra_2 = new Button("Extra Drum 2");
		
		hbox_drums_1.getChildren().addAll(drum_1, drum_2 );
		hbox_drums_2.getChildren().addAll( drum_3, drum_4);
		
		hbox_drums_extra.getChildren().addAll(drum_extra_1,drum_extra_2);
		
		this.setLeft(row_1);
		
		
		//buttons_1.getChildren().addAll(button_1_1, button_1_2 , button_1_3, button_1_4);
		row_1.setId("buttons_1");

		
		// ------------------2. Spalte --------------------------
		
		
		
		VBox row_2 = new VBox();
		
		HBox hbox_guitars_1_1 = new HBox();
		HBox hbox_guitars_1_2 = new HBox();
		HBox hbox_guitars_2_1 = new HBox();
		HBox hbox_guitars_2_2 = new HBox();
		
		
		guitar_1_1 = new Button("Gitarre (1) 1"); 
		guitar_1_2 = new Button("Gitarre (1) 2");
		guitar_1_3 = new Button("Gitarre (1) 3");
		guitar_1_4 = new Button("Gitarre (1) 4");
		
		guitar_2_1 = new Button("Gitarre (2) 1"); 
		guitar_2_2 = new Button("Gitarre (2) 2");
		guitar_2_3 = new Button("Gitarre (2) 3");
		guitar_2_4 = new Button("Gitarre (2) 4");
		
		Button button_2_5 = new Button("Extra Gitarre 1");
		Button button_2_6 = new Button("Extra Gitarre 2");
		
		
		hbox_guitars_1_1.getChildren().addAll(guitar_1_1, guitar_1_2 );
		hbox_guitars_1_2.getChildren().addAll( guitar_1_3, guitar_1_4);
		
		hbox_guitars_2_1.getChildren().addAll(guitar_2_1,guitar_2_2);
		hbox_guitars_2_2.getChildren().addAll(guitar_2_3,guitar_2_4);
		
		row_2.getChildren().addAll(hbox_guitars_1_1,hbox_guitars_1_2, hbox_guitars_2_1, hbox_guitars_2_2);
		this.setCenter(row_2);
		
		
		row_2.setId("buttons_2");
		
		
		// ---------------------- 3. Spalte ------------------------------
		
		VBox row_3 = new VBox();
				
		HBox hbox_bass_1 = new HBox();
		HBox hbox_bass_2 = new HBox();
				
		bass_1 = new Button("Bass 1"); 
		bass_2 = new Button("Bass 2");
		bass_3 = new Button("Bass 3");
		bass_4 = new Button("Bass 4");
				
		hbox_bass_1.getChildren().addAll(bass_1, bass_2);
		hbox_bass_2.getChildren().addAll(bass_3, bass_4);
				
				
		bass_1.setId("button_3_round");
		bass_2.setId("button_3_round");
		bass_3.setId("button_3_round");
		bass_4.setId("button_3_round");
		
		
		Button stop = new Button("Stop");
		stop.setId("stop_btn");
				
		Slider slider = new Slider(0, 1, 0.5);
				
		row_3.getChildren().addAll(hbox_bass_1, hbox_bass_2, stop, slider);
				
		row_3.setId("buttons_3");
		
				
		
		// ------------------------ 4. Spalte --------------------------------
				
		VBox row_4 = new VBox();
				
		record_start = new ToggleButton("⏹"); 
		time = new Label("00:00");
		time.setVisible(false);
		time.setId("time-label");
		time.setManaged(false);
		oneShot_1 = new Button(" OneShot 1");
		oneShot_2 = new Button("OneShot 2");
		oneShot_3 = new Button("OneShot 3");
		oneShot_4 = new Button("OneShot 4");
				
				
		this.setRight(row_4);
				
		row_4.getChildren().addAll(record_start, time, oneShot_1, oneShot_2, oneShot_3, oneShot_4);
				
		row_4.setId("buttons_4");
		record_start.setId("record_btn");		
				
		// --------------------------------------------------------------
		
		
		overall.getChildren().addAll(row_1, row_2,row_3,row_4);
		this.setCenter(overall);
		
		HBox.setHgrow(row_1, Priority.ALWAYS);
		HBox.setHgrow(row_2, Priority.ALWAYS);
		HBox.setHgrow(row_3, Priority.ALWAYS);
		HBox.setHgrow(row_4, Priority.ALWAYS);
		
		// --------------------------------------------------------------
		
		
		
		
		//this.getChildren().addAll(buttons_1, hbox_buttons_1);
		
		
		
	
	}

}





