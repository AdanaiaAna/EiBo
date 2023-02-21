package business;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	private List<SimpleAudioPlayer> drumLoops = new LinkedList<SimpleAudioPlayer>();
	private List<SimpleAudioPlayer> guitar1Loops = new LinkedList<SimpleAudioPlayer>();
	private List<SimpleAudioPlayer> guitar2Loops = new LinkedList<SimpleAudioPlayer>();
	private List<SimpleAudioPlayer> bassLoops = new LinkedList<SimpleAudioPlayer>();
	
	//Extra
	private List<SimpleAudioPlayer> extraDrumLoops = new LinkedList<SimpleAudioPlayer>();
	
	//Oneshots 
	private List<SimpleAudioPlayer> osLoops = new LinkedList<SimpleAudioPlayer>();
	
	//Alle Sounds
	private HashMap<String, List<SimpleAudioPlayer>> soundMap = new HashMap<>();

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
		
		//Drums
		drumLoops.add(minim.loadMP3File("Sounds/drum1.mp3"));
		drumLoops.add(minim.loadMP3File("Sounds/drums2.mp3"));
		drumLoops.add(minim.loadMP3File("Sounds/drums3.mp3"));
		drumLoops.add(minim.loadMP3File("Sounds/drums4.mp3"));
		
		
		// Extra Drum
		extraDrumLoops.add(minim.loadMP3File("Sounds/extraDrum1.mp3"));
		extraDrumLoops.add(minim.loadMP3File("Sounds/extraDrum2.mp3"));
	
		
		// Gitarren
		guitar1Loops.add(minim.loadMP3File("Sounds/guitar1_1.mp3"));
		guitar1Loops.add(minim.loadMP3File("Sounds/guitar1_2.mp3"));
		guitar1Loops.add(minim.loadMP3File("Sounds/guitar1_3.mp3"));
		guitar1Loops.add(minim.loadMP3File("Sounds/guitar1_4.mp3"));
		
		guitar2Loops.add(minim.loadMP3File("Sounds/guitar2_1.mp3"));
		guitar2Loops.add(minim.loadMP3File("Sounds/guitar2_2.mp3"));
		guitar2Loops.add(minim.loadMP3File("Sounds/guitar2_3.mp3"));
		guitar2Loops.add(minim.loadMP3File("Sounds/guitar2_4.mp3"));
		
		
		//Bass-Gitarren
		bassLoops.add(minim.loadMP3File("Sounds/bass1.mp3"));
		bassLoops.add(minim.loadMP3File("Sounds/bass2.mp3"));
		bassLoops.add(minim.loadMP3File("Sounds/bass3.mp3"));
		bassLoops.add(minim.loadMP3File("Sounds/bass4.mp3"));
		
		
		// Oneshots
		osLoops.add(minim.loadMP3File("Sounds/OneShot1.mp3"));
		osLoops.add(minim.loadMP3File("Sounds/OneShot2.mp3"));
		osLoops.add(minim.loadMP3File("Sounds/OneShot3.mp3"));
		osLoops.add(minim.loadMP3File("Sounds/OneShot4.mp3"));
		
		//Sound Listen in die Hashmap
		soundMap.put("Drum", drumLoops);
		soundMap.put("ExtraDrum", extraDrumLoops);
		soundMap.put("Guitar1", guitar1Loops);
		soundMap.put("Guitar2", guitar2Loops);
		soundMap.put("Bass", bassLoops);
		soundMap.put("Oneshot", osLoops);
		
	}

	public void playLoop(int sound, String soundList) {
		List<SimpleAudioPlayer> soundlistLoops = soundMap.get(soundList);
		for (SimpleAudioPlayer currentAudio : soundlistLoops) {
			if (currentAudio.isPlaying()) {
				currentAudio.pause();
				currentAudio.rewind();
				break;
			}
		}
		if (sound < soundlistLoops.size() && sound >= 0) {
			soundlistLoops.get(sound).loop();
		}
	}
	
	public void endLoop(int sound, String soundList) {
		List<SimpleAudioPlayer> soundlistLoops = soundMap.get(soundList);
		if (sound < soundlistLoops.size() && sound >= 0) {
			soundlistLoops.get(sound).pause();
			soundlistLoops.get(sound).rewind();
		}
	}

	
	public void playOneShot(int sound) {
		if (sound < osLoops.size() && sound >= 0) {
			osLoops.get(sound).rewind();
			osLoops.get(sound).play();
		}
	}
	
	
	public boolean getAudioPlayerIsPlaying(int sound, String soundList) {
		return soundMap.get(soundList).get(sound).isPlaying();
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
	
	// RECORDING
	public void endRecording() {
		time.set(0);
		record.endRecord();
		playTime.interrupt();
		in.close();
		out.close();
	}
	
	
	// STOP 
	public void stop() {
		
		 Set<Map.Entry<String, List<SimpleAudioPlayer>>> entrySet = soundMap.entrySet();
		    for (Map.Entry<String, List<SimpleAudioPlayer>> entry : entrySet) {
		      List<SimpleAudioPlayer> soundlist = entry.getValue();
		      for (SimpleAudioPlayer currentAudio : soundlist) {
		    	  if (currentAudio.isPlaying()) {
						currentAudio.pause();
						currentAudio.rewind();
						break;
					}
		      }
		   }
	}
	
	
	public void setVolume(float normalVolume) {
		//normal volume to db
		float db = (float) (20 * Math.log10(normalVolume));
		
		 Set<Map.Entry<String, List<SimpleAudioPlayer>>> entrySet = soundMap.entrySet();
		    for (Map.Entry<String, List<SimpleAudioPlayer>> entry : entrySet) {
		      List<SimpleAudioPlayer> soundlist = entry.getValue();
		      // Iterating over the linked list
		      for (SimpleAudioPlayer currentAudio : soundlist) {
		    	  if (currentAudio.isPlaying()) {
						currentAudio.setGain(db);
						break;
					}
		      }
		   }
	}
	
	
	public void saveRecording() {
		record.save();
		recordingnumber ++;
	}
	public SimpleIntegerProperty getTimeProperty() {
		return time;
	}
	
}
