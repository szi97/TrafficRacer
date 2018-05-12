package tsz.game.model;

/**
 * Class for the game data.
 * 
 * @author szi
 *
 */
public class GameData {

	/**
	 * Player's name.
	 */
	private String playerName;
	
	/**
	 * Final score.
	 */
	private int finalScore;
	
	/**
	 * Difficulty.
	 */
	private String difficulty;
	
	/**
	 * @return the player's name.
	 */
	public String getPlayerName() {
		return playerName;
	}
	
	/**
	 * Sets the player's name.
	 * @param playerName - player's name.
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	/**
	 * @return the final score.
	 */
	public int getFinalScore() {
		return finalScore;
	}
	
	/**
	 * Sets the final score.
	 * @param finalScore - final score.
	 */
	public void setFinalScore(int finalScore) {
		this.finalScore = finalScore;
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
