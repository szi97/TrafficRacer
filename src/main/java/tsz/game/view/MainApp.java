package tsz.game.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import tsz.game.DAO.GameDataDAO;
import tsz.game.controller.AchievementsController;
import tsz.game.controller.GameController;
import tsz.game.controller.GameOverController;
import tsz.game.controller.MainMenuController;
import tsz.game.controller.SettingsController;
import tsz.game.controller.TopListController;
import tsz.game.model.Car;
import tsz.game.model.GameWindow;
import tsz.game.model.Player;;

/**
 * The Main class of the application.
 * 
 * @author szi
 *
 */
public class MainApp extends Application {
	
	/**
	 * List of obstacle cars.
	 */
	private List<Car> obstacleCars;
	
	/**
	 * Player.
	 */
	private Player player;
	
	/**
	 * GameController.
	 */
	private GameController game;
	
	/**
	 * The primary stage.
	 */
	private Stage primaryStage;
	
	/**
	 * Handler for KeyEvents.
	 */
	private ActionOnKeyEvents eventhandler;
	
	/**
	 * Logger.
	 */
	Logger logger = LoggerFactory.getLogger("MainApp.class");
	
	/* 
	 * JavaFX start method.
	 * {@link javafx.application.Application#start(javafx.stage.Stage)}
	 */
	@Override
	public void start(Stage stage) throws Exception {
		this.primaryStage = stage;
		this.primaryStage.setTitle("Traffic Racer");
		
		logger.info("Application started.");
		
		GameDataDAO dao = new GameDataDAO();
		dao.createFileIfNotExist();
		
		showMainMenu();
	}
	
	/**
	 * Shows the Menu window.
	 */
	public void showMainMenu() {
		try {
			if (player == null )
				player = new Player();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getClassLoader().getResource("fxml/MainMenuLayout.fxml"));
			Pane menuLayout = (Pane) loader.load();
			
			
			MainMenuController controller = loader.getController();
			controller.setMainApp(this);
			controller.setTheValueOfTheTextfield();
			
			
			Scene scene = new Scene(menuLayout);

			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.centerOnScreen();
			primaryStage.show();
			
			logger.info("Main Menu shown.");
			
		} catch (IOException e) {
			logger.error(e.toString());
		}
	}
	
	/**
	 * Shows the Achievements window.
	 */
	public void showAchievements() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getClassLoader().getResource("fxml/AchievementsLayout.fxml"));
			Pane achiLayout = (Pane) loader.load();
			
			AchievementsController controller = loader.getController();
			controller.setMainApp(this);
			controller.checkTheAchievements();
			
			Scene scene = new Scene(achiLayout);

			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.centerOnScreen();
			
			logger.info("Achievements shown");
			
		} catch (IOException e) {
			logger.error(e.toString());
		}
	}
	
	/**
	 * Shows the Settings window.
	 */
	public void showSettings() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getClassLoader().getResource("fxml/SettingsLayout.fxml"));
			Pane settingsLayout = (Pane) loader.load();
			
			SettingsController controller = loader.getController();
			controller.setMainApp(this);
			
			Scene scene = new Scene(settingsLayout);

			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.centerOnScreen();
			
			logger.info("Settings shown.");
			
		} catch (IOException e) {
			logger.error(e.toString());
		}		
	}
	
	/**
	 * Shows the Top List window.
	 */
	public void showTopList() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getClassLoader().getResource("fxml/TopListLayout.fxml"));
			Pane settingsLayout = (Pane) loader.load();
			
			TopListController controller = loader.getController();
			controller.setMainApp(this);
			controller.setTopList();
			
			Scene scene = new Scene(settingsLayout);

			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.centerOnScreen();
			
			logger.info("Top List shown.");
			
		} catch (IOException e) {
			logger.error(e.toString());
		}		
	}
	
	/**
	 * Shows the Game window.
	 */
	public void showGame() {		
		player.getPlayersCar().setX(160);
		player.getPlayersCar().setY(400);
		obstacleCars = new ArrayList<Car>();
		
		GameWindow gameWindow = new GameWindow(obstacleCars, player);
		GameView gameView = new GameView();
		
		game = new GameController();
		game.setMainApp(this);
		game.setGameView(gameView, gameWindow);
		
		Scene scene = new Scene(gameView, 400, 675, Paint.valueOf("#444444"));
		this.setHandler(game);
		scene.addEventFilter(KeyEvent.KEY_PRESSED, eventhandler.moving());
		scene.addEventFilter(KeyEvent.KEY_RELEASED, eventhandler.stopMoving());
		primaryStage.setScene(scene);
		
		logger.info("Game started.");
		
		game.startGame();		
		
	}
	
	/**
	 * Shows the Game Over window.
	 */
	public void showGameOverWindow() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getClassLoader().getResource("fxml/GameOverLayout.fxml"));
			Pane gameOverLayout = (Pane) loader.load();
			
			GameOverController controller = loader.getController();
			controller.setMainApp(this);
			controller.writeTheScoresOnTheScreen();
			
			Stage stage = new Stage();
			Scene scene = new Scene(gameOverLayout);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.centerOnScreen();
			stage.show();
			
			logger.info("Game Over Window shown.");
			
		} catch (IOException e) {
			logger.error(e.toString());
		}
	}
	
	/**
	 * @return the list of obstacle cars.
	 */
	public List<Car> getOCars(){
		return obstacleCars;
	}
	
	/**
	 * @return the player of the game.
	 */
	public Player getPlayer() {
		return player;
	}

	
	/**
	 * @param game - the handler for KeyEvents.
	 */
	public void setHandler(GameController game) {
		this.eventhandler = game;
	}
	
	/**
	 * @return the GameController.
	 */
	public GameController getGameController() {
		return this.game;
	}
	
	/**
	 * Main method of the application.
	 * @param args - argumentums
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
