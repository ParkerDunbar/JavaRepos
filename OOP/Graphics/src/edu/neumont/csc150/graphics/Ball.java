package edu.neumont.csc150.graphics;

import java.awt.Color;

public class Ball {
	private int x, y, width, height, xVelocity, yVelocity;
	private Color color;
	
	public Ball() {
		
	}
	
	public Ball(int x, int y, int width, int height, int xVelocity, int yVelocity) {
		this.setX(x);
		this.setY(y);
		this.setWidth(width);
		this.setHeight(height);
		this.setxVelocity(xVelocity);
		this.setyVelocity(yVelocity);
	}
	
	public void detectWallCollision(int rObjX, int rObjY, int lObjX, int lObjY) {
		if(this.x >= rObjX - this.width || this.x < lObjX) {
			this.xVelocity *= -1;
		}
		if(this.y >= rObjY - this.height || this.y < lObjY) {
			this.yVelocity *= -1;
		}
	}
	
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the xVelocity
	 */
	public int getxVelocity() {
		return xVelocity;
	}

	/**
	 * @param xVelocity the xVelocity to set
	 */
	public void setxVelocity(int xVelocity) {
		this.xVelocity = xVelocity;
	}

	/**
	 * @return the yVelocity
	 */
	public int getyVelocity() {
		return yVelocity;
	}

	/**
	 * @param yVelocity the yVelocity to set
	 */
	public void setyVelocity(int yVelocity) {
		this.yVelocity = yVelocity;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}
}
