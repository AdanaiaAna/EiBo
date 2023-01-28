package scenes;

import business.Sounds;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class DjViewController extends ViewController {

	private Button button_1_1;
	private Button button_1_2;
	private Button button_1_3;
	private Button button_1_4;
	private Sounds sound;
	private final int DRUM1 = 0;
	private final int DRUM2 = 1;
	private final int DRUM3 = 2;
	private final int DRUM4 = 3;
	

	public DjViewController() {
		sound = new Sounds();
		currentView = new DjView();
		DjView view = (DjView) currentView;

		button_1_1 = view.button_1_1;
		button_1_2 = view.button_1_2;
		button_1_3 = view.button_1_3;
		button_1_4 = view.button_1_4;

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

	}

	@Override
	public Button getButton() {
		// TODO Auto-generated method stub
		return null;
	}

}
