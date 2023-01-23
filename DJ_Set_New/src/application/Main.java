package application;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import scenes.DjView;
import scenes.DjViewController;
import scenes.ViewController;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	
	 Stage primaryStage;
	 Pane StartView; 
	 Pane DjView;
	 ViewController controller;
	
	@Override
	public void start(Stage primaryStage) {
		
		controller = new DjViewController();
		this.DjView = new DjView();
		
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,1200,800);
			
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			scene.setRoot(controller.getView());
			
			primaryStage.show();
			
			
			//beendet das Programm beim Schließen des Fensters
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			    @Override
			    public void handle(WindowEvent t) {
			        Platform.exit();
			        System.exit(0);
			    }
			});
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
