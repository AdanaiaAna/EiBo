package scenes;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class StartView extends BorderPane {
	
	Button play;
	
	public StartView() {
		
		play = new Button("Play");
		
		play.setId("playButton");
		
		this.setCenter(play);
		
	}
		
	public Button getPlayButton() {
		return play;
	}
	
	
	
	
}
