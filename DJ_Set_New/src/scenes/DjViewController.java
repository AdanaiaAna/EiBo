package scenes;

import business.Sounds;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;

public class DjViewController extends ViewController {
	
	// Drums
	private Button drum_1;
	private Button drum_2;
	private Button drum_3;
	private Button drum_4;
	
	private Button drum_extra_1;
	private Button drum_extra_2;
	
	//Gitarre 1
	private Button guitar_1_1;
	private Button guitar_1_2;
	private Button guitar_1_3;
	private Button guitar_1_4;
	
	// Gitarre 2
	private Button guitar_2_1;
	private Button guitar_2_2;
	private Button guitar_2_3;
	private Button guitar_2_4;
	
	//Bass_Gitarre
	private Button bass_1;
	private Button bass_2;
	private Button bass_3;
	private Button bass_4;
	
	// Recording 
	private ToggleButton record_start;
	private Label time;
	
	// OneShots
	private Button oneShot_1;
	private Button oneShot_2;
	private Button oneShot_3;
	private Button oneShot_4;
	
	
	private Sounds sound;
	private final int DRUM1 = 0;
	private final int DRUM2 = 1;
	private final int DRUM3 = 2;
	private final int DRUM4 = 3;
	
	private final int OS1 = 0;

	public DjViewController() {
		sound = new Sounds();
		currentView = new DjView();
		DjView view = (DjView) currentView;

		drum_1 = view.drum_1;
		drum_2 = view.drum_2;
		drum_3 = view.drum_3;
		drum_4 = view.drum_4;
		
		drum_extra_1 = view.drum_extra_1;
		drum_extra_2 = view.drum_extra_2;
		
		guitar_1_1 = view.guitar_1_1;
		guitar_1_2 = view.guitar_1_2;
		guitar_1_3 = view.guitar_1_3;
		guitar_1_4 = view.guitar_1_4;
		
		guitar_2_1 = view.guitar_2_1;
		guitar_2_2 = view.guitar_2_2;
		guitar_2_3 = view.guitar_2_3;
		guitar_2_4 = view.guitar_2_4;
		
		bass_1 = view.bass_1;
		bass_2 = view.bass_2;
		bass_3 = view.bass_3;
		bass_4 = view.bass_4;
		
		oneShot_1 = view.oneShot_1;
		oneShot_2 = view.oneShot_2;
		oneShot_3 = view.oneShot_3;
		oneShot_4 = view.oneShot_4;
		
		
		
		record_start = view.record_start;
		time = view.time;
		oneShot_1 = view.oneShot_1;

		initialize();
	}

	@Override
	public void initialize() {
		drum_1.setOnAction(event -> {
			if (!sound.getAudioPlayerIsPlaying(DRUM1, sound.getDrumLoops())) {
				sound.playLoop(DRUM1, sound.getDrumLoops());
			} else {
				sound.endLoop(DRUM1, sound.getDrumLoops());
			}
		});
		
		drum_2.setOnAction(event -> {
			if (!sound.getAudioPlayerIsPlaying(DRUM2, sound.getDrumLoops())) {
				sound.playLoop(DRUM2, sound.getDrumLoops());
			} else {
				sound.endLoop(DRUM2, sound.getDrumLoops());
			}
		});
		
		drum_3.setOnAction(event -> {
			if (!sound.getAudioPlayerIsPlaying(DRUM3, sound.getDrumLoops())) {
				sound.playLoop(DRUM3, sound.getDrumLoops());
			} else {
				sound.endLoop(DRUM3, sound.getDrumLoops());
			}
		});
		
		drum_4.setOnAction(event -> {
			if (!sound.getAudioPlayerIsPlaying(DRUM4, sound.getDrumLoops())) {
				sound.playLoop(DRUM4, sound.getDrumLoops());
			} else {
				sound.endLoop(DRUM4, sound.getDrumLoops());
			}
		});
		
		oneShot_1.setOnAction(event -> {
			sound.playOneShot(OS1);
		});
		
		record_start.setOnAction(event -> {
			if (record_start.isSelected()) {
				sound.record();
				time.setVisible(true);
				time.setManaged(true);
				
			} else {
				sound.endRecording();
				time.setVisible(false);
				time.setManaged(false);
			}
		});
		sound.getTimeProperty().addListener(new ChangeListener<Number>() {

			// updated die aktuelle Position des Timebar und das Timelabel
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				Platform.runLater(new Runnable() {
					public void run() {
						// aktuelle Zeit in das Format mm:ss umwandeln
						String timecode = "";
						int currTime = newValue.intValue();
						int minutes = currTime / 60;
						int seconds = currTime % 60;
						if (minutes < 10) {
							timecode += "0" + Integer.toString(minutes);
						}
						timecode += ":";
						if (seconds < 10) {
							timecode += "0" + Integer.toString(seconds);
						} else {
							timecode += Integer.toString(seconds);
						}
						time.setText(timecode);
					}
				});
			}
		});
	}

	@Override
	public Button getButton() {
		// TODO Auto-generated method stub
		return null;
	}

}
