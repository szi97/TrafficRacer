package tsz.game.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

import java.io.IOException;
import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.VPos;
import javafx.scene.Group;
import tsz.game.model.Car;
import tsz.game.model.GameWindow;

/**
 * Class of the game view.
 * @author szi
 *
 */
public class GameView extends Group{
	/**
	 * Canvas to daw on.
	 */
	private Canvas canvas;
	/**
	 * Graphic context.
	 */
	private GraphicsContext graphicsContext;
	/**
	 * Width of the game.
	 */
	private static final int WIDTH = 400;
	/**
	 * Height of the game.
	 */
	private static final int HEIGHT = 700;
	/**
	 * Number of lanes in the game.
	 */
	private int numberOfLanes = 5;
	/**
	 * Width of the lanes.
	 */
	private int laneWidth = WIDTH / numberOfLanes;
	
	Logger logger = LoggerFactory.getLogger("GameView.class");
	
	/**
	 * @return the width of the game.
	 */
	public static int getWidth() {
		return WIDTH;
	}
	
	/**
	 * @return the height of the game.
	 */
	public static int getHeight() {
		return HEIGHT;
	}
	
	/**
	 * @return the width of the lanes.
	 */
	public int getLaneWidth() {
		return laneWidth;
	}
	
	/**
	 * @param n - set the number of lanes to n.
	 */
	public void setNumberOfLanes(int n) {
		this.numberOfLanes = n;
		laneWidth = WIDTH / numberOfLanes;
	}
	
	/**
	 * Constructor.
	 */
	public GameView() {
		setUp();
	}
		
	/**
	 * Initialize the GameView.
	 */
	public void setUp() {
		canvas = new Canvas(WIDTH,HEIGHT);

		graphicsContext = canvas.getGraphicsContext2D();

		getChildren().add(canvas);
	}
	
	/**
	 * Draws on the game window.
	 * @param window - Window of the game.
	 */
	public void draw(GameWindow window) {
		graphicsContext.clearRect(0, 0, WIDTH, HEIGHT);
		
		for(int i = 0; i < this.numberOfLanes ; i++) {
			graphicsContext.setFill(Color.WHITE);
			graphicsContext.fillRect((i+1)*this.getLaneWidth(), 0, 1, GameView.HEIGHT);
		}
				
		drawOCars(window);
		drawPlayersCar(window);
		showScore(window);
		
	}
	
	/**
	 * Draws the obstacle cars on the window.
	 * @param window - window of the game.
	 */
	public void drawOCars(GameWindow window) {
		 for(Car i : window.getOCars()) {
				try {
					graphicsContext.drawImage(SwingFXUtils.toFXImage(ImageIO.read(this.getClass().getResource("/Images/oCars/" + i.getColor() + ".png")),null), i.getX(), i.getY());
				} catch (IOException e) {
					logger.error(e.toString());
				}
			}
	 }
	 
	 /**
	  * Draws player's car on the window.
	 * @param window - window of the game.
	 */
	public void drawPlayersCar(GameWindow window) {
		 try {
				graphicsContext.drawImage(
						SwingFXUtils.toFXImage(ImageIO.read(this.getClass().getResource("/Images/playerCars/" + window.getPlayer().getPlayersCar().getColor() + ".png")),null), 
						window.getPlayer().getPlayersCar().getX(), 
						window.getPlayer().getPlayersCar().getY());
			} catch (IOException e) {
				logger.error(e.toString());
			}
	 }
	 
	 /**
	  * Draws the actual score on the window.
	 * @param window - window of the game.
	 */
	public void showScore(GameWindow window) {
		 graphicsContext.setTextAlign(TextAlignment.CENTER);
	        graphicsContext.setTextBaseline(VPos.CENTER);
	        graphicsContext.fillText(
	        		Integer.toString(window.getPlayer().getScore()),
	        		WIDTH - 30, 
	        		HEIGHT - 60);
	 }
}
