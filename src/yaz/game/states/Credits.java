package yaz.game.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import yaz.game.handling.ResourceHandling;
import yaz.game.main.yaz;

public class Credits extends BasicGameState {
	
	ResourceHandling reshandle = null;
	protected int CREDITS = 3;
	
	boolean IsInBackButton = false;
	
	@SuppressWarnings("unused")
	private int MouseX, MouseY, Frame; 

	public Credits(int gameopeningstate) {
		this.CREDITS = gameopeningstate;
	}
	
	@Override
	public int getID() {
		return this.CREDITS;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame stg) throws SlickException {
		this.reshandle = new ResourceHandling();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame stg, Graphics g) throws SlickException {
		ResourceHandling.CRE_Background.draw(0, 0);
		if(IsInBackButton)
			ResourceHandling.GAME_BackButton_Alt.draw(10, 650);
		else
			ResourceHandling.GAME_BackButton.draw(10, 650);
		
		if(yaz.DebugMode){
			g.drawString("Available  processors (cores): "+Runtime.getRuntime().availableProcessors(), 500, 300);
			g.drawString("Total Memory (bytes): "+Runtime.getRuntime().totalMemory(), 500, 320);
			g.drawString("Free Memory (bytes): "+Runtime.getRuntime().freeMemory(), 500, 340);
			g.drawString("Frames: "+gc.getFPS(), 500, 360);
			g.drawString("Is in back button: " + IsInBackButton, 500, 380);
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame stg, int delta) throws SlickException {
		Input i = gc.getInput();
		MouseX = gc.getInput().getMouseX();
		MouseY = gc.getInput().getMouseY();
		Frame = delta;
		if(i.isKeyPressed(Input.KEY_ENTER) || IsInBackButton && i.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
			stg.enterState(1, new FadeOutTransition(), new FadeInTransition());
		}
		
		IsInBackButton = ((MouseX >= 10 && MouseX <= 10 + 
				ResourceHandling.GAME_BackButton.getWidth()) 
				&& (MouseY >= 650 && MouseY <= 650 + 
				ResourceHandling.GAME_BackButton.getHeight()));
	}
}
