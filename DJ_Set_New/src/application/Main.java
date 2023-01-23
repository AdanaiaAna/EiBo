package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import scenes.DjView;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	
	 Stage primaryStage;
	 Pane StartView; 
	 Pane DjView;
	
	
	@Override
	public void start(Stage primaryStage) {
		
		this.DjView = new DjView();
		
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,1200,800);
			
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			scene.setRoot(DjView);
			
			primaryStage.show();
			
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
