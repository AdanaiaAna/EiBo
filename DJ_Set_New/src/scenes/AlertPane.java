package scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class AlertPane extends HBox {
	
	Button yesButton;
	Button noButton;
	
	
	public AlertPane() {
		Label infoLabel = new Label("Save recording?");
		infoLabel.setStyle("-fx-text-fill: black;");
		infoLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
		
		
		// Buttons
		HBox button = new HBox();
		yesButton = new Button("YES");
		yesButton.setId("Yes-No-Button");
		noButton = new Button("NO");
		noButton.setId("Yes-No-Button");
		HBox spacer = new HBox();
		spacer.setPadding(new Insets(0,10,0,10));
		button.getChildren().addAll(infoLabel, spacer, yesButton, noButton);
		button.setSpacing(15);
		button.setId("Button-Container");
		HBox.setHgrow(button, Priority.ALWAYS);
	
		this.getChildren().addAll( button);
		this.setStyle("-fx-background-color: white;");
		this.setPrefHeight(100);
		this.setMaxHeight(100);
		this.setSpacing(60);
		this.setAlignment(Pos.CENTER);
	}
	
	public Button getYesButton() {
		return yesButton;
	}
	public Button getNoButton() {
		return noButton;
	}
}
