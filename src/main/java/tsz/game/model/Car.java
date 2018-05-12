package tsz.game.model;

import java.util.Random;

/**
 * Class for all cars in the game.
 * 
 * @author szi
 *
 */
public class Car {
	
	/**
	 * X coordinate of the car.
	 */
	private double x;
	
	/**
	 * Y coordinate of the car.
	 */
	private double y;
	
	/**
	 * Width of the cars.
	 */
	private static double carWidth =  80;
	
	/**
	 * Height of the cars.
	 */
	private static double carHeight = 100;
	
	/**
	 * Color of the car.
	 */
	private String color;
	
	/**
	 * Speed of the car.
	 */
	protected float speed;
	
	/**
	 * Constructor without any parameters.
	 */
	public Car() {
		this.x=0;
		this.y=0;
	}
	
	/**
	 * Constructor with coordinates of the car's position.
	 * @param x - x coordinate of the car's position.
	 * @param y - y coordinate of the car's position.
	 */
	public Car(double x, double y) {
	     this.x = x;
	     this.y = y;
	     this.setSpeed();
	}
	
	/**
	 * Sets the X coordinate of the car.
	 * @param x - the x coordinate of the car.
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * @return the X coordinate of the car.
	 */
	public double getX() {
		return this.x;
	}
	
	/**
	 * Sets the Y Coordinate of the car.
	 * @param y - the y coordinate of the car
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * @return the Y coordinate of the car.
	 */
	public double getY() {
		return this.y;
	}
	
	/** Set the color of the car.
	 * @param color - color of the car.
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
	/**
	 * @return the color of the car.
	 */
	public String getColor() {
		return this.color;
	}
	
	/**
	 * @return the width of the cars.
	 */
	public double getWidth() {
		return carWidth;
	}
	
	/**
	 * @return the height of the cars.
	 */
	public double getHeight() {
		return carHeight;
	}

	
	/**
	 * Sets the speed.
	 * @param speed - speed.
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	/**
	 * @return the speed.
	 */
	public float getSpeed() {
		return this.speed;
	}
	
	/**
	 * Sets a random speed.
	 */
	public void setSpeed() {
		int speed = new Random().nextInt(15);
		this.speed = (float) speed / 5 + 2;
	}
	
	/**
	 * Move the car down with the value of the parameter..
	 * @param plus - add the parameter to the Y coordinate of the car.
	 */
	public void moveDown(double plus) {
		setY(this.y + plus);
	}


}
