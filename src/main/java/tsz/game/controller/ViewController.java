package tsz.game.controller;

import tsz.game.view.MainApp;

/**
 * Controller class for different views ar extends this class.
 * 
 * @author szi
 *
 */
public abstract class ViewController {
	/**
	 * MainApp.
	 */
	protected MainApp main;
	
	/**
	 * @param main - MainApp to set.
	 */
	public void setMainApp(MainApp main) {
		this.main = main;
	}
}
