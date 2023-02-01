package scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class AlertPane extends HBox {
	
	Button yes;
	Button no;
	
	
	public AlertPane() {
		// Label
		HBox all = new HBox();
		Label infoLabel = new Label("Save recording?");
		infoLabel.setStyle("-fx-text-fill: black;");
		infoLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
		
		
		// Buttons
		HBox button = new HBox();
		yes = new Button("YES");
		no = new Button("NO");
		button.getChildren().addAll(yes, no);
		button.setSpacing(15);
		button.setId("Button-Container");
		// Pane
		all.getChildren().addAll(infoLabel, button);
	
		this.getChildren().addAll(infoLabel, button);
		this.setStyle("-fx-background-color: white;");
		this.setPrefHeight(100);
		this.setMaxHeight(100);
		this.setSpacing(60);
		this.setAlignment(Pos.CENTER);

	}
	
	public Button getYesButton() {
		return yes;
	}
	public Button getNoButton() {
		return no;
	}
}
