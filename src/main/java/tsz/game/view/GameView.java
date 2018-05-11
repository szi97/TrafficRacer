package tsz.game.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

import java.io.IOException;
import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.VPos;
import javafx.scene.Group;
import tsz.game.model.Car;
import tsz.game.model.GameWindow;

public class GameView extends Group{
	private Canvas canvas;
	private GraphicsContext graphicsContext;
	private static final int WIDTH = 400;
	private static final int HEIGHT = 700;
	private static int numberOfLanes = 5;
	private static int laneWidth = WIDTH / numberOfLanes;
	
	public static int getWidth() {
		return WIDTH;
	}
	public static int getHeight() {
		return HEIGHT;
	}
	
	public static int getLaneWidth() {
		return laneWidth;
	}
	
	public void setNumberOfLanes(int n) {
		GameView.numberOfLanes = n;
		laneWidth = WIDTH / numberOfLanes;
	}
	
	public GameView() {
		setUp();
	}
		
	public void setUp() {
		canvas = new Canvas(WIDTH,HEIGHT);

		graphicsContext = canvas.getGraphicsContext2D();

		getChildren().add(canvas);
	}
	
	public void draw(GameWindow window) {
		graphicsContext.clearRect(0, 0, WIDTH, HEIGHT);
		
		for(int i = 0; i < GameView.numberOfLanes ; i++) {
			graphicsContext.setFill(Color.WHITE);
			graphicsContext.fillRect((i+1)*GameView.getLaneWidth(), 0, 1, GameView.HEIGHT);
		}
				
		drawOCars(window);
		drawPlayersCar(window);
		showScore(window);
		
	}
	
	public void drawOCars(GameWindow window) {
		 for(Car i : window.getOCars()) {
				try {
					graphicsContext.drawImage(SwingFXUtils.toFXImage(ImageIO.read(this.getClass().getResource("/Images/oCars/" + i.getColor() + ".png")),null), i.getX(), i.getY());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	 }
	 
	 public void drawPlayersCar(GameWindow window) {
		 try {
				graphicsContext.drawImage(
						SwingFXUtils.toFXImage(ImageIO.read(this.getClass().getResource("/Images/playerCars/" + window.getPlayer().getPlayersCar().getColor() + ".png")),null), 
						window.getPlayer().getPlayersCar().getX(), 
						window.getPlayer().getPlayersCar().getY());
			} catch (IOException e) {
				e.printStackTrace();
			}
	 }
	 
	 public void showScore(GameWindow window) {
		 graphicsContext.setTextAlign(TextAlignment.CENTER);
	        graphicsContext.setTextBaseline(VPos.CENTER);
	        graphicsContext.fillText(
	        		Integer.toString(window.getPlayer().getScore()),
	        		WIDTH - 30, 
	        		HEIGHT - 60);
	 }
}
