package tsz.game.view;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

/**
 * Interface the controller's event handler for the GameView.
 * 
 * @author szi
 *
 */
public interface ActionOnKeyEvents {
	/**
	 * Handles a key event.
	 * @return - the event which occurs.
	 */
	public EventHandler<? super KeyEvent> moving();	
	
	/**
	 * Handles a key event.
	 * @return - the event which occurs. 
	 */
	public EventHandler<? super KeyEvent> stopMoving();	
	
}
