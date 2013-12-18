package graphic;

import java.awt.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

@SuppressWarnings("serial")
public class Graphic extends JPanel {
	ArrayList<Cube> cubes = new ArrayList<Cube>();
	
	
	public Graphic() {
		setBackground(Color.WHITE);
		init();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		//TODO: paint things
		
		
		g.setColor(Color.BLACK);
		for(Cube temp : cubes){
			g2.fill(temp.draw());
		}
	}
	
	public void init() {
		cubes.add(0,new Cube(100, 100, 100, 100));
		cubes.get(0).setVelX(2);
		cubes.get(0).setVelY(1);
		//cubes.add(1, new Cube(20, 20, 100, 100));
	}
	
	public void update() {
		//System.out.println("Test");
		int dir = 1;
		for(Cube c : cubes){
			
			c.Move();
			c.getPosX();
			c.getPosY();
			System.out.println(c.getPosX() + " , " + c.getPosY());
			System.out.println(c.getVelX() + " , " + c.getVelY());
		}
		this.repaint();
        try {
            Thread.sleep(20);
        } catch (InterruptedException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
		
	}
}
