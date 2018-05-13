package tsz.game.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import tsz.game.DAO.GameDataDAO;
import tsz.game.service.GameOverService;

/**
 * Provides functionality for the Top List View.
 * 
 * @author szi
 *
 */
public class GameOverController extends ViewController {
	
	/**
	 * Button for getting back to the Main Menu.
	 */
	@FXML
	Button menu;

	/**
	 * Label for showing the player's score.
	 */
	@FXML
	Label playerScore;
	
	/**
	 * Label for showing the highest score.
	 */
	@FXML
	Label maxScore;
	
	/**
	 * Gets us back to the main menu.
	 */
	@FXML
	public void backToTheMenu() {
		Stage stage = (Stage) menu.getScene().getWindow();
		stage.close();
		this.main.showMainMenu();
	}
	
	/**
	 * Close the game.
	 */
	@FXML
	public void exitGame() {
		Platform.exit();
	}
	
	
	/**
	 * Write the actual score and the highest score to the window.
	 */
	public void writeTheScoresOnTheScreen() {
		GameOverService gameService = new GameOverService();
		GameDataDAO dao = new GameDataDAO();
		playerScore.setText("Your score: " + this.main.getPlayer().getScore());
		maxScore.setText("The highest score: " + gameService.getHighestScore(dao.getAllGameData()));
	}
}
