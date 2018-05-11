package tsz.game.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import tsz.game.DAO.GameDataDAO;
import tsz.game.service.GameOverService;

public class GameOverController extends ViewController {
	@FXML
	Button menu;
	
	@FXML
	Button newGame;
	
	@FXML
	Label playerScore;
	@FXML
	Label maxScore;
	
	@FXML
	public void newGame() {
		Stage stage = (Stage) newGame.getScene().getWindow();
		stage.close();
		this.main.showGame();
	}
	
	@FXML
	public void backToTheMenu() {
		Stage stage = (Stage) menu.getScene().getWindow();
		stage.close();
		this.main.showMainMenu();
	}
	
	@FXML
	public void exitGame() {
		Platform.exit();
	}
	
	
	public void writeTheScoresOnTheScreen() {
		GameOverService gameService = new GameOverService();
		GameDataDAO dao = new GameDataDAO();
		playerScore.setText("Your score: " + this.main.getPlayer().getScore());
		maxScore.setText("The highest score: " + gameService.getHighestScore(dao.getAllGameData()));
	}
}
