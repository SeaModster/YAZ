package yaz.game.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Credits extends BasicGameState {
	
	Image CRE_Background;
	protected int CREDItS = 3;
	
	@SuppressWarnings("unused")
	private int MouseX, MouseY, Frame; 

	public Credits(int gameopeningstate) {
		this.CREDItS = gameopeningstate;
	}
	
	@Override
	public int getID() {
		return this.CREDItS;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame stg) throws SlickException {
		CRE_Background = new Image("res/CRE_Background.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame stg, Graphics g) throws SlickException {
		CRE_Background.draw(0, 0);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame stg, int delta) throws SlickException {
		Input i = gc.getInput();
		MouseX = gc.getInput().getMouseX();
		MouseY = gc.getInput().getMouseY();
		Frame = delta;
		if(i.isKeyPressed(Input.KEY_ENTER) || i.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
			stg.enterState(1);
		}
	}

}
