package business;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import ddf.minim.AudioInput;
import ddf.minim.AudioOutput;
import ddf.minim.AudioRecorder;
import ddf.minim.Minim;
import ddf.minim.ugens.FilePlayer;
import de.hsrm.mi.eibo.simpleplayer.SimpleAudioPlayer;
import de.hsrm.mi.eibo.simpleplayer.SimpleMinim;
import javafx.beans.property.SimpleIntegerProperty;

public class Sounds {
	
	private SimpleMinim minim;
	private List<SimpleAudioPlayer> soundlist = new LinkedList<SimpleAudioPlayer>();
	private int recordingnumber = 1;
	private AudioInput in;
	private AudioRecorder record;
	private AudioOutput out;
	private SimpleIntegerProperty time;
	private Thread playTime;
	

	public Sounds() {
		minim = new SimpleMinim(true);
		time = new SimpleIntegerProperty();
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
	
	public void record() {
		in = minim.getLineIn(Minim.STEREO, 2048);
		out = minim.getLineOut( Minim.STEREO );
		record = minim.createRecorder(in, "MySong" +  recordingnumber + ".wav");
		record.beginRecord(); 
		
		playTime = new Thread() {
			public void run() {
				int i = 0;
				while (!isInterrupted()) {
						time.set(i);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							interrupt();
						}
						i++;
					}
				}
			};
		playTime.start();
	}
	public void endRecording() {
		record.endRecord();
		playTime.interrupt();
		in.close();
		out.close();
		//record.save();
	}
	public SimpleIntegerProperty getTimeProperty() {
		return time;
	}
	
	

}
