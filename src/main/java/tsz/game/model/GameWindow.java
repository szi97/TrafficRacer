package tsz.game.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tsz.game.view.GameView;

/**
 * Class for game window.
 * @author szi
 *
 */
public class GameWindow {
	
	/**
	 * List of obstacle cars.
	 */
	private List<Car> obstacleCars;
	
	/**
	 * The player.
	 */
	private Player player;
	
	/**
	 * Logger.
	 */
	Logger logger = LoggerFactory.getLogger("GameWindow.class");

	
	/**
	 * Constructor.
	 * @param obstacleCars - obstacle cars in the game.
	 * @param player - player
	 */
	public GameWindow(List<Car> obstacleCars, Player player) {
		this.obstacleCars = obstacleCars;
		this.player = player;
	}
	
	/**
	 * @return obstacle cars.
	 */
	public List<Car> getOCars() {
		return obstacleCars;
	}
	
	/**
	 * @return the player.
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * Add new obstacle cars to the game.
	 * @param obstacleCars - list of existing obstacle cars.
	 */
	public void addNewCar(List<Car> obstacleCars) {
		int randomForTheAmountOfCars = new Random().nextInt(10);
		int numberOfCars = decidingTheAmountOfCars(randomForTheAmountOfCars);
		List<Integer> availableLanes = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4));
		
		for(int i = 0; i < numberOfCars; i++) {
            int position = new Random().nextInt(availableLanes.size());
            generatingCars(this.obstacleCars, availableLanes.get(position));
            availableLanes.remove(position);
		}
		
		logger.info("New cars are added.");
            
	}
	
	/**
	 * Decides the amount of cars to spawn.
	 * @param randomForTheAmountOfCars - random number.
	 * @return the amount of new cars to spawn.
	 */
	public int decidingTheAmountOfCars(int randomForTheAmountOfCars) {
		int returnable = 0;
		switch(randomForTheAmountOfCars) {
		case 0 : case 1 : 
			returnable = 1;
			break;
		case 2: case 3: case 4: case 5:
			returnable = 2;
			break;
		case 6: case 7: case 8:
			returnable = 3;
			break;
		default: returnable = 4;
		}
		return returnable;
	}
	
	/**
	 * Generates a new car.
	 * @param obstacleCars - this method add the new car to this list of obstacle cars.
	 * @param position - the position of the new car.
	 */
	public void generatingCars(List<Car> obstacleCars, int position) {
		GameView view = new GameView();
		Car c = new Car((position+0.1)*view.getLaneWidth(),-100);
        int color = new Random().nextInt(5);
        c.setColor(Integer.toString(color));
        obstacleCars.add(c);
	}
	
	/**
	 * Move down all of the obstacle cars.
	 */
	public void moveDownCars() {
		for(Car i : this.obstacleCars){
        	i.moveDown(i.getSpeed()*player.getPlayersCar().getSpeed());
        	this.obstacleCars.stream()
        	.filter(k -> k.getX() == i.getX() && i.getY() < k.getY() + 30 && k.getSpeed() < i.getSpeed())
        	.forEach(k -> k.setSpeed(i.getSpeed()));
        }
	}
	
	/**
	 * Delete the unnecessary cars.
	 */
	public void deleteCar() {
		player.increaseScore(offScreenCars().size());
		obstacleCars.removeAll(offScreenCars());
	}
	
	/**
	 * Check which cars are not on the screen.
	 * @return the list of those cars, which are not on the screen.
	 */
	public List<Car> offScreenCars(){
		return obstacleCars.stream().filter( i-> i.getY() > GameView.getHeight()).collect(Collectors.toList());
	}

}
