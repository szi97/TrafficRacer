package tsz.game.controller;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import tsz.game.DAO.GameDataDAO;
import tsz.game.model.GameData;
import tsz.game.service.TopListService;

public class TopListController extends ViewController {
	
	@FXML
	GridPane toplist;
	
	public void setTopList() {
		GameDataDAO gameDataDAO = new GameDataDAO();
		TopListService service = new TopListService();
		List<GameData> topGameData = service.getTopTen(gameDataDAO.getAllGameData());
		
		for(int i = 0; i < topGameData.size(); i++) {
			Label playername = new Label();
			playername.setText(topGameData.get(i).getPlayerName());
			playername.setTextFill(Color.DARKGREEN);
			playername.setFont(Font.font(18));
			Label score = new Label();
			score.setText("" + topGameData.get(i).getFinalScore());
			score.setTextFill(Color.DARKSEAGREEN);
			score.setFont(Font.font(18));
			toplist.add(playername, 1, i+1);
			toplist.add(score, 2, i+1);
		}
	}
	
}
