package tsz.game.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class of a player.
 * 
 * @author szi
 *
 */
public class Player {
	
	/**
	 * Player's car.
	 */
	private PlayersCar playersCar;
	
	/**
	 * Player's name. It's anonymus by default.
	 */
	private String playername = "anonymus";
	
	/**
	 * Player's score.
	 */
	private int score;
	
	/**
	 * Difficulty.
	 */
	private String difficulty = "easy";
	
	/**
	 * Logger.
	 */
	Logger logger = LoggerFactory.getLogger("Player.class");
	
	/**
	 * Constructor.
	 */
	public Player() {
		this.playersCar = new PlayersCar();
		this.score = 0;
	}
	
	/**
	 * @return the player's car.
	 */
	public PlayersCar getPlayersCar() {
		return this.playersCar;
	}
	
	/**
	 * Sets the Player's name.
	 * @param name - name of the player.
	 */
	public void setName(String name) {
		this.playername = name;
	}
	
	/**
	 * @return the player's name.
	 */
	public String getName() {
		return this.playername;
	}

	/**
	 * Increases the score.
	 * @param score - value to add to the score.
	 */
	public void increaseScore(int score) {
		this.score += score;
	}
	
	/**
	 * @return the score.
	 */
	public int getScore() {
		return this.score;
	}
	
	/**
	 * @param playername - the palyer's name.
	 * @return whether the player's name is valid or not.
	 */
	public boolean isPlayerNameValid(String playername) {
		logger.info("Playername checked.");
		return playername.matches("[A-Za-z0-9]+");
	}

	/**
	 * @return the difficulty.
	 */
	public String getDifficulty() {
		return difficulty;
	}

	/**
	 * Sets the difficulty.
	 * @param difficulty - difficulty.
	 */
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	
}
