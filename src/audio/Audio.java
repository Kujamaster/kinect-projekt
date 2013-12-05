package audio;
import processing.core.*;
import ddf.minim.*;
import ddf.minim.signals.*;
	
@SuppressWarnings("serial")
public class Audio extends PApplet {
	
	Minim minim;
	AudioOutput out;
	SineWave sine;

	private float frequency = 440;

	public void setup(){
	  //size(512, 200);
	  minim = new Minim(this);
	  out = minim.getLineOut(Minim.STEREO, 512);
	  sine = new SineWave(getFrequency(), (float) 0.5, 44100);
	  //out.addSignal(sine);
	}

	public void draw(){
	  println(mouseX);
	  update();
	}

	public void update(){
	  //setFrequency(mouseX);
	  sine.setFreq(getFrequency());
	  out.clearSignals();
	  out.addSignal(sine);
	}

	public float getFrequency(){
	  return frequency;
	}

	public void setFrequency(float frequency){
	  this.frequency = frequency;
	}

	public void stop(){
	  out.close();
	  minim.stop();
	  super.stop();
	}



}
