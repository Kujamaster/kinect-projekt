package graphic;

import java.awt.Color;
import java.awt.Rectangle;

public class Cube {
	private int posX;
	private int posY;
	private int height;
	private int width;
	private int velX;
	private int velY;
	private Color color;

	public int recentlySplit = 25;
	public boolean isSplit = false;
	public int screenHeight = Frame.getScreenHeight();
	public int screenWidth = Frame.getScreenWidth();

	public Cube() {

	}

	public Cube(int posX, int posY, int width, int height) {
		setPosX(posX);
		setPosY(posY);
		setHeight(height);
		setWidth(width);
	}

	public Cube(int posX, int posY, int width, int height, int velX, int velY) {
		setPosX(posX);
		setPosY(posY);
		setHeight(height);
		setWidth(width);
		setVelX(velX);
		setVelY(velY);
	}

	public Rectangle draw() {
		return new Rectangle(posX, posY, width, height);
	}

	public void Split() {
		// TODO: Split this
		if (recentlySplit == 0) {
			recentlySplit = 25;
		} else {
			recentlySplit--;
		}

	}

	public void Move() {
		// TODO: Move this
		setPosX(getPosX() + getVelX());
		setPosY(getPosY() + getVelY());
		Collide();// check collide then move
		Split();
	}

	private void Collide() {
		// TODO: Check if collide with screen
		if (getPosX() < 0) {
			this.velX = -this.velX;
			setPosX(0);
		}
		if (getPosY() < 0) {
			this.velY = -this.velY;
			setPosY(0);
		}
		if ((getPosX() + getWidth()) > Frame.getScreenWidth()) {
			this.velX = -this.velX;
			setPosX(Frame.getScreenWidth() - getWidth());
			System.out.println("Object pos: " + getPosX() + " , " + getPosY()
					+ " , Size: " + getWidth() + " , " + getHeight());
			System.out.println(Frame.getScreenWidth() - getWidth());
			System.out.println(Frame.getScreenWidth());
		}
		if ((getPosY() + getHeight()) > Frame.getScreenHeight()) {
			this.velY = -this.velY;
			setPosY(Frame.getScreenHeight() - getHeight());
			System.out.println("Object pos: " + getPosX() + " , " + getPosY()
					+ " , Size: " + getWidth() + " , " + getHeight());
			System.out.println(Frame.getScreenHeight() - getHeight());
			System.out.println(Frame.getScreenHeight());
		}
		// Collide with cubes
	}

	public void Remove() {
		// TODO: Delete This

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
