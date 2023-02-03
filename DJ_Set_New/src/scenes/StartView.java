package scenes;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class StartView extends BorderPane {
	
	Button play;
	
	public StartView() {
		
		VBox start_background = new VBox();
		ImageView image = new ImageView(new Image("/images/StartBild.png"));
		image.setPreserveRatio(true);
		image.setFitWidth(1100);
		start_background.setId("start_background");
		
		play = new Button("Play");
		
		play.setId("playButton");
		
		start_background.getChildren().addAll(image,play);
		
		
		
		this.setCenter(start_background);
	}
		
	public Button getPlayButton() {
		return play;
	}
	
	
	
	
}
