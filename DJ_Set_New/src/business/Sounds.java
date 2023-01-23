package business;

import de.hsrm.mi.eibo.simpleplayer.SimpleAudioPlayer;
import de.hsrm.mi.eibo.simpleplayer.SimpleMinim;

public class Sounds {
	
	private SimpleMinim minim;
	private SimpleAudioPlayer audioPlayer;
	
	
	public Sounds() {
		
		minim = new SimpleMinim(true);
		
	}
	
	public void play(String name) {
		
		audioPlayer = minim.loadMP3File(name);
		audioPlayer.loop();
		
	}
	
	

}
