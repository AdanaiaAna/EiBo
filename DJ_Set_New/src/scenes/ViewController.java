package scenes;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public abstract class ViewController {
	
	protected Pane currentView;
	
	//Getter f�r die aktuelle View
	public Pane getView () {
		return currentView;
	}
	
	abstract public void initialize();
	
	public abstract Button getButton();

}
