package scenes;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class StartView extends BorderPane {
	
	Button play;
	
	public StartView() {
		
		VBox start_background = new VBox();
		start_background.setId("start_background");
		
		play = new Button("Play");
		
		play.setId("playButton");
		
		start_background.getChildren().addAll(play);
		
		
		
		this.setCenter(start_background);
	}
		
	public Button getPlayButton() {
		return play;
	}
	
	
	
	
}
