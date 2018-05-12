package tsz.game.controller;

import java.util.Collection;

import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import tsz.game.DAO.GameDataDAO;
import tsz.game.model.GameData;
import tsz.game.service.AchievementService;

/**
 * Provides functionality for the Achievements View.
 * 
 * @author szi
 *
 */
public class AchievementsController extends ViewController {
	
	/**
	 * Rectangle to indicate whether the player earned the 'Inexpert' achievement.
	 */
	@FXML
	Rectangle inexpert;
	
	
	/**
	 * Rectangle to indicate whether the player earned the 'Skillful Beginner' achievement.
	 */
	@FXML
	Rectangle skillfulBeginner;
	
	/**
	 * Rectangle to indicate whether the player earned the 'Patient' achievement.
	 */
	@FXML
	Rectangle patient;
	
	/**
	 * Rectangle to indicate whether the player earned the 'Professional' achievement.
	 */
	@FXML
	Rectangle professional;
	
	/**
	 * Rectangle to indicate whether the player earned the 'Champion on easy' achievement.
	 */
	@FXML
	Rectangle championOnEasy;
	
	/**
	 * Rectangle to indicate whether the player earned the 'Champion on medium' achievement.
	 */
	@FXML
	Rectangle championOnMedium;
	
	/**
	 * Rectangle to indicate whether the player earned the 'Champion on hard.' achievement.
	 */
	@FXML
	Rectangle championOnHard;

	
	/**
	 * Checks whether the player earned the achievements or not.
	 */
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
		
		if(service.isSkillfulBeginner(allGamedata, playername)) {
			skillfulBeginner.setFill(Color.DARKGREEN);
		} else {
			skillfulBeginner.setFill(Color.TRANSPARENT);
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
	
	/**
	 * Gets us back to the Main Menu.
	 */
	@FXML
	public void backToMenu() {
		this.main.showMainMenu();
	}
}
