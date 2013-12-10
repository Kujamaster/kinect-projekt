package graphic;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.LWJGLException;

public class GraphicEngine {
	
	public GraphicEngine() {
		//constructor code here
	}
	
	public void Window(int screenHeight, int screenWidth) {
		try{
			Display.setDisplayMode(new DisplayMode(screenHeight, screenWidth));
			Display.create();
		} catch(LWJGLException ex) {
			ex.printStackTrace();
			System.exit(0);
		}
		while (!Display.isCloseRequested()) {
			
			Display.update();
		}
		Display.destroy();
	}
	
	
	
	public void GameOver(){
		//TODO: Display Game Over Screen
	}

}
