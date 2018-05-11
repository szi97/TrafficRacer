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

public class GameController implements ActionOnKeyEvents  {
	private long last = 1;
	private GameWindow gameWindow;
	private GameView view;
	private MainApp main;
	private GameData gamedata;
	private GameDataDAO gamedataDAO;
	private String difficulty = "easy";
	
	Logger logger = LoggerFactory.getLogger("GameController.class");
	
	private AnimationTimer addTimer;
	private AnimationTimer moveTimer;
	private AnimationTimer movingUp;
	private AnimationTimer movingDown;
	private AnimationTimer movingRight;
	private AnimationTimer movingLeft;
	
	public void startGame() {
		initTimers();
		
	}
	
	public void setMainApp(MainApp main) {
		this.main = main;
	}
	
	public GameWindow getWindow() {
		return this.gameWindow;
	}
	
	public void setGameView(GameView view, GameWindow window) {
		this.view = view;
		this.gameWindow = window;
	}
	
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	
	public String getDifficulty() {
		return this.difficulty;
	}

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
	
	//testable
	private void isCrashed(PlayersCar player) {
		for(Car i : gameWindow.getOCars()) {
			if( Math.abs(i.getX()-player.getX()) < 70 &&
				Math.abs(i.getY()-player.getY()) < 100)
				if(Math.sqrt(Math.pow(i.getX()-player.getX(),2)+Math.pow(i.getY()-player.getY(), 2)) < 100) {
					logger.info("Cars crashed.");
					endTheGame();
				}
			}
	}
	
	public void endTheGame() {
		stopTimers();
		
		gamedata = new GameData();
		this.gamedata.setFinalScore(gameWindow.getPlayer().getScore());
		this.gamedata.setPlayerName(gameWindow.getPlayer().getName());
		this.gamedata.setDifficulty(this.getDifficulty());
		
		gamedataDAO = new GameDataDAO();
		gamedataDAO.saveGameData(this.gamedata);
		
		logger.info("Game is over.");
		
		this.main.showGameOverWindow();
	}
	
	public void stopTimers() {
		this.moveTimer.stop();
		this.addTimer.stop();
		this.movingUp.stop();
		this.movingDown.stop();
		this.movingLeft.stop();
		this.movingRight.stop();
		
		logger.info("Timers stopped.");
	}
	

	public void initTimers() {
		PlayersCar player = this.gameWindow.getPlayer().getPlayersCar();
		
		addTimer = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				long rate = (long) (new Random().nextInt(10)+20)* 100000000L;
				if(now - last > rate){
					gameWindow.addNewCar(gameWindow.getOCars());
					last = now;
				}
				
			}
		};
		addTimer.start();
	
		moveTimer = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				gameWindow.moveDownCars();
				gameWindow.deleteCar();
				view.draw(gameWindow);
				
				isCrashed(gameWindow.getPlayer().getPlayersCar());
			}
		};
		moveTimer.start();
		
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
