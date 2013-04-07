package yaz.game.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import yaz.game.main.yaz;

public class OptionsMenu extends BasicGameState {

	protected int OPTIONSMENU = 0;
	
	Image OMBackground = null;
	@SuppressWarnings("unused")
	private int MouseX, MouseY;
	
	public OptionsMenu(int optionsMenuState){
		this.OPTIONSMENU = optionsMenuState;
	}
	
	@Override
	public int getID() {
		return OPTIONSMENU;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame stg) throws SlickException {
		OMBackground = new Image("res/OPT_Background.PNG");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame stg, Graphics g) throws SlickException {
		OMBackground.draw(0, 0);
		g.drawString("Current Resolution: ", 50, 250);
		g.drawString(yaz.ScreenWidth + ", " + yaz.ScreenHeight, 240, 250);
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
