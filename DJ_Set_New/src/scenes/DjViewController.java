package scenes;

import business.Sounds;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
	private final int TRACK1 = 0;
	private final int TRACK2 = 1;
	private final int TRACK3 = 2;
	private final int TRACK4 = 3;
	

	public DjViewController(Sounds sound) {
		this.sound = sound;
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
		
		
		// -------Drum Event Handlers--------
		drum_1.setOnAction(event -> {
			if (!sound.getAudioPlayerIsPlaying(TRACK1, sound.getDrumLoops())) {
				sound.playLoop(TRACK1, sound.getDrumLoops());
			} else {
				sound.endLoop(TRACK1, sound.getDrumLoops());
			}
		});
		
		drum_2.setOnAction(event -> {
			if (!sound.getAudioPlayerIsPlaying(TRACK2, sound.getDrumLoops())) {
				sound.playLoop(TRACK2, sound.getDrumLoops());
			} else {
				sound.endLoop(TRACK2, sound.getDrumLoops());
			}
		});
		
		drum_3.setOnAction(event -> {
			if (!sound.getAudioPlayerIsPlaying(TRACK3, sound.getDrumLoops())) {
				sound.playLoop(TRACK3, sound.getDrumLoops());
			} else {
				sound.endLoop(TRACK3, sound.getDrumLoops());
			}
		});
		
		drum_4.setOnAction(event -> {
			if (!sound.getAudioPlayerIsPlaying(TRACK4, sound.getDrumLoops())) {
				sound.playLoop(TRACK4, sound.getDrumLoops());
			} else {
				sound.endLoop(TRACK4, sound.getDrumLoops());
			}
		});
		
		
		// -------Gitarren EventHandler--------
		guitar_1_1.setOnAction(event -> {
			if (!sound.getAudioPlayerIsPlaying(TRACK1, sound.getGuitar1Loops())) {
				sound.playLoop(TRACK1, sound.getGuitar1Loops());
			} else {
				sound.endLoop(TRACK1, sound.getGuitar1Loops());
			}
		});
		
		guitar_1_2.setOnAction(event -> {
			if (!sound.getAudioPlayerIsPlaying(TRACK2, sound.getGuitar1Loops())) {
				sound.playLoop(TRACK2, sound.getGuitar1Loops());
			} else {
				sound.endLoop(TRACK2, sound.getGuitar1Loops());
			}
		});
		
		guitar_1_3.setOnAction(event -> {
			if (!sound.getAudioPlayerIsPlaying(TRACK3, sound.getGuitar1Loops())) {
				sound.playLoop(TRACK3, sound.getGuitar1Loops());
			} else {
				sound.endLoop(TRACK3, sound.getGuitar1Loops());
			}
		});
		
		guitar_1_4.setOnAction(event -> {
			if (!sound.getAudioPlayerIsPlaying(TRACK4, sound.getGuitar1Loops())) {
				sound.playLoop(TRACK4, sound.getGuitar1Loops());
			} else {
				sound.endLoop(TRACK4, sound.getGuitar1Loops());
			}
		});
		
		guitar_2_1.setOnAction(event -> {
			if (!sound.getAudioPlayerIsPlaying(TRACK1, sound.getGuitar2Loops())) {
				sound.playLoop(TRACK1, sound.getGuitar2Loops());
			} else {
				sound.endLoop(TRACK1, sound.getGuitar2Loops());
			}
		});
		
		guitar_2_2.setOnAction(event -> {
			if (!sound.getAudioPlayerIsPlaying(TRACK2, sound.getGuitar2Loops())) {
				sound.playLoop(TRACK2, sound.getGuitar2Loops());
			} else {
				sound.endLoop(TRACK2, sound.getGuitar2Loops());
			}
		});
		
		guitar_2_3.setOnAction(event -> {
			if (!sound.getAudioPlayerIsPlaying(TRACK3, sound.getGuitar2Loops())) {
				sound.playLoop(TRACK3, sound.getGuitar2Loops());
			} else {
				sound.endLoop(TRACK3, sound.getGuitar2Loops());
			}
		});
		
		guitar_2_4.setOnAction(event -> {
			if (!sound.getAudioPlayerIsPlaying(TRACK4, sound.getGuitar2Loops())) {
				sound.playLoop(TRACK4, sound.getGuitar2Loops());
			} else {
				sound.endLoop(TRACK4, sound.getGuitar2Loops());
			}
		});
		
		bass_1.setOnAction(event -> {
			if (!sound.getAudioPlayerIsPlaying(TRACK1, sound.getBassLoops())) {
				sound.playLoop(TRACK1, sound.getBassLoops());
			} else {
				sound.endLoop(TRACK1, sound.getBassLoops());
			}
		});
		bass_2.setOnAction(event -> {
			if (!sound.getAudioPlayerIsPlaying(TRACK2, sound.getBassLoops())) {
				sound.playLoop(TRACK2, sound.getBassLoops());
			} else {
				sound.endLoop(TRACK2, sound.getBassLoops());
			}
		});
		bass_3.setOnAction(event -> {
			if (!sound.getAudioPlayerIsPlaying(TRACK3, sound.getBassLoops())) {
				sound.playLoop(TRACK3, sound.getBassLoops());
			} else {
				sound.endLoop(TRACK3, sound.getBassLoops());
			}
		});
		bass_4.setOnAction(event -> {
			if (!sound.getAudioPlayerIsPlaying(TRACK4, sound.getBassLoops())) {
				sound.playLoop(TRACK4, sound.getBassLoops());
			} else {
				sound.endLoop(TRACK4, sound.getBassLoops());
			}
		});
		
		
		// --------OneShots----------
		oneShot_1.setOnAction(event -> {
			sound.playOneShot(TRACK1);
		});
		
		oneShot_2.setOnAction(event -> {
			sound.playOneShot(TRACK2);
		});
		
		oneShot_3.setOnAction(event -> {
			sound.playOneShot(TRACK3);
		});
		
		oneShot_4.setOnAction(event -> {
			sound.playOneShot(TRACK4);
		});
		
		/*
		
		record_start.setOnAction(event -> {
			if (record_start.isSelected()) {
				sound.record();
				
				
			} else {
				//sound.endRecording();
			}
		});*/
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
		
	}// End of initialize

	@Override
	public ToggleButton getToggleButton() {
		return record_start;
	}

}
