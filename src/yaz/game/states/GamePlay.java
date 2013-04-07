package yaz.game.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GamePlay extends BasicGameState {

	Image MMBackground = null;
	protected int mainmenuvalue = 0;
	
	protected int GAMEPLAY = 2;
	
	@SuppressWarnings("unused")
	private int MouseX, MouseY, Frame; 

	public GamePlay(int gameplaystate) {
		this.GAMEPLAY = gameplaystate;
	}

	@Override
	public int getID() {
		return this.GAMEPLAY;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame stg) throws SlickException {
		gc.setTargetFrameRate(60);
		gc.setVSync(true);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame stg, Graphics g) throws SlickException {
		
	}

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
