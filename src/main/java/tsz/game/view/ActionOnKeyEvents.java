package tsz.game.view;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public interface ActionOnKeyEvents {
	public EventHandler<? super KeyEvent> moving();	
	
	public EventHandler<? super KeyEvent> stopMoving();	
	
}
