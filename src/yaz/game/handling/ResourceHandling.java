package yaz.game.handling;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.PackedSpriteSheet;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import yaz.game.main.yaz;
import yaz.game.states.Credits;
import yaz.game.states.GamePlay;
import yaz.game.states.MainMenu;
import yaz.game.states.Opening;
import yaz.game.states.OptionsMenu;

public class ResourceHandling extends BasicGameState {

	PackedSpriteSheet lo_sheet;
	protected int INIT = 5;
	
	@SuppressWarnings("unused")
	private int MouseX, MouseY, Frame; 

	public ResourceHandling(int resourceshandling) {
		this.INIT = resourceshandling;
	}
	
	/**
	 * Get method that gives the identifier.
	 * 
	 * @return integer identifier
	 */
	@Override
	public int getID() {
		return this.INIT;
	}

	/**
	 * Initializes the resource handler's sprite sheet.
	 * 
	 * @param gc the GameContainer
	 * @param stg represents the game itself
	 * @throws SlickException general slick2d exception
	 */
	@Override
	public void init(GameContainer gc, StateBasedGame stg) throws SlickException {
		lo_sheet = new PackedSpriteSheet("res/SpriteSheet_Loading.def");
		
	}

	/**
	 * Renders the resources for the handler (nothing to render!).
	 * 
	 * @param gc the GameContainer
	 * @param stg represents the game itself
	 * @param g the graphics resources
	 * @throws SlickException general slick2d exception
	 */
	@Override
	public void render(GameContainer gc, StateBasedGame stg, Graphics g) throws SlickException {
		//Nothing to render for the resource handler.
	}

	/**
	 * Loads all of the game states.
	 * 
	 * @param gc the GameContainer
	 * @param stg represents the game itself
	 * @param delta frames
	 * @throws SlickException general slick2d exception
	 */
	@Override
	public void update(GameContainer gc, StateBasedGame stg, int delta) throws SlickException {
		stg.addState(new Opening(yaz.OPENINGSTATE));
		stg.addState(new MainMenu(yaz.GAMEMENUSTATE));
		stg.addState(new GamePlay(yaz.GAMEPLAYSTATE));
		stg.addState(new Credits(yaz.CREDITSSTATE));
		stg.addState(new OptionsMenu(yaz.OPTIONSMENUSTATE));
	}
	
}
