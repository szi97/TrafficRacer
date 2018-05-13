package tsz.game.controller;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import tsz.game.DAO.GameDataDAO;
import tsz.game.model.Car;
import tsz.game.model.GameData;
import tsz.game.model.GameWindow;
import tsz.game.model.PlayersCar;
import tsz.game.view.ActionOnKeyEvents;
import tsz.game.view.GameView;
import tsz.game.view.MainApp;

/**
 * Provides functionality for the game.
 * 
 * @author szi
 *
 */
public class GameController implements ActionOnKeyEvents  {
	/**
	 * Last time when a new car has been added.
	 */
	private long last = 1;
	
	/**
	 * GameWindow.
	 */
	private GameWindow gameWindow;
	
	/**
	 * GameView.
	 */
	private GameView view;
	
	/**
	 * MainApp.
	 */
	private MainApp main;
	
	/**
	 * GameData.
	 */
	private GameData gamedata;
	
	/**
	 * GameDataDAO.
	 */
	private GameDataDAO gamedataDAO;
	
	/**
	 * Logger.
	 */
	Logger logger = LoggerFactory.getLogger("GameController.class");
	
	/**
	 * ActionTimer for moving the cars down.
	 */
	private AnimationTimer obstacleTimer;
	
	/**
	 * ActionTimer for moving the player's car up.
	 */
	private AnimationTimer movingUp;
	
	/**
	 * ActionTimer for moving the player's car down.
	 */
	private AnimationTimer movingDown;
	
	/**
	 * ActionTimer for moving the player's car right.
	 */
	private AnimationTimer movingRight;
	
	/**
	 * ActionTimer for moving the player's car left.
	 */
	private AnimationTimer movingLeft;
	
	/**
	 * Start the game.
	 */
	public void startGame() {
		initTimers();
		this.main.getPlayer().resetScore();
	}
	
	/**
	 * @param main - Main App.
	 */
	public void setMainApp(MainApp main) {
		this.main = main;
	}
	
	/**
	 * @return the game's window.
	 */
	public GameWindow getWindow() {
		return this.gameWindow;
	}
	
	/**
	 * @param view - the Game's view.
	 * @param window - the Game's window.
	 */
	public void setGameView(GameView view, GameWindow window) {
		this.view = view;
		this.gameWindow = window;
	}

	/**
	 * Move the player's car to the right direction.
	 * @see tsz.game.view.ActionOnKeyEvents#moving()
	 */
	@Override
	public EventHandler<? super KeyEvent> moving() {		
		
		return keyEvent -> {
				switch (keyEvent.getCode()) {
				case LEFT : 
					this.movingLeft.stop();
					this.movingLeft.start();
					return;
				case RIGHT:
					this.movingRight.stop();
					this.movingRight.start();
					return;
				case UP:
					this.movingUp.stop();
					this.movingUp.start();
					return;
				case DOWN:
					this.movingDown.stop();
					this.movingDown.start();
					return;
				default: return;
				}	
		};
	}
	
	/**
	 * Stop the player's car moving.
	 * @see tsz.game.view.ActionOnKeyEvents#stopMoving()
	 */
	@Override
	public EventHandler<? super KeyEvent> stopMoving(){
		return keyEvent -> {
			switch (keyEvent.getCode()) {
			case LEFT: 
				this.movingLeft.stop(); 
				return;
			case RIGHT: 
				this.movingRight.stop(); 
				return;
			case UP: 
				this.movingUp.stop(); 
				return;
			case DOWN: 
				this.movingDown.stop(); 
				return;
			default : 
				return;
			}
		};
	}
	
	/**
	 * Check whether the player's car is crashed with an obstacle car.
	 * @param player - the player's car.
	 */
	private void isCrashed(PlayersCar player) {
		for(Car i : gameWindow.getOCars()) {
			if( Math.abs(i.getX()-player.getX()) < 68 &&
				Math.abs(i.getY()-player.getY()) < 102)
				if(Math.sqrt(Math.pow(i.getX()-player.getX(),2)+Math.pow(i.getY()-player.getY(), 2)) < 100) {
					logger.info("Cars crashed.");
					endTheGame();
				}
			}
	}
	
	/**
	 * End the game.
	 */
	public void endTheGame() {
		stopTimers();
		
		gamedata = new GameData();
		this.gamedata.setFinalScore(gameWindow.getPlayer().getScore());
		this.gamedata.setPlayerName(gameWindow.getPlayer().getName());
		this.gamedata.setDifficulty(gameWindow.getPlayer().getDifficulty());
		
		gamedataDAO = new GameDataDAO();
		gamedataDAO.saveGameData(this.gamedata);
		
		logger.info("Game is over.");
		
		this.main.showGameOverWindow();
	}
	
	/**
	 * Stop all the timers.
	 */
	public void stopTimers() {
		this.obstacleTimer.stop();
		this.movingUp.stop();
		this.movingDown.stop();
		this.movingLeft.stop();
		this.movingRight.stop();
		
		logger.info("Timers stopped.");
	}
	

	/**
	 * Init all timers.
	 */
	public void initTimers() {
		PlayersCar player = this.gameWindow.getPlayer().getPlayersCar();
	
		obstacleTimer = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				gameWindow.moveDownCars();
				gameWindow.deleteCar();
				view.draw(gameWindow);
				
				long rate = (long) (new Random().nextInt(10)+20)* 100000000L;
				if(now - last > rate){
					gameWindow.addNewCar(gameWindow.getOCars());
					last = now;
				}
				
				isCrashed(gameWindow.getPlayer().getPlayersCar());
			}
		};
		obstacleTimer.start();
		
		movingLeft = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
					player.moveLeft();
				}
		};
			
		movingRight = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
					player.moveRight();
				}
		};
		
		movingUp = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
					player.moveUp();
				}
		};
		
		movingDown = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
					player.moveDown();	
				}
		};
	}
	
}
