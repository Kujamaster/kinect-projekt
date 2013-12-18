package kinect;
import audio.Audio;
import processing.core.*;
import SimpleOpenNI.*;

@SuppressWarnings("serial")
public class KinectController extends PApplet {

	SimpleOpenNI kinect;
	Audio audio = new Audio();

	int closestValue;
	int closestX;
	int closestY;
	

	public void setup(){
	  size(640, 480);
	  kinect = new SimpleOpenNI(this);
	  kinect.enableDepth();
	  audio.setup();
	}

	public void draw(){
	  closestValue = 8000;
	  System.out.print("Draw: ");
	  kinect.update();
	  
	  int[] depthValues = kinect.depthMap();
	  
	  for(int y = 0; y < 480; y++){
	    for(int x = 0; x < 640; x++){
	      //pull out corresponding value from depth array
	      int i = x + y * 640;
	      int currentDepthValue = depthValues[i];
	      
	      //if that pixel is closest one so far
	      if(currentDepthValue > 0 && currentDepthValue < closestValue){
	        //save the value
	        closestValue = currentDepthValue;
	        setCurrent(closestValue);
	        //and save it's position(x and y)
	        closestX = x;
	        closestY = y;
	      }
	    }
	  }
	  //Draw image on screen
	  PImage depthImage = kinect.depthImage();
	  image(depthImage, 0, 0);
	  
	  //Draw circle at closest x and y value
	  fill(255,0,0);
	  ellipse(closestX, closestY, 25, 25);
	  println("Closest Value (mm): " + closestValue + " at X: " + closestX + " , Y: " + closestY);
	  audio.setFrequency(closestValue);
	  audio.update();
	  
	}
	
	public int getCurrent(){
		return closestValue;
	}
	
	public void setCurrent(int currentVal){
		this.closestValue = currentVal;
	
	}
}
