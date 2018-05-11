package tsz.game.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class MainMenuController extends ViewController {

	Logger logger = LoggerFactory.getLogger("MainMenuController.class");
	
	@FXML
	private TextField playerName;
	
	@FXML
	private Label invalid;
	
	@FXML
	public void startGame() {
		if(playerName.getText().matches("[A-Za-z0-9]+")) {
			this.setPlayerName();
			this.main.showGame();
		} else {
			invalid.setTextFill(Color.DARKRED);
		}
		
	}
	
	@FXML
	public void showAchievements() {
		this.setPlayerName();
		this.main.showAchievements();
	}
	
	@FXML
	public void showSettings() {
		this.setPlayerName();
		this.main.showSettings();
	}
	
	@FXML
	public void showTopList() {
		this.setPlayerName();
		this.main.showTopList();
	}
	
	@FXML
	public void exitGame() {
		Platform.exit();
		
		logger.info("Game closed.");
	}
	
	public void setTheValueOfTheTextfield() {
		playerName.setText(this.main.getPlayer().getName());
	}
	
	public void setPlayerName() {
		this.main.getPlayer().setName(playerName.getText());
	}
}
