package tsz.game.model;

import tsz.game.view.GameView;

/**
 * Class of a player's car.
 * @author szi
 *
 */
public class PlayersCar extends Car {
	
	/**
	 * Sets the speed of player.
	 */
	private int offset = 4;
	
	/**
	 * Constructor without any parameters.
	 */
	public PlayersCar() {
		super(0,0);
		super.setColor("black");
		this.setSpeed(1);
	}

	/**
	 * Constructor with coordinates of the car's position.
	 * @param x - x coordinate of the car's position.
	 * @param y - y coordinate of the car's position.
	 */
	public PlayersCar(int x, int y) {
		super(x, y);
		super.setColor("black");
		this.setSpeed(1);
	}
	
	/**
	 * Move the car up with the value of the offset.
	 */
	public void moveUp() {
		if(super.getY() >= this.offset) {
			super.setY(super.getY() - this.offset);
		} else if (super.getY() > 0) {
			super.setY(0);
		}
	}
	
	/**
	 * Move the car down with the value of the offset.
	 */
	public void moveDown() {
		if(super.getY() < GameView.getHeight() - super.getHeight()-25 - this.offset) {
			super.setY(super.getY() + this.offset);
			} else if (super.getY() < GameView.getHeight() - super.getHeight()-25) {
				super.setY(GameView.getHeight()-25 - super.getHeight());
			}
	}
	
	/**
	 * Move the car left with the value of the offset.
	 */
	public void moveLeft() {
		if(super.getX() >= this.offset) {
		super.setX(super.getX() - this.offset);
		} else if (super.getX() > 0) {
			super.setX(0);
		}
	}
	
	/**
	 * Move the car right with the value of the offset.
	 */
	public void moveRight() {
		if(super.getX() < GameView.getWidth() - super.getWidth() - this.offset) {
		super.setX(super.getX() + this.offset);
		} else if (super.getX() < GameView.getWidth() - super.getWidth()) {
			super.setX(GameView.getWidth() - super.getWidth());
		}
	}

}
