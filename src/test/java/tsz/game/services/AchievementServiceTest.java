package tsz.game.services;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import tsz.game.model.GameData;
import tsz.game.service.AchievementService;

public class AchievementServiceTest {
	
	AchievementService service = new AchievementService();
	
	@Test
	public void testIsInexpert_should_return_true() {
		Collection<GameData> gamedataArray = new ArrayList<GameData>();
		GameData gamedata1 = new GameData();
		GameData gamedata2 = new GameData();
		GameData gamedata3 = new GameData();
		gamedata1.setPlayerName("Pisti");
		gamedata2.setPlayerName("Merci");
		gamedata3.setPlayerName("Pisti");
		gamedata1.setDifficulty("easy");
		gamedata2.setDifficulty("hard");
		gamedata3.setDifficulty("medium");
		gamedata1.setFinalScore(0);
		gamedata2.setFinalScore(10);
		gamedata3.setFinalScore(10);
		gamedataArray.add(gamedata1);
		gamedataArray.add(gamedata2);
		gamedataArray.add(gamedata3);
		
		assertTrue(service.isInexpert(gamedataArray, "Pisti"));
	}
	
	@Test
	public void testIsInexpert_should_return_false() {
		Collection<GameData> gamedataArray = new ArrayList<GameData>();
		GameData gamedata1 = new GameData();
		GameData gamedata2 = new GameData();
		GameData gamedata3 = new GameData();
		gamedata1.setPlayerName("Pisti");
		gamedata2.setPlayerName("Merci");
		gamedata3.setPlayerName("Pisti");
		gamedata1.setDifficulty("easy");
		gamedata2.setDifficulty("hard");
		gamedata3.setDifficulty("medium");
		gamedata1.setFinalScore(30);
		gamedata2.setFinalScore(0);
		gamedata3.setFinalScore(10);
		gamedataArray.add(gamedata1);
		gamedataArray.add(gamedata2);
		gamedataArray.add(gamedata3);
		
		assertFalse(service.isInexpert(gamedataArray, "Pisti"));
	}
	
	@Test
	public void testIsSkillfullBeginner_should_return_true() {
		Collection<GameData> gamedataArray = new ArrayList<GameData>();
		GameData gamedata1 = new GameData();
		GameData gamedata2 = new GameData();
		GameData gamedata3 = new GameData();
		gamedata1.setPlayerName("Pisti");
		gamedata2.setPlayerName("Merci");
		gamedata3.setPlayerName("Pisti");
		gamedata1.setDifficulty("easy");
		gamedata2.setDifficulty("hard");
		gamedata3.setDifficulty("medium");
		gamedata1.setFinalScore(200);
		gamedata2.setFinalScore(0);
		gamedata3.setFinalScore(10);
		gamedataArray.add(gamedata1);
		gamedataArray.add(gamedata2);
		gamedataArray.add(gamedata3);
		
		assertTrue(service.isSkillfullBeginner(gamedataArray, "Pisti"));
	}
	
	@Test
	public void testIsSkillfullBeginner_should_return_false() {
		Collection<GameData> gamedataArray = new ArrayList<GameData>();
		GameData gamedata1 = new GameData();
		GameData gamedata2 = new GameData();
		GameData gamedata3 = new GameData();
		gamedata1.setPlayerName("Pisti");
		gamedata2.setPlayerName("Merci");
		gamedata3.setPlayerName("Pisti");
		gamedata1.setDifficulty("easy");
		gamedata2.setDifficulty("hard");
		gamedata3.setDifficulty("medium");
		gamedata1.setFinalScore(10);
		gamedata2.setFinalScore(0);
		gamedata3.setFinalScore(10);
		gamedataArray.add(gamedata1);
		gamedataArray.add(gamedata2);
		gamedataArray.add(gamedata3);
		
		assertFalse(service.isSkillfullBeginner(gamedataArray, "Pisti"));
	}
	
	@Test
	public void testIsPatient_should_return_true() {
		Collection<GameData> gamedataArray = new ArrayList<GameData>();
		GameData gamedata1 = new GameData();
		GameData gamedata2 = new GameData();
		GameData gamedata3 = new GameData();
		gamedata1.setPlayerName("Pisti");
		gamedata2.setPlayerName("Merci");
		gamedata3.setPlayerName("Pisti");
		gamedata1.setDifficulty("easy");
		gamedata2.setDifficulty("hard");
		gamedata3.setDifficulty("medium");
		gamedata1.setFinalScore(1200);
		gamedata2.setFinalScore(0);
		gamedata3.setFinalScore(10);
		gamedataArray.add(gamedata1);
		gamedataArray.add(gamedata2);
		gamedataArray.add(gamedata3);
		
		assertTrue(service.isPatient(gamedataArray, "Pisti"));
	}
	
	@Test
	public void testIsPatient_should_return_false() {
		Collection<GameData> gamedataArray = new ArrayList<GameData>();
		GameData gamedata1 = new GameData();
		GameData gamedata2 = new GameData();
		GameData gamedata3 = new GameData();
		gamedata1.setPlayerName("Pisti");
		gamedata2.setPlayerName("Merci");
		gamedata3.setPlayerName("Pisti");
		gamedata1.setDifficulty("easy");
		gamedata2.setDifficulty("hard");
		gamedata3.setDifficulty("medium");
		gamedata1.setFinalScore(500);
		gamedata2.setFinalScore(0);
		gamedata3.setFinalScore(10);
		gamedataArray.add(gamedata1);
		gamedataArray.add(gamedata2);
		gamedataArray.add(gamedata3);
		
		assertFalse(service.isPatient(gamedataArray, "Pisti"));
	}
	
	@Test
	public void testIsProfessional_should_return_true() {
		Collection<GameData> gamedataArray = new ArrayList<GameData>();
		GameData gamedata1 = new GameData();
		GameData gamedata2 = new GameData();
		GameData gamedata3 = new GameData();
		gamedata1.setPlayerName("Pisti");
		gamedata2.setPlayerName("Merci");
		gamedata3.setPlayerName("Pisti");
		gamedata1.setDifficulty("easy");
		gamedata2.setDifficulty("medium");
		gamedata3.setDifficulty("hard");
		gamedata1.setFinalScore(10);
		gamedata2.setFinalScore(0);
		gamedata3.setFinalScore(150);
		gamedataArray.add(gamedata1);
		gamedataArray.add(gamedata2);
		gamedataArray.add(gamedata3);
		
		assertTrue(service.isProfessional(gamedataArray, "Pisti"));
	}
	
	@Test
	public void testIsProfessional_should_return_false() {
		Collection<GameData> gamedataArray = new ArrayList<GameData>();
		GameData gamedata1 = new GameData();
		GameData gamedata2 = new GameData();
		GameData gamedata3 = new GameData();
		gamedata1.setPlayerName("Pisti");
		gamedata2.setPlayerName("Merci");
		gamedata3.setPlayerName("Pisti");
		gamedata1.setDifficulty("easy");
		gamedata2.setDifficulty("hard");
		gamedata3.setDifficulty("hards");
		gamedata1.setFinalScore(10);
		gamedata2.setFinalScore(45);
		gamedata3.setFinalScore(10);
		gamedataArray.add(gamedata1);
		gamedataArray.add(gamedata2);
		gamedataArray.add(gamedata3);
		
		assertFalse(service.isProfessional(gamedataArray, "Pisti"));
	}
	
	@Test
	public void testIsChampionOnEasy_should_return_true() {
		Collection<GameData> gamedataArray = new ArrayList<GameData>();
		GameData gamedata1 = new GameData();
		GameData gamedata2 = new GameData();
		GameData gamedata3 = new GameData();
		gamedata1.setPlayerName("Pisti");
		gamedata2.setPlayerName("Merci");
		gamedata3.setPlayerName("Pisti");
		gamedata1.setDifficulty("easy");
		gamedata2.setDifficulty("easy");
		gamedata3.setDifficulty("medium");
		gamedata1.setFinalScore(200);
		gamedata2.setFinalScore(140);
		gamedata3.setFinalScore(10);
		gamedataArray.add(gamedata1);
		gamedataArray.add(gamedata2);
		gamedataArray.add(gamedata3);
		
		assertTrue(service.isChampionOnEasy(gamedataArray, "Pisti"));
	}
	
	@Test
	public void testIsCahmpionOnEasy_should_return_false() {
		Collection<GameData> gamedataArray = new ArrayList<GameData>();
		GameData gamedata1 = new GameData();
		GameData gamedata2 = new GameData();
		GameData gamedata3 = new GameData();
		gamedata1.setPlayerName("Pisti");
		gamedata2.setPlayerName("Merci");
		gamedata3.setPlayerName("Pisti");
		gamedata1.setDifficulty("easy");
		gamedata2.setDifficulty("easy");
		gamedata3.setDifficulty("medium");
		gamedata1.setFinalScore(10);
		gamedata2.setFinalScore(120);
		gamedata3.setFinalScore(10);
		gamedataArray.add(gamedata1);
		gamedataArray.add(gamedata2);
		gamedataArray.add(gamedata3);
		
		assertFalse(service.isChampionOnEasy(gamedataArray, "Pisti"));
	}
	
	@Test
	public void testIsCahmpionOnEasy_should_return_false_because_noone_played_on_easy() {
		Collection<GameData> gamedataArray = new ArrayList<GameData>();
		GameData gamedata1 = new GameData();
		GameData gamedata2 = new GameData();
		gamedata1.setPlayerName("Pisti");
		gamedata2.setPlayerName("Merci");
		gamedata1.setDifficulty("medium");
		gamedata2.setDifficulty("hard");
		gamedata1.setFinalScore(10);
		gamedata2.setFinalScore(120);
		gamedataArray.add(gamedata1);
		gamedataArray.add(gamedata2);
		
		assertFalse(service.isChampionOnEasy(gamedataArray, "Pisti"));
	}
	
	@Test
	public void testIsCahmpionOnMedium_should_return_true() {
		Collection<GameData> gamedataArray = new ArrayList<GameData>();
		GameData gamedata1 = new GameData();
		GameData gamedata2 = new GameData();
		GameData gamedata3 = new GameData();
		gamedata1.setPlayerName("Pisti");
		gamedata2.setPlayerName("Merci");
		gamedata3.setPlayerName("Pisti");
		gamedata1.setDifficulty("medium");
		gamedata2.setDifficulty("medium");
		gamedata3.setDifficulty("medium");
		gamedata1.setFinalScore(130);
		gamedata2.setFinalScore(120);
		gamedata3.setFinalScore(10);
		gamedataArray.add(gamedata1);
		gamedataArray.add(gamedata2);
		gamedataArray.add(gamedata3);
		
		assertTrue(service.isChampionOnMedium(gamedataArray, "Pisti"));
	}
	
	@Test
	public void testIsCahmpionOnMedium_should_return_false() {
		Collection<GameData> gamedataArray = new ArrayList<GameData>();
		GameData gamedata1 = new GameData();
		GameData gamedata2 = new GameData();
		GameData gamedata3 = new GameData();
		gamedata1.setPlayerName("Pisti");
		gamedata2.setPlayerName("Merci");
		gamedata3.setPlayerName("Jani");
		gamedata1.setDifficulty("medium");
		gamedata2.setDifficulty("medium");
		gamedata3.setDifficulty("medium");
		gamedata1.setFinalScore(10);
		gamedata2.setFinalScore(120);
		gamedata3.setFinalScore(10);
		gamedataArray.add(gamedata1);
		gamedataArray.add(gamedata2);
		gamedataArray.add(gamedata3);
		
		assertFalse(service.isChampionOnMedium(gamedataArray, "Pisti"));
	}
	
	@Test
	public void testIsCahmpionOnMedium_should_return_false_because_noone_played_on_medium() {
		Collection<GameData> gamedataArray = new ArrayList<GameData>();
		GameData gamedata1 = new GameData();
		GameData gamedata2 = new GameData();
		gamedata1.setPlayerName("Pisti");
		gamedata2.setPlayerName("Merci");
		gamedata1.setDifficulty("easy");
		gamedata2.setDifficulty("hard");
		gamedata1.setFinalScore(10);
		gamedata2.setFinalScore(120);
		gamedataArray.add(gamedata1);
		gamedataArray.add(gamedata2);
		
		assertFalse(service.isChampionOnMedium(gamedataArray, "Pisti"));
	}
	
	@Test
	public void testIsCahmpionOnHard_should_return_true() {
		Collection<GameData> gamedataArray = new ArrayList<GameData>();
		GameData gamedata1 = new GameData();
		GameData gamedata2 = new GameData();
		GameData gamedata3 = new GameData();
		gamedata1.setPlayerName("Pisti");
		gamedata2.setPlayerName("Merci");
		gamedata3.setPlayerName("Jani");
		gamedata1.setDifficulty("hard");
		gamedata2.setDifficulty("hard");
		gamedata3.setDifficulty("medium");
		gamedata1.setFinalScore(400);
		gamedata2.setFinalScore(120);
		gamedata3.setFinalScore(10);
		gamedataArray.add(gamedata1);
		gamedataArray.add(gamedata2);
		gamedataArray.add(gamedata3);
		
		assertTrue(service.isChampionOnHard(gamedataArray, "Pisti"));
	}
	
	@Test
	public void testIsCahmpionOnHard_should_return_false() {
		Collection<GameData> gamedataArray = new ArrayList<GameData>();
		GameData gamedata1 = new GameData();
		GameData gamedata2 = new GameData();
		GameData gamedata3 = new GameData();
		gamedata1.setPlayerName("Pisti");
		gamedata2.setPlayerName("Merci");
		gamedata3.setPlayerName("Jani");
		gamedata1.setDifficulty("hard");
		gamedata2.setDifficulty("hard");
		gamedata3.setDifficulty("medium");
		gamedata1.setFinalScore(89);
		gamedata2.setFinalScore(120);
		gamedata3.setFinalScore(10);
		gamedataArray.add(gamedata1);
		gamedataArray.add(gamedata2);
		gamedataArray.add(gamedata3);
		
		assertFalse(service.isChampionOnHard(gamedataArray, "Pisti"));
	}
	
	@Test
	public void testIsCahmpionOnHard_should_return_false_because_noone_played_on_hard() {
		Collection<GameData> gamedataArray = new ArrayList<GameData>();
		GameData gamedata1 = new GameData();
		GameData gamedata2 = new GameData();
		gamedata1.setPlayerName("Pisti");
		gamedata2.setPlayerName("Merci");
		gamedata1.setDifficulty("easy");
		gamedata2.setDifficulty("medium");
		gamedata1.setFinalScore(89);
		gamedata2.setFinalScore(120);
		gamedataArray.add(gamedata1);
		gamedataArray.add(gamedata2);
		
		assertFalse(service.isChampionOnHard(gamedataArray, "Pisti"));
	}
	
}
