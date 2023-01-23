package scenes;

import business.Sounds;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class DjViewController extends ViewController {
	
	private Button button_1_1;
	private Sounds sound;
	
	public DjViewController () {
		
		sound = new Sounds();
		currentView = new DjView();
		DjView view = (DjView) currentView;
		
		button_1_1 = view.button_1_1;
		
		initialize();
	}

	@Override
	public void initialize() {
		button_1_1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				sound.play("C:\\Users\\annam\\Documents\\GitHub\\EiBo\\DJ_Set_New\\Sounds\\drum1.mp3");
				
			}
			
		});
		
	}

	@Override
	public Button getButton() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
