package tsz.game.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tsz.game.model.GameData;

/**
 * Class of essential business logic for the top list.
 * 
 * @author szi
 *
 */
public class TopListService {
	
	/**
	 * Logger.
	 */
	Logger logger = LoggerFactory.getLogger("TopListService.class");
	
	/**
	 * Get ten games width the highest scores.
	 * @param listOfData - collection of gameplay datas.
	 * @return list of the game data width the highest scores.
	 */
	public List<GameData> getTopTen(Collection<GameData> listOfData, String difficulty){
		
		logger.info("Top List on " + difficulty + " created.");	
		
		List<GameData> tempList = listOfData.stream()
									.filter(d -> d.getDifficulty().equals(difficulty))
									.collect(Collectors.toList());
		if(tempList.size()>=10) {
			return tempList.stream()
					.sorted((d1,d2) -> d2.getFinalScore() - d1.getFinalScore())
					.collect(Collectors.toList()).subList(0, 10);
		} else {
			return tempList.stream()
					.sorted((d1,d2) -> d2.getFinalScore() - d1.getFinalScore())
					.collect(Collectors.toList());
		}	
	}
}
