package scenes;

import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;

public abstract class ViewController {
	
	protected Pane currentView;
	
	//Getter f�r die aktuelle View
	public Pane getView () {
		return currentView;
	}
	
	abstract public void initialize();
	
	abstract public ToggleButton getToggleButton();

}
