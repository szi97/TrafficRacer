package tsz.game.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Provides functionality for the Settings view.
 * 
 * @author szi
 *
 */
public class SettingsController extends ViewController {
	
	/**
	 * Logger.
	 */
	Logger logger = LoggerFactory.getLogger("SettingsController.class");
	
	/**
	 * Button for the source of the event.
	 */
	@FXML
	Button button;
	
	/**
	 * Sets the color of car.
	 * @param event - an event.
	 */
	@FXML
	public void setColor(ActionEvent event) {
		button = (Button) event.getSource();
		this.main.getPlayer().getPlayersCar().setColor(button.getId());
		
		logger.info("Color has been set.");		
	}
	
	/**
	 * Sets the difficulty of the game.
	 * @param event - an event.
	 */
	@FXML
	public void setDifficulty(ActionEvent event) {
		button = (Button) event.getSource();
		this.main.getPlayer().setDifficulty(button.getId());
		switch(button.getId()) {
		case "easy": this.main.getPlayer().getPlayersCar().setSpeed(1);
		case "medium": this.main.getPlayer().getPlayersCar().setSpeed(1.5f);
		case "hard" : this.main.getPlayer().getPlayersCar().setSpeed(2);
		}
		
		logger.info("Difficulty has been set.");
	}
	
	/**
	 * Gets us back to the Main Menu.
	 */
	@FXML
	public void backToMainMenu() {
		this.main.showMainMenu();
	}
}
