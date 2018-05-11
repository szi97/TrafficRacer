package tsz.game.model;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tsz.game.view.GameView;

public class GameWindow {
	private List<Car> obstacleCars;
	private Player player;
	
	Logger logger = LoggerFactory.getLogger("GameWindow.class");

	
	public GameWindow(List<Car> cars, Player player) {
		this.obstacleCars = cars;
		this.player = player;
	}
	
	public List<Car> getOCars() {
		return obstacleCars;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void addNewCar(List<Car> obstacleCars) {
		int randomForTheAmountOfCars = new Random().nextInt(4);
		int numberOfCars;
		
		numberOfCars = decidingTheAmountOfCars(randomForTheAmountOfCars);
		
		for(int i = 0; i < numberOfCars; i++) { 
            int position = new Random().nextInt(5);
            generatingCars(this.obstacleCars, position);
		}
		
		logger.info("New cars are added.");
            
	}
	
	public int decidingTheAmountOfCars(int randomForTheAmountOfCars) {
		int returnable = 0;
		switch(randomForTheAmountOfCars) {
		case 0 : case 1 : case 2:
			returnable = 3;
			break;
		case 3: case 4: case 5:
			returnable = 2;
			break;
		default: returnable = 1;
		}
		return returnable;
	}
	
	public void generatingCars(List<Car> obstacleCars, int position) {
		Car c = new Car((position+0.1)*GameView.getLaneWidth(),-100);
        int color = new Random().nextInt(5);
        c.setColor(Integer.toString(color));
        obstacleCars.add(c);
	}
	
	public void moveDownCars() {
		for(Car i : this.obstacleCars){
        	i.moveDown(i.getSpeed()*player.getPlayersCar().getSpeed());
        	this.obstacleCars.stream()
        	.filter(k -> k.getX() == i.getX() && i.getY() < k.getY() + 30 && k.getSpeed() < i.getSpeed())
        	.forEach(k -> k.setSpeed(i.getSpeed()));
        }
	}
	
	public void deleteCar() {
		player.increaseScore(offScreenCars().size());
		obstacleCars.removeAll(offScreenCars());
	}
	
	public List<Car> offScreenCars(){
		return obstacleCars.stream().filter( i-> i.getY() > GameView.getHeight()).collect(Collectors.toList());
	}

}
