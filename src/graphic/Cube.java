package graphic;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.lwjgl.util.Color;

public class Cube {
	private static int posX;
	private static int posY;
	private static int height;
	private static int width;
	private static int velX;
	private static int velY;
	private static Color color;
	
	public Cube(int posX, int posY, int height, int width, Color col) {
		setPosX(posX);
		setPosY(posY);
		setHeight(height);
		setWidth(width);
		setColor(col);	
	}
	
	public Cube(int posX, int posY, int height, int width, Color col, int velX, int velY) {
		setPosX(posX);
		setPosY(posY);
		setHeight(height);
		setWidth(width);
		setColor(col);
		setVelX(velX);
		setVelY(velY);
	}
	
	public void Split(int posX, int posY, int height, int width, int velX, int velY) {
		//TODO: Split this
	}
	
	public void Move(int posX, int posY, int velX, int velY){
		//TODO: Move this
		
		Collide(posX, posY, velX, velY);
	}
	
	private void Collide(int posX, int posY, int velX, int velY) {
		//TODO: Check if collide with screen
	}
	
	public void Remove() {
		//TODO: Delete This
	}
	
	public static void render() {
		//glClear(GL_COLOR_BUFFER_BIT);
		glColor3f(0.0f, 0.5f, 0.0f);
		glBegin(GL_QUADS);
			glVertex2f(posX,posY);//bottom-left(x, y)
			glVertex2f(posX+width,posY);//bottom-right(x, y)
			glVertex2f(posX+width,posY+height);//top-right(x, y)
			glVertex2f(posX,posY+height);//top-left(x, y)
		glEnd();
	}
	
	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
