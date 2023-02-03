package scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	
	Slider volumeSlider;
	
	ToggleButton record_start;
	Label time;
	
	Button stop;
	/**
	 * 
	 */
	public DjView() {
		VBox overall = new VBox();
		HBox soundButtons = new HBox();
		overall.setId("dj_background");
		
		// -----------------1. Spalte --------------------------
		
		VBox row_1 = new VBox();
		
		HBox hbox_drums_1 = new HBox();
		hbox_drums_1.setId("Drum-Buttons");
		HBox hbox_drums_2 = new HBox();
		hbox_drums_2.setId("Drum-Buttons");
		HBox hbox_drums_extra = new HBox();
		hbox_drums_extra.setId("Drum-Buttons");
		
		ImageView line = new ImageView(new Image("/images/Line_1.png", 350, 12, false, false));
        ImageViewPane imagPane = new ImageViewPane(line);
		row_1.getChildren().addAll(hbox_drums_1,hbox_drums_2,imagPane, hbox_drums_extra);
		
		//1. Button Reihe
		drum_1 = new Button("Drum 1"); 
		drum_2 = new Button("Drum 2");
		drum_1.setId("Drum");
		drum_2.setId("Drum");
		
		//2.
		drum_3 = new Button("Drum 3");
		drum_4 = new Button("Drum 4");
		drum_3.setId("Drum");
		drum_4.setId("Drum");
		
		
		drum_extra_1 = new Button("Extra Drum 1");
		drum_extra_2 = new Button("Extra Drum 2");
		drum_extra_1.setId("Drum_Extra");
		drum_extra_2.setId("Drum_Extra");
		
		
		hbox_drums_1.getChildren().addAll(drum_1, drum_2 );
		hbox_drums_2.getChildren().addAll( drum_3, drum_4);
		
		hbox_drums_extra.getChildren().addAll(drum_extra_1,drum_extra_2);
		
		this.setLeft(row_1);
		
		
		//buttons_1.getChildren().addAll(button_1_1, button_1_2 , button_1_3, button_1_4);
		row_1.setId("row");

		
		// ------------------2. Spalte --------------------------
		
		VBox row_2 = new VBox();
		
		HBox hbox_guitars_1_1 = new HBox();
		HBox hbox_guitars_1_2 = new HBox();
		HBox hbox_guitars_2_1 = new HBox();
		HBox hbox_guitars_2_2 = new HBox();
		
		hbox_guitars_1_1.setId("Gitarren-Buttons");
		hbox_guitars_1_2.setId("Gitarren-Buttons");
		hbox_guitars_2_1.setId("Gitarren-Buttons");
		hbox_guitars_2_2.setId("Gitarren-Buttons");
		
		
		guitar_1_1 = new Button("Gitarre (1) 1"); 
		guitar_1_2 = new Button("Gitarre (1) 2");
		guitar_1_3 = new Button("Gitarre (1) 3");
		guitar_1_4 = new Button("Gitarre (1) 4");
		
		guitar_2_1 = new Button("Gitarre (2) 1"); 
		guitar_2_2 = new Button("Gitarre (2) 2");
		guitar_2_3 = new Button("Gitarre (2) 3");
		guitar_2_4 = new Button("Gitarre (2) 4");	
		
		guitar_1_1.setId("Guitar_1");
		guitar_1_2.setId("Guitar_1");
		guitar_1_3.setId("Guitar_1");
		guitar_1_4.setId("Guitar_1");
		
		guitar_2_1.setId("Guitar_2");
		guitar_2_2.setId("Guitar_2");
		guitar_2_3.setId("Guitar_2");
		guitar_2_4.setId("Guitar_2");
		
		
		hbox_guitars_1_1.getChildren().addAll(guitar_1_1, guitar_1_2 );
		hbox_guitars_1_2.getChildren().addAll( guitar_1_3, guitar_1_4);
		hbox_guitars_1_1.setAlignment(Pos.CENTER);
		hbox_guitars_1_2.setAlignment(Pos.CENTER);
		hbox_guitars_2_1.getChildren().addAll(guitar_2_1,guitar_2_2);
		hbox_guitars_2_2.getChildren().addAll(guitar_2_3,guitar_2_4);
		hbox_guitars_2_1.setAlignment(Pos.CENTER);
		hbox_guitars_2_2.setAlignment(Pos.CENTER);
		
		ImageView line2 = new ImageView(new Image("/images/Line_1.png", 350, 10, false, false));
		ImageViewPane imagPane2 = new ImageViewPane(line2);
		row_2.getChildren().addAll(hbox_guitars_1_1,hbox_guitars_1_2,imagPane2, hbox_guitars_2_1, hbox_guitars_2_2);
		
		this.setCenter(row_2);
		
		
		
		row_2.setId("row");
		
		
		// ---------------------- 3. Spalte ------------------------------
		
		VBox row_3 = new VBox();
				
		HBox hbox_bass_1 = new HBox();
		HBox hbox_bass_2 = new HBox();
				
		bass_1 = new Button("Bass 1"); 
		bass_2 = new Button("Bass 2");
		bass_3 = new Button("Bass 3");
		bass_4 = new Button("Bass 4");
		
		bass_1.setId("Bass");
		bass_2.setId("Bass");
		bass_3.setId("Bass");
		bass_4.setId("Bass");
				
		hbox_bass_1.getChildren().addAll(bass_1, bass_2);
		hbox_bass_1.setAlignment(Pos.CENTER);
		hbox_bass_2.getChildren().addAll(bass_3, bass_4);
		hbox_bass_2.setAlignment(Pos.CENTER);		
		
		hbox_bass_1.setId("Bass-Buttons");
		hbox_bass_2.setId("Bass-Buttons");
		
		
		
		stop = new Button("Stop");
		stop.setId("stop_btn");
				
		volumeSlider = new Slider(0, 1, 0.5);
		HBox.setHgrow(volumeSlider, Priority.ALWAYS);
				
		row_3.getChildren().addAll(hbox_bass_1, hbox_bass_2);
		row_3.setAlignment(Pos.CENTER);		
		row_3.setId("row");
		
				
		
		// ------------------------ 4. Spalte --------------------------------
				
		VBox row_4 = new VBox();
		VBox recording = new VBox();		
		record_start = new ToggleButton(); 
		record_start.setId("Record-Button");
		time = new Label("00:00");
		time.setId("time-label");
		recording.getChildren().addAll(time, record_start);
		recording.setAlignment(Pos.CENTER);
		oneShot_1 = new Button(" OneShot 1");
		oneShot_2 = new Button("OneShot 2");
		oneShot_3 = new Button("OneShot 3");
		oneShot_4 = new Button("OneShot 4");
		
		oneShot_1.setId("Oneshot");
		oneShot_2.setId("Oneshot");
		oneShot_3.setId("Oneshot");
		oneShot_4.setId("Oneshot");
				
				
		this.setRight(row_4);
				
		row_4.getChildren().addAll( oneShot_1, oneShot_2, oneShot_3, oneShot_4);
				
		row_4.setId("row");
		row_4.setAlignment(Pos.CENTER);		
				
		// --------------------------------------------------------------
		HBox bottomRow = new HBox();
		bottomRow.setId("Bottom");
		bottomRow.getChildren().addAll(volumeSlider, stop, recording);
		bottomRow.setAlignment(Pos.BOTTOM_CENTER);
		bottomRow.setPadding(new Insets(30, 10, 10, 30));
		bottomRow.setSpacing(100);
		this.setBottom(bottomRow);
		
		soundButtons.getChildren().addAll(row_1, row_2,row_3,row_4);
		overall.getChildren().addAll(soundButtons, bottomRow);
		this.setCenter(overall);
		
		HBox.setHgrow(row_1, Priority.ALWAYS);
		HBox.setHgrow(row_2, Priority.ALWAYS);
		HBox.setHgrow(row_3, Priority.ALWAYS);
		HBox.setHgrow(row_4, Priority.ALWAYS);
		VBox.setVgrow(bottomRow, Priority.ALWAYS);
		
		// --------------------------------------------------------------
		
		
		
		
		//this.getChildren().addAll(buttons_1, hbox_buttons_1);
		
		
		
	
	}

}





