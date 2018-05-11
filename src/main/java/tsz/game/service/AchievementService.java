package tsz.game.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import tsz.game.model.GameData;

public class AchievementService {
	
	public boolean isInexpert(Collection<GameData> listOfData, String playername) {
		return listOfData.stream()
				.filter(d -> d.getFinalScore() == 0 && d.getDifficulty().equals("easy"))
				.map(d -> d.getPlayerName())
				.collect(Collectors.toList()).contains(playername);
	}
	
	public boolean isSkillfullBeginner(Collection<GameData> listOfData, String playername) {
		return listOfData.stream()
				.filter(d -> d.getFinalScore() >= 100 && d.getDifficulty().equals("easy"))
				.map(d -> d.getPlayerName())
				.collect(Collectors.toList()).contains(playername);
	}
	
	public boolean isPatient(Collection<GameData> listOfData, String playername) {
		return listOfData.stream()
				.filter(d -> d.getFinalScore() >= 1000 && d.getDifficulty().equals("easy"))
				.map(d -> d.getPlayerName())
				.collect(Collectors.toList()).contains(playername);
	}
	
	public boolean isProfessional(Collection<GameData> listOfData, String playername) {
		return listOfData.stream()
				.filter(d -> d.getFinalScore() >= 100 && d.getDifficulty().equals("hard"))
				.map(d -> d.getPlayerName())
				.collect(Collectors.toList()).contains(playername);
	}
			
	public boolean isChampionOnEasy(Collection<GameData> listOfData, String playername) {
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
	
	public boolean isChampionOnMedium(Collection<GameData> listOfData, String playername) {
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
	
	public boolean isChampionOnHard(Collection<GameData> listOfData, String playername) {
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
