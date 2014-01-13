package audio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.util.HashMap;

import javax.sound.sampled.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public abstract class AudioPlayer {
	
	private static AudioFormat audioFormat;
	private static AudioInputStream audioInputStream;
	private static SourceDataLine sourceDataLine;
	private static int gap;
	private static boolean mute = false;
	private static boolean stopPlayback = false;
	private static boolean isPlaying = false;
	
	private static HashMap<String, Clip> clips;

	private static String [] notes = {"C4","Bb3","Ab3","G3",
						"F3","Eb3","D3","C3"};
	
	
	
	public static void printShit(int y){
		
		System.out.println("connection!!!!!!!!!");
		System.out.println("recieved Y value: " + y);
		System.out.println("res/" + notes[y] + ".wav");
		
	}
	
	public static void init(){
		
		clips = new HashMap<String, Clip>();
		
		for(int i = 0;i < notes.length;i++){
			
			load("/SFX/" + notes[i] + ".wav", notes[i]);
			
		}
		
		gap = 0;
		
		load("/BGM/bgm.wav", "BGM");  
		
		if(clips.get("BGM") == null) System.out.println("this nigga's crazy");
		loop("BGM");
		
	}
	
	public static void load(String path, String key) {

		if(clips.get(key) != null){ 
			System.out.println("occupado");
			System.out.println("key");
			return;
			}
		
		Clip clip;
		try {
			AudioInputStream ais =
				AudioSystem.getAudioInputStream(new BufferedInputStream(AudioPlayer.class.getResourceAsStream(path))
				);
			AudioFormat baseFormat = ais.getFormat();
			AudioFormat decodeFormat = new AudioFormat(
				AudioFormat.Encoding.PCM_SIGNED,
				baseFormat.getSampleRate(),
				16,
				baseFormat.getChannels(),
				baseFormat.getChannels() * 2,
				baseFormat.getSampleRate(),
				false
			);
			AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat, ais);
			clip = AudioSystem.getClip();
			clip.open(dais);
			
			
			clips.put(key, clip);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*public static void playClip() { 
		
		
		
	}*/
	
	/*public static void playAudio(int y){
		
		try{
			File soundFile = new File("res/" + notes[y] + ".wav");
			
			audioInputStream = AudioSystem.getAudioInputStream(soundFile);
			
			audioFormat = audioInputStream.getFormat();
			
			System.out.println(audioFormat);
			
			DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
			sourceDataLine = (SourceDataLine)AudioSystem.getLine(dataLineInfo);
			
			new PlayThread().start();
			
		} catch (Exception e){
			
			e.printStackTrace();
			System.exit(0);
			
		}
		
	}*/
	
	public static void play(int y_) {
		System.out.println("method play() initiated in AudioPlayer Class");
		play(notes[y_], 0);
	}
	
	public static void play(String s, int i) {

		if(mute) return;
		
		Clip c = clips.get(s);

		if(c == null) return;

		if(c.isRunning()) c.stop();
		
		c.setFramePosition(i);
		
		while(!c.isRunning()) c.start();
	}
	
	public static void stop(String s) {
		if(clips.get(s) == null) return;
		if(clips.get(s).isRunning()) clips.get(s).stop();
	}
	
	public static void resume(String s) {
		if(mute) return;
		if(clips.get(s).isRunning()) return;
		clips.get(s).start();
	}
	
	public static void loop(String s) {
		loop(s, gap, gap, clips.get(s).getFrameLength() - 1);
	}
	
	public static boolean isPlaying(String s) {
		return clips.get(s).isRunning();
	}
	
	public static void loop(String s, int frame) {
		loop(s, frame, gap, clips.get(s).getFrameLength() - 1);
	}
	
	public static void loop(String s, int start, int end) {
		loop(s, gap, start, end);
	}
	
	public static void loop(String s, int frame, int start, int end) {
		stop(s);
		if(mute) return;
		clips.get(s).setLoopPoints(start, end);
		clips.get(s).setFramePosition(frame);
		clips.get(s).loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public static void setPosition(String s, int frame) {
		clips.get(s).setFramePosition(frame);
	}
	
	public static int getFrames(String s) { return clips.get(s).getFrameLength(); }
	public static int getPosition(String s) { return clips.get(s).getFramePosition(); }
	
	public static void close(String s) {
		stop(s);
		clips.get(s).close();
	}
	
	
	//____________________________________________________----------------------_____________________________________//
	
	/*static class PlayThread extends Thread {
		
		private static final byte tempBuffer[] = new byte[10000];
		
		public void run(){
			
			try{
				sourceDataLine.open(audioFormat);
				sourceDataLine.start();
				
				int cnt;

			      while((cnt = audioInputStream.read(
			           tempBuffer,0,tempBuffer.length)) != -1
			                       && stopPlayback == false){
			        if(cnt > 0){
			          sourceDataLine.write(
			                             tempBuffer, 0, cnt);
			        }//end if
			      }//end while loop
				
			      sourceDataLine.drain();
			      sourceDataLine.close();
			      
			      
			}catch (Exception e) {
			      e.printStackTrace();
			      System.exit(0);
			    }//end catch
			
		}
		
	}*/

}