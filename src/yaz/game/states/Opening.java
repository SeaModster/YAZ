package yaz.game.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import yaz.game.handling.ResourceHandling;

public class Opening extends BasicGameState implements KeyListener {
	
	ResourceHandling reshandle = null;
	protected int GAMEOPENING = 0;
	
	@SuppressWarnings("unused")
	private int MouseX, MouseY, Frame; 
	private boolean anyKeyPressed = false;
	private boolean anyMouseKeyPressed = false;
	
	public Opening(int gameopeningstate) {
		this.GAMEOPENING = gameopeningstate;
	}
	
	@Override
	public int getID() {
		return this.GAMEOPENING;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame stg) throws SlickException {
		this.reshandle = new ResourceHandling();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame stg, Graphics g) throws SlickException {
		ResourceHandling.OP_Background.draw(0, 0);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame stg, int delta) throws SlickException {
		Frame += delta;
		MouseX = gc.getInput().getMouseX();
		MouseY = gc.getInput().getMouseY();
		Frame = delta;
		if(anyKeyPressed || anyMouseKeyPressed) {
			stg.enterState(1, new FadeOutTransition(), new FadeInTransition());
		}
	}
	public void keyPressed(int key, char c){
		this.anyKeyPressed = true;
	}
	public void mousePressed(int key, int locx, int locy){
		this.anyMouseKeyPressed = true;
	}
}
