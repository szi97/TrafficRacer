package tsz.game.model;

public class GameData {

	private String playerName;
	private int finalScore;
	private String difficulty;
	
	public String getPlayerName() {
		return playerName;
	}
	
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public int getFinalScore() {
		return finalScore;
	}
	
	public void setFinalScore(int finalScore) {
		this.finalScore = finalScore;
	}
	
	public String getDifficulty() {
		return difficulty;
	}
	
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
}
