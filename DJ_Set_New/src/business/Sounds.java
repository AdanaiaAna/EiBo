package business;

import java.util.LinkedList;
import java.util.List;

import de.hsrm.mi.eibo.simpleplayer.SimpleAudioPlayer;
import de.hsrm.mi.eibo.simpleplayer.SimpleMinim;

public class Sounds {
	
	private SimpleMinim minim;
	private List<SimpleAudioPlayer> soundlist = new LinkedList<SimpleAudioPlayer>();

	public Sounds() {
		minim = new SimpleMinim(true);
		initialize();
	}

	public void initialize() {
		soundlist.add(minim.loadMP3File("Sounds/drum1.mp3"));
		soundlist.add(minim.loadMP3File("Sounds/drums2.mp3"));
		soundlist.add(minim.loadMP3File("Sounds/drums3.mp3"));
		soundlist.add(minim.loadMP3File("Sounds/drums4.mp3"));
	}

	public void playLoop(int sound) {
		if (sound < soundlist.size() && sound >= 0) {
			soundlist.get(sound).loop();
		}
	}

	public void endLoop(int sound) {
		if (sound < soundlist.size() && sound >= 0) {
			soundlist.get(sound).pause();
			soundlist.get(sound).rewind();
		}
	}

	public boolean getAudioPlayerIsPlaying(int sound) {
		return soundlist.get(sound).isPlaying();
	}
	
	

}
