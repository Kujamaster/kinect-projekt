package graphic;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

import kinect.KinectController;
import processing.core.PApplet;

public class Frame {
	private static int screenWidth = 500;
	private static int screenHeight = 500;
	Graphic panel = new Graphic();
	PApplet kinect = new KinectController();
	public Frame(String title, int width, int height) {
		this.setScreenWidth(width);
		this.setScreenHeight(height);
		JFrame gui = new JFrame();
		gui.setTitle(title);
		gui.setSize(width,height);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container pane = gui.getContentPane();
		pane.setLayout(new GridLayout(1,1));
		
		pane.add(panel);
		//pane.add(kinect, BorderLayout.CENTER);
		//kinect.init();
		gui.setVisible(true);
	}
	
	public void update() {
		panel.update();
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

}

