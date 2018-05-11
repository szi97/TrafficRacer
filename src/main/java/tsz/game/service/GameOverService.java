package tsz.game.service;

import java.util.Collection;

import tsz.game.model.GameData;

public class GameOverService {
	public int getHighestScore(Collection<GameData> listOfData) {
		return listOfData.stream()
		.mapToInt(d -> d.getFinalScore()).max().orElse(0);
	}
}
