package graphic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;

import kinect.KinectController;
import audio.AudioPlayer;
import graphic.Frame;

@SuppressWarnings("serial")
public class Graphic extends JPanel {
	ArrayList<Cube> cubes = new ArrayList<Cube>();
	boolean maxReached = false;
	boolean restart = false;
	int mouseX, mouseY;
	Random rand = new Random();
	Frame frame;
	int randNbrX = rand.nextInt(6) + 1;
	int randNbrY = rand.nextInt(6) + 1;

	public Graphic() {
		setBackground(Color.BLACK);
		init();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g.setColor(Color.CYAN);
		g.fillOval(mouseX, mouseY, 20, 20);


		g.setColor(Color.RED);
		for (Cube temp : cubes) {
			g2.fill(temp.draw());
		}
	}

	public void init() {
		System.out.println(randNbrX + " , " + randNbrY);
		AudioPlayer.init();
		cubes.add(new Cube(200, 200, 300, 100, randNbrX, randNbrY));
	}


	public void update() {
		
		//kc.draw();
		int tempVelX = 0, tempVelY = 0, tempPosX = 0, tempPosY = 0, tempWidth = 0, tempHeight = 0, tempIndex = 0;
		if (!cubes.isEmpty()) {
			for (Cube c : cubes) {
				c.Move();
				if ((c.getPosX() < mouseX && c.getPosX() + c.getWidth() > mouseX) || (c.getPosX() < mouseX + 20 && c.getPosX() + c.getWidth() > mouseX + 20)) {
					if ((c.getPosY() < mouseY && c.getPosY() + c.getHeight() > mouseY) || (c.getPosY() < mouseY + 20 && c.getPosY() + c.getHeight() > mouseX + 20)) {
						System.out.println("Mouse inside cube");

						tempVelX = c.getVelX();
						tempVelY = c.getVelY();
						tempPosX = c.getPosX();
						tempPosY = c.getPosY();
						tempWidth = c.getWidth();
						tempHeight = c.getHeight();

						if (c.recentlySplit == 0) {
							c.isSplit = true;
							playSamp(mouseY);
						}
					}
				}
			}
		}
		for (Cube c : cubes) {
			if (c.isSplit) {
				tempIndex = cubes.indexOf(c);
			}
		}
		if (cubes.size() >= 10) {
			maxReached = true;
		}
		if (cubes.isEmpty()) {
			System.out.println("You won!");
			restart = true;
		}
		if (!cubes.isEmpty()) {
			if (cubes.get(tempIndex).isSplit) {
				if (!maxReached) {
					cubes.remove(tempIndex);
					cubes.add(new Cube(tempPosX + 20, tempPosY + 20, tempWidth
							- (tempWidth / 2), tempHeight - (tempHeight / 2),
							tempVelX, tempVelY));
					cubes.add(new Cube(tempPosX - 20, tempPosY - 20, tempWidth
							- (tempWidth / 2), tempHeight - (tempHeight / 2),
							-tempVelX, -tempVelY));
				} else {
					cubes.remove(tempIndex);
				}
			}
		}
		
		this.repaint();
		try {
			Thread.sleep(20);
		} catch (InterruptedException ex) {
			Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void setStuff(int x, int y) {
		mouseX = x;
		mouseY = y;
		System.out.println("Test X: " + mouseX + " ,Y: " + mouseY);
	}
	
	public void playSamp(int tempY){
		int modY = this.getHeight()/8;
		tempY = tempY/modY;
		
		AudioPlayer.play(tempY);
	}
}