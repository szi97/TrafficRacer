package tsz.game.model;

import tsz.game.view.GameView;

public class PlayersCar extends Car {
	
	private int offset = 4;
	
	public PlayersCar() {
		super(0,0);
		super.setColor("black");
		this.setSpeed(1);
	}

	public PlayersCar(int x, int y) {
		super(x, y);
		super.setColor("black");
		this.setSpeed(1);
	}
	
	public void moveUp() {
		if(super.getY() >= this.offset) {
			super.setY(super.getY() - this.offset);
		} else if (super.getY() > 0) {
			super.setY(0);
		}
	}
	
	//TODO not workin properly
	public void moveDown() {
		if(super.getY() < GameView.getHeight() - super.getHeight() - this.offset) {
			super.setY(super.getY() + this.offset);
			} else if (super.getY() < GameView.getHeight() - super.getHeight()) {
				super.setY(GameView.getHeight() - super.getHeight());
			}
	}
	
	public void moveLeft() {
		if(super.getX() >= this.offset) {
		super.setX(super.getX() - this.offset);
		} else if (super.getX() > 0) {
			super.setX(0);
		}
	}
	
	public void moveRight() {
		if(super.getX() < GameView.getWidth() - super.getWidth() - this.offset) {
		super.setX(super.getX() + this.offset);
		} else if (super.getX() < GameView.getWidth() - super.getWidth()) {
			super.setX(GameView.getWidth() - super.getWidth());
		}
	}

}
