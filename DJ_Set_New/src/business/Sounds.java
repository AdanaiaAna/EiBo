package business;

import java.util.LinkedList;
import java.util.List;

import ddf.minim.AudioInput;
import ddf.minim.AudioOutput;
import ddf.minim.AudioRecorder;
import ddf.minim.Minim;
import de.hsrm.mi.eibo.simpleplayer.SimpleAudioPlayer;
import de.hsrm.mi.eibo.simpleplayer.SimpleMinim;
import javafx.beans.property.SimpleIntegerProperty;

public class Sounds {
	
	private SimpleMinim minim;
	//Normale Sounds
	private List<SimpleAudioPlayer> DrumLoops = new LinkedList<SimpleAudioPlayer>();
	private List<SimpleAudioPlayer> GuitarLoops = new LinkedList<SimpleAudioPlayer>();
	private List<SimpleAudioPlayer> BassLoops = new LinkedList<SimpleAudioPlayer>();
	
	//Extras
	private List<SimpleAudioPlayer> ExtraDrumLoops = new LinkedList<SimpleAudioPlayer>();
	private List<SimpleAudioPlayer> ExtraGuitarLoops = new LinkedList<SimpleAudioPlayer>();
	private List<SimpleAudioPlayer> ExtraBassLoops = new LinkedList<SimpleAudioPlayer>();
	
	//Oneshots 
	private List<SimpleAudioPlayer> soundlistOS = new LinkedList<SimpleAudioPlayer>();
	
	
	
	private List<SimpleAudioPlayer> soundlistLoops = new LinkedList<SimpleAudioPlayer>();
	

	
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
		DrumLoops.add(minim.loadMP3File("Sounds/drum1.mp3"));
		DrumLoops.add(minim.loadMP3File("Sounds/drums2.mp3"));
		DrumLoops.add(minim.loadMP3File("Sounds/drums3.mp3"));
		DrumLoops.add(minim.loadMP3File("Sounds/drums4.mp3"));
		
		
		
		
		soundlistOS.add(minim.loadMP3File("Sounds/becken oder so.mp3"));
		
	}

	public void playLoop(int sound) {
		if (sound < soundlistLoops.size() && sound >= 0) {
			soundlistLoops.get(sound).loop();
		}
	}

	public void endLoop(int sound) {
		if (sound < soundlistLoops.size() && sound >= 0) {
			soundlistLoops.get(sound).pause();
			soundlistLoops.get(sound).rewind();
		}
	}
	
	public void playOneShot(int sound) {
		if (sound < soundlistOS.size() && sound >= 0) {
			soundlistOS.get(sound).rewind();
			soundlistOS.get(sound).play();
		}
	}

	public boolean getAudioPlayerIsPlaying(int sound) {
		return soundlistLoops.get(sound).isPlaying();
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
		recordingnumber ++;
	}
	
	
	public void endRecording() {
		record.endRecord();
		playTime.interrupt();
		in.close();
		out.close();
		//habs auskommentiert sonst recorded es jedes mal haha
		//record.save();
	}
	public SimpleIntegerProperty getTimeProperty() {
		return time;
	}
	
	

}
