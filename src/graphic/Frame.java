package graphic;

import java.awt.*;

import javax.swing.*;

public class Frame {
	
	public Frame(String title, int width, int height) {
		JFrame gui = new JFrame();
		gui.setTitle(title);
		gui.setSize(width,height);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Graphic panel = new Graphic();
		
		Container pane = gui.getContentPane();
		pane.setLayout(new GridLayout(1,1));
		
		pane.add(panel);
		gui.setVisible(true);
	}

}

