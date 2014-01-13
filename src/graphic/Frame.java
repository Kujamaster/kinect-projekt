package graphic;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

import kinect.KinectController;
import processing.core.PApplet;

public class Frame {
	private static int screenWidth = 500;
	private static int screenHeight = 500;
	private int kinectX = 10;
	private int kinectY = 10;
	Graphic panel = new Graphic();
	KinectController kinect = new KinectController();
	JFrame gui = new JFrame();
	JFrame backgroundUI = new JFrame();
	Container pane = gui.getContentPane();
	Container bPane = backgroundUI.getContentPane();
	public Frame(String title, int width, int height) {
		this.setScreenWidth(width);
		this.setScreenHeight(height);
		
		gui.setTitle(title);
		gui.setSize(width,height);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		backgroundUI.setTitle("Back");
		backgroundUI.setSize(new Dimension(100, 100));
		
		bPane.setLayout(new GridLayout(1,1));
		pane.setLayout(new GridLayout(1,1));
		
		pane.add(panel);
		bPane.add(kinect);
		kinect.init();
		gui.setVisible(true);
		backgroundUI.setVisible(true);
	}
	
	public void update() {
		
		System.out.println("X: " + getKinectX() + " Y: " + getKinectY());
		if(panel.restart) {
			int timeToRestart = 10;
			while(timeToRestart >= 0) {
				timeToRestart--;
				System.out.println(timeToRestart);
				try {
		            Thread.sleep(1000);
		        } catch (InterruptedException ex) {
		            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
		        }
			}
			pane.remove(panel);
			//pane.remove(kinect);
			panel.removeAll();
			panel = new Graphic();
			pane.add(panel);
			//pane.add(kinect);
			//kinect.setVisible(false);
			pane.validate();
			System.out.println("New game");
		} else {
			kinectX = kinect.useX;
			kinectY = kinect.useY;
			panel.setStuff(kinectX, kinectY);
			panel.update();
			
		}
	}

	public static int getScreenWidth() {
		return screenWidth;
	}

	@SuppressWarnings("static-access")
	public void setScreenWidth(int screenWidth) {
		this.screenWidth = screenWidth;
	}

	public static int getScreenHeight() {
		return screenHeight;
	}

	@SuppressWarnings("static-access")
	public void setScreenHeight(int screenHeight) {
		this.screenHeight = screenHeight;
	}

	public int getKinectX() {
		return kinectX;
	}

	public void setKinectX(int kinectX) {
		this.kinectX = kinectX;
	}

	public int getKinectY() {
		return kinectY;
	}

	public void setKinectY(int kinectY) {
		this.kinectY = kinectY;
	}

}

