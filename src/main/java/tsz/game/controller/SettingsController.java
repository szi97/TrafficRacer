package tsz.game.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SettingsController extends ViewController {
	
	@FXML
	Button button;
	
	//setColor
	@FXML
	public void setColor(ActionEvent event) {
		button = (Button) event.getSource();
		this.main.getPlayer().getPlayersCar().setColor(button.getId());
		
	}
	
	//setDifficulty
	@FXML
	public void setDifficulty(ActionEvent event) {
		button = (Button) event.getSource();
		this.main.getGameController().setDifficulty(button.getId());
		switch(button.getId()) {
		case "easy": this.main.getPlayer().getPlayersCar().setSpeed(1);
		case "medium": this.main.getPlayer().getPlayersCar().setSpeed(1.5f);
		case "hard" : this.main.getPlayer().getPlayersCar().setSpeed(2);
		}
	}
	
	@FXML
	public void backToMainMenu() {
		this.main.showMainMenu();
	}
}
