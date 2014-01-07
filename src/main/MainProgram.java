package main;
import graphic.GraphicTest;
import processing.core.PApplet;
import kinect.KinectController;


public class MainProgram {
	//KinectController k = new KinectController();
	
	public static void main(String args[]){
		//PApplet.main(new String[] { "--present", "Audio" });
		//PApplet.main(new String[] { "--present", "k" });
		GraphicTest gTest = new GraphicTest();
		gTest.Test();
	}
}
