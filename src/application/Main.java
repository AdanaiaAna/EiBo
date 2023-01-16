package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	
	 Stage primaryStage;
	 Pane StartView; 
	 scenes.DjView djView;

	
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		 this.djView = new scenes.DjView();
		// this.StartView = new StartView();
		 this.primaryStage = primaryStage;
		 
		 Pane root = new Pane();  //Erzeuge Wurzel-Element, dem alle Elemente hinzugefügt werden
		 Label label = new Label("My Label");
		 
		 Scene scene = new Scene(djView, 1280, 800); //erzeuge die Szene mit dem Wurzel-Element
		 primaryStage.setTitle("DJ Set");
		 primaryStage.setScene(scene); // setze die Szene als aktuelle darzustellende Szene für die Bühne
		 
		 
		 
		 scene.setRoot(djView);
		 
		
		 primaryStage.show();  // es muss explizit gesagt werden, dass das Fenster sichtbar gemacht werden soll
		 
		
		 
		 }
		
	
	public static void main(String[] args) {
		launch(args);
	}
}

