package tsz.game.model;

public class Player {
	
	private PlayersCar playersCar;
	private String playername = "anonymus";
	private int score;
	
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
	
}
