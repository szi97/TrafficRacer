package tsz.game.service;

import java.util.Collection;

import tsz.game.model.GameData;

/**
 * Class of essential business logic for the game over window.
 * 
 * @author szi
 *
 */
public class GameOverService {
	/**
	 * Get the highest score of all time.
	 * @param listOfData - collection of gameplay datas.
	 * @return the highest score of all time.
	 */
	public int getHighestScore(Collection<GameData> listOfData) {
		return listOfData.stream()
		.mapToInt(d -> d.getFinalScore()).max().orElse(0);
	}
}
