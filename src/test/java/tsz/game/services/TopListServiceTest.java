package tsz.game.services;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import tsz.game.model.GameData;
import tsz.game.service.TopListService;

public class TopListServiceTest {
	
	private TopListService service = new TopListService();
	
	@Test
	public void testGetTopTen() {
		List<GameData> input = new ArrayList<GameData>();
		GameData gamedata1 = new GameData();
		GameData gamedata2 = new GameData();
		GameData gamedata3 = new GameData();
		gamedata1.setFinalScore(110);
		gamedata2.setFinalScore(320);
		gamedata3.setFinalScore(210);
		input.add(gamedata1);
		input.add(gamedata2);
		input.add(gamedata3);
		
		List<GameData> output = new ArrayList<GameData>();
		output.add(gamedata2);
		output.add(gamedata3);
		output.add(gamedata1);
		
		assertEquals(output, service.getTopTen(input));
	}
	
	@Test
	public void testGetTopTen_for_eleven_games() {
		List<GameData> input = new ArrayList<GameData>();
		GameData gamedata1 = new GameData();
		GameData gamedata2 = new GameData();
		GameData gamedata3 = new GameData();
		GameData gamedata4 = new GameData();
		GameData gamedata5 = new GameData();
		GameData gamedata6 = new GameData();
		GameData gamedata7 = new GameData();
		GameData gamedata8 = new GameData();
		GameData gamedata9 = new GameData();
		GameData gamedata10 = new GameData();
		GameData gamedata11 = new GameData();
		gamedata1.setFinalScore(110);
		gamedata2.setFinalScore(320);
		gamedata3.setFinalScore(210);
		gamedata4.setFinalScore(211);
		gamedata5.setFinalScore(212);
		gamedata6.setFinalScore(213);
		gamedata7.setFinalScore(214);
		gamedata8.setFinalScore(230);
		gamedata9.setFinalScore(220);
		gamedata10.setFinalScore(350);
		gamedata11.setFinalScore(40);
		input.add(gamedata1);
		input.add(gamedata2);
		input.add(gamedata3);
		input.add(gamedata4);
		input.add(gamedata5);
		input.add(gamedata6);
		input.add(gamedata7);
		input.add(gamedata8);
		input.add(gamedata9);
		input.add(gamedata10);
		input.add(gamedata11);
		
		List<GameData> output = new ArrayList<GameData>();
		output.add(gamedata10);
		output.add(gamedata2);
		output.add(gamedata8);
		output.add(gamedata9);
		output.add(gamedata7);
		output.add(gamedata6);
		output.add(gamedata5);
		output.add(gamedata4);
		output.add(gamedata3);
		output.add(gamedata1);
		
		assertEquals(output, service.getTopTen(input));
	}
}
