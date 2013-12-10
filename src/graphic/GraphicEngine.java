package graphic;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.Color;
import org.lwjgl.LWJGLException;

public class GraphicEngine {
	private String name;
	private int screenHeight;
	private int screenWidth;
	Cube cube = new Cube(100, 100, 300, 300, null);
	
	
	public GraphicEngine() {
		//constructor code here
	}
	
	public void Window(int height, int width) {
		try{
			screenHeight = height;
			screenWidth = width;
			Display.setDisplayMode(new DisplayMode(screenHeight, screenWidth));
			Display.create();
		} catch(LWJGLException ex) {
			ex.printStackTrace();
			System.exit(0);
		}
		init();
		while (!Display.isCloseRequested()) {
			render();
			Display.update();
		}
		Display.destroy();
	}
	
	public void init() {
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, screenHeight, 0, screenWidth, 1, -1);
		glMatrixMode(GL_MODELVIEW);
	}
	
	public void CreateCube(int posX, int posY, int height, int width, Color col) {
		Cube cube = new Cube(posX, posY, height, width, col);
		//cube.render();
	}
	
	protected void render() {
		glClear(GL_COLOR_BUFFER_BIT);
		glColor3f(0.5f, 0.0f, 0.0f);
		glBegin(GL_QUADS);
		glVertex2f(cube.getPosX(),cube.getPosY());//bottom-left(x, y)
		glVertex2f(cube.getPosX()+cube.getWidth(),cube.getPosY());//bottom-right(x, y)
		glVertex2f(cube.getPosX()+cube.getWidth(),cube.getPosY()+cube.getHeight());//top-right(x, y)
		glVertex2f(cube.getPosX(),cube.getPosY()+cube.getHeight());//top-left(x, y)
		glEnd();
		
	}
	
	
	public void GameOver(){
		//TODO: Display Game Over Screen
	}

}
