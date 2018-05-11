package tsz.game.controller;

import java.util.Collection;

import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import tsz.game.DAO.GameDataDAO;
import tsz.game.model.GameData;
import tsz.game.service.AchievementService;

public class AchievementsController extends ViewController {
	
	@FXML
	Rectangle inexpert;
	@FXML
	Rectangle skillfullBeginner;
	@FXML
	Rectangle patient;
	@FXML
	Rectangle professional;
	@FXML
	Rectangle championOnEasy;
	@FXML
	Rectangle championOnMedium;
	@FXML
	Rectangle championOnHard;

	
	@FXML
	public void checkTheAchievements() {
		String playername = this.main.getPlayer().getName();
		
		AchievementService service = new AchievementService();
		GameDataDAO gamedataDAO = new GameDataDAO();
		Collection<GameData> allGamedata = gamedataDAO.getAllGameData();
		System.out.println(allGamedata.size());
		
		
		if(service.isInexpert(allGamedata, playername)) {
			inexpert.setFill(Color.DARKGREEN);
		} else {
			inexpert.setFill(Color.TRANSPARENT);
		}
		
		if(service.isSkillfullBeginner(allGamedata, playername)) {
			skillfullBeginner.setFill(Color.DARKGREEN);
		} else {
			skillfullBeginner.setFill(Color.TRANSPARENT);
		}
		
		if(service.isPatient(allGamedata, playername)) {
			patient.setFill(Color.DARKGREEN);
		} else {
			patient.setFill(Color.TRANSPARENT);
		}
		
		if(service.isProfessional(allGamedata, playername)) {
			professional.setFill(Color.DARKGREEN);
		} else {
			professional.setFill(Color.TRANSPARENT);
		}
		
		if(service.isChampionOnEasy(allGamedata, playername)) {
			championOnEasy.setFill(Color.DARKGREEN);
		} else {
			championOnEasy.setFill(Color.TRANSPARENT);
		}
		
		if(service.isChampionOnMedium(allGamedata, playername)) {
			championOnMedium.setFill(Color.DARKGREEN);
		} else {
			championOnMedium.setFill(Color.TRANSPARENT);
		}
		
		if(service.isChampionOnHard(allGamedata, playername)) {
			championOnHard.setFill(Color.DARKGREEN);
		} else {
			championOnHard.setFill(Color.TRANSPARENT);
		}
	}
}
