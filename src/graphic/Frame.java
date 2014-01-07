package graphic;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

import kinect.KinectController;
import processing.core.PApplet;

public class Frame {
	private static int screenWidth = 500;
	private static int screenHeight = 500;
	Graphic panel = new Graphic();
	PApplet kinect = new KinectController();
	JFrame gui = new JFrame();
	Container pane = gui.getContentPane();

	public Frame(String title, int width, int height) {
		this.setScreenWidth(width);
		this.setScreenHeight(height);

		gui.setTitle(title);
		gui.setSize(width, height);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pane.setLayout(new GridLayout(1, 1));

		pane.add(panel);
		// pane.add(kinect, BorderLayout.CENTER);
		// kinect.init();
		gui.setVisible(true);
	}

	public void update() {
		if (panel.restart) {
			int timeToRestart = 10;
			while (timeToRestart >= 0) {
				timeToRestart--;
				System.out.println(timeToRestart);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					Logger.getLogger(Frame.class.getName()).log(Level.SEVERE,
							null, ex);
				}
			}
			pane.remove(panel);
			panel.removeAll();
			panel = new Graphic();
			pane.add(panel);
			pane.validate();
			System.out.println("New game");
		} else {
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
}
