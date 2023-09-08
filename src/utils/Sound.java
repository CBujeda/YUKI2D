package utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
	
	Clip clip;
	ArrayList<File> f;
	public Sound(ArrayList<File> f) {
		this.f = f;
	}
	
	public void setFile(int pista) {
		// gestionar errores
		AudioInputStream audioInputStream = null;
			try {
				audioInputStream = AudioSystem.getAudioInputStream(f.get(pista));
			} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();
			} catch (IOException e1) {e1.printStackTrace();}
			try {
				clip = AudioSystem.getClip();
			} catch (LineUnavailableException e) {e.printStackTrace();}
			try {
				clip.open(audioInputStream);
			} catch (LineUnavailableException e) {e.printStackTrace();
			} catch (IOException e) {e.printStackTrace();}	
	}
	
	public void play() {
		clip.start();
	}
	
	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public void stop() {
		clip.stop();
	}
}
