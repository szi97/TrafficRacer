package tsz.game.model;

import java.util.Random;

import tsz.game.view.GameView;

public class Car {
	private double x;
	private double y;
	private static double carWidth = (int) (GameView.getLaneWidth()*0.8);
	private static double carHeight = 100;
	private String color;
	protected float speed;
	
	public Car() {
		this.x=0;
		this.y=0;
	}
	
	public Car(double x, double y) {
	     this.x = x;
	     this.y = y;
	     this.setSpeed();
	}
	
	public void setX(double x) {
		this.x = x;
	}
	public double getX() {
		return this.x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	public double getY() {
		return this.y;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public double getWidth() {
		return carWidth;
	}
	
	public double getHeight() {
		return carHeight;
	}
	
	public void moveDown(double plus) {
		setY(this.y + plus);
	}
	
	public void setSpeed() {
		int speed = new Random().nextInt(15);
		this.speed = (float) speed / 5 + 2;
	}
	
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	public float getSpeed() {
		return this.speed;
	}

}
