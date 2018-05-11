package tsz.game.services;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import tsz.game.model.GameData;
import tsz.game.service.GameOverService;

//@RunWith(MockitoJUnitRunner.class)
public class GameOverServiceTest {

	private GameOverService service = new GameOverService();
	
	@Test
	public void testGetHighest_should_return_the_highest_score() {
		Collection<GameData> gamedataArray = new ArrayList<GameData>();
		GameData gamedata1 = new GameData();
		GameData gamedata2 = new GameData();
		GameData gamedata3 = new GameData();
		gamedata1.setFinalScore(350);
		gamedata2.setFinalScore(444);
		gamedata3.setFinalScore(210);
		gamedataArray.add(gamedata1);
		gamedataArray.add(gamedata2);
		gamedataArray.add(gamedata3);
		
		assertEquals(444, service.getHighestScore(gamedataArray));
	}
}
