package tsz.game.model;

public class Player {
	
	private PlayersCar playersCar;
	private String playername = "anonymus";
	private int score;
	private String difficulty = "easy";
	
	public Player() {
		this.playersCar = new PlayersCar();
		this.score = 0;
	}
	
	public PlayersCar getPlayersCar() {
		return this.playersCar;
	}
	
	public void setName(String name) {
		this.playername = name;
	}
	
	public String getName() {
		return this.playername;
	}

	public void increaseScore(int score) {
		this.score += score;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public boolean isPlayerNameValid() {
		return playername.matches("[A-Za-z0-9]+");
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	
}
