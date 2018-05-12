package tsz.game.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 * Provides functionality for the Main Menu View.
 * 
 * @author szi
 *
 */
public class MainMenuController extends ViewController {

	/**
	 * Logger.
	 */
	Logger logger = LoggerFactory.getLogger("MainMenuController.class");
	
	/**
	 * Textfield for the player's name.
	 */
	@FXML
	private TextField playerName;
	
	/**
	 * Label to indicate when the name is invalid.
	 */
	@FXML
	private Label invalid;
	
	/**
	 * Start the game when the name is valid.
	 */
	@FXML
	public void startGame() {
		if(this.main.getPlayer().isPlayerNameValid(playerName.getText())) {
			this.setPlayerName();
			this.main.showGame();
		} else {
			invalid.setTextFill(Color.DARKRED);
		}
		
	}
	
	/**
	 * Gets us to the Achievement View.
	 */
	@FXML
	public void showAchievements() {
		this.setPlayerName();
		this.main.showAchievements();
	}
	
	/**
	 * Gets us to the Settings View.
	 */
	@FXML
	public void showSettings() {
		this.setPlayerName();
		this.main.showSettings();
	}
	
	/**
	 * Gets us to the Top List View.
	 */
	@FXML
	public void showTopList() {
		this.setPlayerName();
		this.main.showTopList();
	}
	
	/**
	 * Exit the game.
	 */
	@FXML
	public void exitGame() {
		Platform.exit();
		
		logger.info("Game closed.");
	}
	
	/**
	 * Set the valu of the TextField width the actual playername.
	 */
	public void setTheValueOfTheTextfield() {
		playerName.setText(this.main.getPlayer().getName());
	}
	
	/**
	 * Set the player's name.
	 */
	public void setPlayerName() {
		this.main.getPlayer().setName(playerName.getText());
	}
}
