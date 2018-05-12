package tsz.game.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tsz.game.model.GameData;

/**
 * Class of essential business logic for the achievement window.
 * 
 * @author szi
 *
 */
public class AchievementService {
	
	/**
	 * Logger.
	 */
	Logger logger = LoggerFactory.getLogger("AchievementService.class");
	
	/**
	 * Decide whether the player earned the 'Inexpert' achievement.
	 * @param listOfData - collection of all gameplay data.
	 * @param playername - name of the actual player.
	 * @return whether the given player's perfomance is eligable to unlock the 'Inexpert' achievement.
	 */
	public boolean isInexpert(Collection<GameData> listOfData, String playername) {
		logger.info("Inexpert achievement checked.");
		return listOfData.stream()
				.filter(d -> d.getFinalScore() == 0 && d.getDifficulty().equals("easy"))
				.map(d -> d.getPlayerName())
				.collect(Collectors.toList()).contains(playername);
	}
	
	/**
	 * Decide whether the player earned the 'Skillful Beginner' achievement.
	 * @param listOfData - collection of all gameplay data.
	 * @param playername - name of the actual player.
	 * @return whether the given player's perfomance is eligable to unlock the 'Skullful Beginner' achievement.
	 */
	public boolean isSkillfulBeginner(Collection<GameData> listOfData, String playername) {
		logger.info("Skillfull Beginner achievement checked.");
		return listOfData.stream()
				.filter(d -> d.getFinalScore() >= 100 && d.getDifficulty().equals("easy"))
				.map(d -> d.getPlayerName())
				.collect(Collectors.toList()).contains(playername);
	}
	
	/**
	 * Decide whether the player earned the 'Patient' achievement.
	 * @param listOfData - collection of all gameplay data.
	 * @param playername - name of the actual player.
	 * @return whether the given player's perfomance is eligable to unlock the 'Patient' achievement.
	 */
	public boolean isPatient(Collection<GameData> listOfData, String playername) {
		logger.info("Patient achievement checked.");
		return listOfData.stream()
				.filter(d -> d.getFinalScore() >= 1000 && d.getDifficulty().equals("easy"))
				.map(d -> d.getPlayerName())
				.collect(Collectors.toList()).contains(playername);
	}
	
	/**
	 * Decide whether the player earned the 'Professional' achievement.
	 * @param listOfData - collection of aal gameplay data.
	 * @param playername - name of the actual player.
	 * @return whether the given player's perfomance is eligable to unlock the 'Professional' achievement.
	 */
	public boolean isProfessional(Collection<GameData> listOfData, String playername) {
		logger.info("Professional achievement checked.");
		return listOfData.stream()
				.filter(d -> d.getFinalScore() >= 100 && d.getDifficulty().equals("hard"))
				.map(d -> d.getPlayerName())
				.collect(Collectors.toList()).contains(playername);
	}
			
	/**
	 * Decide whether the player earned the 'Champion on easy' achievement.
	 * @param listOfData - collection of all gameplay data.
	 * @param playername - name of the actual player.
	 * @return whether the given player's perfomance is eligable to unlock the 'Champion on easy' achievement.
	 */
	public boolean isChampionOnEasy(Collection<GameData> listOfData, String playername) {
		logger.info("Champion on easy achievement checked.");
		List<GameData> tempForData = listOfData.stream()
				.filter(d -> d.getDifficulty().equals("easy"))
				.sorted((d1,d2) -> d2.getFinalScore() - d1.getFinalScore())
				.collect(Collectors.toList());
		if(tempForData.size() > 0) {
			return tempForData.get(0).getPlayerName().equals(playername);
		} else {
			return false;
		}
	}
	
	/**
	 * Decide whether the player earned the 'Champion on medium' achievement.
	 * @param listOfData - collection of all gameplay data.
	 * @param playername - name of the actual player.
	 * @return whether the given player's perfomance is eligable to unlock the 'Champion on medium' achievement.
	 */
	public boolean isChampionOnMedium(Collection<GameData> listOfData, String playername) {
		logger.info("Champion on medium achievement checked.");
		List<GameData> tempForData = listOfData.stream()
					.filter(d -> d.getDifficulty().equals("medium"))
					.sorted((d1,d2) -> d2.getFinalScore() - d1.getFinalScore())
					.collect(Collectors.toList());
		if(tempForData.size() > 0) {
			return tempForData.get(0).getPlayerName().equals(playername);
		} else {
			return false;
		}
	}
	
	/**
	 * Decide whether the player earned the 'Champion on hard' achievement.
	 * @param listOfData - collection of all gameplay data.
	 * @param playername - name of the actual player.
	 * @return whether the given player's perfomance is eligable to unlock the 'Champion on hard' achievement.
	 */
	public boolean isChampionOnHard(Collection<GameData> listOfData, String playername) {
		logger.info("Champion on hard achievement checked.");
		List<GameData> tempForData = listOfData.stream()
					.filter(d -> d.getDifficulty().equals("hard"))
					.sorted((d1,d2) -> d2.getFinalScore() - d1.getFinalScore())
					.collect(Collectors.toList());
		if(tempForData.size() > 0) {
			return tempForData.get(0).getPlayerName().equals(playername);
		} else {
			return false;
		}
	}
}
