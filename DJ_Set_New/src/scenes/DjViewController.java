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

	private Button button_1_1;
	private Button button_1_2;
	private Button button_1_3;
	private Button button_1_4;
	
	private ToggleButton record_start;
	private Label time;
	Button button_4_1;
	Button button_4_2;
	Button button_4_3;
	Button button_4_4;
	
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

		button_1_1 = view.button_1_1;
		button_1_2 = view.button_1_2;
		button_1_3 = view.button_1_3;
		button_1_4 = view.button_1_4;
		record_start = view.record_start;
		time = view.time;
		button_4_1 = view.button_4_1;

		initialize();
	}

	@Override
	public void initialize() {
		button_1_1.setOnAction(event -> {
			if (!sound.getAudioPlayerIsPlaying(DRUM1)) {
				sound.playLoop(DRUM1);
			} else {
				sound.endLoop(DRUM1);
			}
		});
		
		button_1_2.setOnAction(event -> {
			if (!sound.getAudioPlayerIsPlaying(DRUM2)) {
				sound.playLoop(DRUM2);
			} else {
				sound.endLoop(DRUM2);
			}
		});
		
		button_1_3.setOnAction(event -> {
			if (!sound.getAudioPlayerIsPlaying(DRUM3)) {
				sound.playLoop(DRUM3);
			} else {
				sound.endLoop(DRUM3);
			}
		});
		
		button_1_4.setOnAction(event -> {
			if (!sound.getAudioPlayerIsPlaying(DRUM4)) {
				sound.playLoop(DRUM4);
			} else {
				sound.endLoop(DRUM4);
			}
		});
		
		button_4_1.setOnAction(event -> {
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
