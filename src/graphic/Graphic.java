package graphic;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Graphic extends JPanel {
	private static int WIDTH = 640;
	private static int HEIGHT = 420;
	private static String NAME = "Default";
	
	public Graphic() {
		setBackground(Color.WHITE);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		//TODO: paint things
		Cube cube = new Cube(10, 20, 30, 40);
		Cube cube1 = new Cube(20, 30, 40, 50);
		Cube cube2 = new Cube(30, 40, 50, 60);
		
		g.setColor(Color.BLACK);
		g2.fill(cube.draw());
		g.setColor(new Color(255, 0, 0));
		g2.fill(cube1.draw());
		g.setColor(Color.BLACK);
		g2.fill(cube2.draw());
	}
}
