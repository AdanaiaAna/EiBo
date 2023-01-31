package scenes;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class StartView extends BorderPane {
	
	Button play;
	
	public StartView() {
		
		play = new Button("Play");
		
		this.getChildren().addAll(play);
		
		
		
	}
		
	
	
}
