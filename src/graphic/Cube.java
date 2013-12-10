package graphic;

import org.lwjgl.util.Color;

public class Cube {
	private int posX;
	private int posY;
	private int height;
	private int width;
	private int velX;
	private int velY;
	private Color color;
	
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
