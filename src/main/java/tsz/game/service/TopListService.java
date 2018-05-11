package tsz.game.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import tsz.game.model.GameData;

public class TopListService {
	public List<GameData> getTopTen(Collection<GameData> listOfData){
		if(listOfData.size()>=10) {
			return listOfData.stream()
					.sorted((d1,d2) -> d2.getFinalScore() - d1.getFinalScore())
					.collect(Collectors.toList()).subList(0, 10);
		} else {
			return listOfData.stream()
					.sorted((d1,d2) -> d2.getFinalScore() - d1.getFinalScore())
					.collect(Collectors.toList());
		}
		
	}
}
