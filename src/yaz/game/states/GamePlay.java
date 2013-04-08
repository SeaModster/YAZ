package yaz.game.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GamePlay extends BasicGameState {

	Image GPBackground = null;	
	protected int GAMEPLAY = 2;
	
	@SuppressWarnings("unused")
	private int MouseX, MouseY, Frame; 

	/**
	 * Constructor that initializes the identifier integer (2 by default).
	 * 
	 * @param gameplaystate the integer identifier
	 */
	public GamePlay(int gameplaystate) {
		this.GAMEPLAY = gameplaystate;
	}

	/**
	 * Get method that gives the identifier.
	 * 
	 * @return integer identifier
	 */
	@Override
	public int getID() {
		return this.GAMEPLAY;
	}

	/**
	 * Initializes the resources for this state.
	 * 
	 * @param gc the GameContainer
	 * @param stg represents the game itself
	 * @throws SlickException general slick2d exception
	 */
	@Override
	public void init(GameContainer gc, StateBasedGame stg) throws SlickException {
		gc.setTargetFrameRate(60);
		gc.setVSync(true);
	}

	/**
	 * Renders this state (currently nothing to render!).
	 * 
	 * @param gc the GameContainer
	 * @param stg represents the game itself
	 * @param g the graphics resources
	 * @throws SlickException general slick2d exception
	 */
	@Override
	public void render(GameContainer gc, StateBasedGame stg, Graphics g) throws SlickException {
		//Code goes here n' shit
	}

	/**
	 * Updates this state with any potential user input.
	 * 
	 * @param gc the GameContainer
	 * @param stg represents the game itself
	 * @param delta frames
	 * @throws SlickException general slick2d exception
	 */
	@Override
	public void update(GameContainer gc, StateBasedGame stg, int delta) throws SlickException {
		Input i = gc.getInput();
		MouseX = i.getMouseX();
		MouseY = i.getMouseY();
		if(i.isKeyPressed(Input.KEY_ENTER)) {
			stg.enterState(1);
		}
	}

}
