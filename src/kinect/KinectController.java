package kinect;
import processing.core.*;
import SimpleOpenNI.*;

@SuppressWarnings("serial")
public class KinectController extends PApplet {

	SimpleOpenNI kinect;

	int closestValue;
	public int closestX;
	public int closestY;
	public float lastX;
	public float lastY;
	public int useX;
	public int useY;
	

	public void setup(){
	  size(640, 480);
	  kinect = new SimpleOpenNI(this);
	  kinect.enableDepth();
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
	  
	  float interpolatedX = lerp(lastX, closestX, 0.3f);
	  float interpolatedY = lerp(lastY, closestY, 0.3f);
	  //Draw image on screen
	  PImage depthImage = kinect.depthImage();
	  image(depthImage, 0, 0);
	  useX = (int) map(interpolatedX, 0, 640, 0, 1365);
	  useY = (int) map(interpolatedY, 0, 480, 0, 730);
	  //Draw circle at closest x and y value
	  fill(255,0,0);
	  ellipse(interpolatedX, interpolatedY, 25, 25);
	  println("Closest Value (mm): " + closestValue + " at X: " + closestX + " , Y: " + closestY);
	  lastX = interpolatedX;
	  lastY = interpolatedY;
	}
	
	public int getCurrent(){
		return closestValue;
	}
	
	public void setCurrent(int currentVal){
		this.closestValue = currentVal;
	
	}
}
