package tsz.game.controller;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import tsz.game.DAO.GameDataDAO;
import tsz.game.model.GameData;
import tsz.game.service.TopListService;

/**
 * Provides functionality for the Top List View.
 * 
 * @author szi
 *
 */
public class TopListController extends ViewController {
	
	/**
	 * GridPane for the list.
	 */
	@FXML
	GridPane toplist;
	
	/**
	 * Button.
	 */
	@FXML
	Button button;
	
	/**
	 * Difficulty.
	 */
	String difficulty = "easy";
	
	/**
	 * Sets the values of the gridpane's rows with the right values of the list.
	 */
	public void setTopList() {
		GameDataDAO gameDataDAO = new GameDataDAO();
		TopListService service = new TopListService();
		List<GameData> topGameData = service.getTopTen(gameDataDAO.getAllGameData(), this.difficulty);
		
		while(toplist.getChildren().size() > 0){
	        toplist.getChildren().remove(0);
	    }
		
		Label place = new Label("Place");
		place.setTextFill(Color.WHITE);
		place.setFont(Font.font(22));
		toplist.add(place, 0, 0);
		Label playerName = new Label("PlayerName");
		playerName.setTextFill(Color.WHITE);
		playerName.setFont(Font.font(22));
		toplist.add(playerName, 1, 0);
		Label scoreText = new Label("Score");
		scoreText.setTextFill(Color.WHITE);
		scoreText.setFont(Font.font(22));
		toplist.add(scoreText, 2, 0);
		
		for(int i = 0; i < topGameData.size(); i++) {
			Label position = new Label("" + (i+1));
			position.setTextFill(Color.BLACK);
			position.setFont(Font.font(18));
			Label playername = new Label(topGameData.get(i).getPlayerName());
			playername.setTextFill(Color.DARKGREEN);
			playername.setFont(Font.font(18));
			Label score = new Label("" + topGameData.get(i).getFinalScore());
			score.setTextFill(Color.DARKSEAGREEN);
			score.setFont(Font.font(18));
			toplist.add(position, 0, i+1);
			toplist.add(playername, 1, i+1);
			toplist.add(score, 2, i+1);

		}
	}
	
	/**
	 * Sets the difficulty.
	 * @param event - an event.
	 */
	@FXML
	public void setDifficulty(ActionEvent event) {
		button = (Button) event.getSource();
		this.difficulty = button.getId();
		setTopList();
	}
	
	/**
	 * Gets us back to the Main Menu.
	 */
	@FXML
	public void backToMenu() {
		this.main.showMainMenu();
	}
	
}
