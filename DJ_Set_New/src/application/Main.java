package application;

import java.util.HashMap;

import business.Sounds;
import javafx.animation.Interpolator;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import scenes.AlertPane;
import scenes.DjView;
import scenes.DjViewController;
import scenes.StartView;
import scenes.ViewController;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class Main extends Application {

	Stage primaryStage;
	StartView startView;
	Pane DjView;
	ViewController controller;
	Button play;
	Button yesButton;
	Button noButton;
	ToggleButton record_start;
	public HashMap<String, Pane> scenes;
	Pane root;
	Scene scene;
	Sounds sound;
	AlertPane alertPane;

	@Override
	public void start(Stage primaryStage) {
		/*
		 * controller = new DjViewController(); DjView = new DjView(); startView = new
		 * StartView();
		 * 
		 * play = startView.getPlayButton();
		 */

		try {

			
			initialize();
			root = scenes.get("StartView");
			scene = new Scene(root, 1200, 800);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			// Icon von der App
			Image icon = new Image("/images/dj_icon.png");
			primaryStage.getIcons().add(icon);
			primaryStage.setTitle("DJ Set");

			primaryStage.setScene(scene);

			// scene.setRoot(controller.getView());
			scene.setRoot(root);

			primaryStage.show();
			play.setOnAction(event -> playButtonHandler(event));

			// beendet das Programm beim Schließen des Fensters
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent t) {
					Platform.exit();
					System.exit(0);

				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initialize() {
		sound = new Sounds();
		startView = new StartView();
		play = startView.getPlayButton();
		controller = new DjViewController(sound);
		scenes = new HashMap<String, Pane>();
		scenes.put("StartView", startView);

		alertPane = new AlertPane();
		yesButton = alertPane.getYesButton();
		noButton = alertPane.getNoButton();
		StackPane djView = new StackPane();
		record_start = controller.getToggleButton();
		djView.getChildren().addAll(controller.getView(), alertPane);
		StackPane.setAlignment(alertPane, Pos.BOTTOM_CENTER);
		alertPane.setTranslateY(alertPane.getPrefHeight());
		scenes.put("DJ-View", djView);

		record_start.setOnAction(event -> {
			if (record_start.isSelected()) {
				sound.record();

			} else {
				sound.endRecording();
				SequentialTransition anim = new SequentialTransition();

				TranslateTransition transitionAnim = new TranslateTransition();
				transitionAnim.setNode(alertPane);
				transitionAnim.setToY(0);
				transitionAnim.setDuration(Duration.millis(250));
				transitionAnim.setInterpolator(Interpolator.EASE_OUT);
				anim.getChildren().addAll(transitionAnim);
				anim.playFromStart();
			}
		});
		yesButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				sound.saveRecording();
				moveDown();
			}
		});
		
		noButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				moveDown();
			}
		});
	}

	public void playButtonHandler(ActionEvent e) {
		root = scenes.get("DJ-View");
		scene.setRoot(root);
	}
	
	public void moveDown() {

		SequentialTransition anim = new SequentialTransition();
		TranslateTransition transitionAnimBack = new TranslateTransition();
		transitionAnimBack.setNode(alertPane);
		transitionAnimBack.setToY(alertPane.getPrefHeight());
		transitionAnimBack.setDuration(Duration.millis(200));
		transitionAnimBack.setInterpolator(Interpolator.EASE_IN);
		anim.getChildren().addAll(transitionAnimBack);
		anim.playFromStart();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
