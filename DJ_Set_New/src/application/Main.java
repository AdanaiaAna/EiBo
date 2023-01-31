package application;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import scenes.DjView;
import scenes.DjViewController;
import scenes.StartView;
import scenes.ViewController;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	
	 Stage primaryStage;
	 StartView startView; 
	 Pane DjView;
	 ViewController controller;
	 Button play;
	 Pane root;
	 Scene scene;
	
	@Override
	public void start(Stage primaryStage) {
		
		controller = new DjViewController();
		DjView = new DjView();
		startView = new StartView();
		
		play = startView.getPlayButton();
		

		try {
			
			/* !!!!DAS IST FÜR FXML!!!!!
			Parent root = FXMLLoader.load(getClass().getResource("/Fxml.fxml"));
			Scene scene = new Scene(root);
			
			scene.getStylesheets().add(getClass().getResource("FmlCss.css").toExternalForm());
			
			
			primaryStage.setScene(scene);
			primaryStage.show();
			*/
			
			
			
			root = new BorderPane();
			scene = new Scene(root,1200,800);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			//scene.setRoot(controller.getView());
			scene.setRoot(startView);
			
			primaryStage.show();
			play.setOnAction(event -> playButtonHandler(event));
			
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
	
	public void playButtonHandler(ActionEvent e) {
		 root = controller.getView();
        scene.setRoot(root);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
