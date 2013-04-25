package yaz.game.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import yaz.game.handling.ResourceHandling;
import yaz.game.main.yaz;

public class DebugMenu extends BasicGameState {

	ResourceHandling reshandle = null;
	Rectangle Debug = new Rectangle(50, 420, 275, 20);
	protected int debugState = 6;
	
	public DebugMenu(int debugState){
		this.debugState = debugState;
	}
	
	@Override
	public int getID() {
		return debugState;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame stg) throws SlickException {
		reshandle = new ResourceHandling();
	}
	
	@Override
	public void render(GameContainer gc, StateBasedGame stg, Graphics g) throws SlickException {
		g.drawString("Available  processors (cores): "+Runtime.getRuntime().availableProcessors(), 100, 240);
		g.drawString("Total Memory (bytes): "+Runtime.getRuntime().totalMemory(), 100, 260);
		g.drawString("Free Memory (bytes): "+Runtime.getRuntime().freeMemory(), 100, 280);
		g.drawString("Frames: "+gc.getFPS(), 100, 300);
		g.drawString("Music Volume: "+gc.getMusicVolume(), 100, 320);
		g.drawString("Dubug Mode: "+yaz.DebugMode, 100, 420);
		g.draw(Debug);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame stg, int delta) throws SlickException {
		Input i = gc.getInput();
		
		if(i.isKeyPressed(Input.KEY_D)){
			stg.enterState(yaz.GAMEMENUSTATE);
		}
		
		if(i.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
			if(i.getMouseX() >= 50 && i.getMouseX() <= (50 + Debug.getWidth()) && i.getMouseY() >= 420 && i.getMouseY() <= (420 + Debug.getHeight())){
				yaz.DebugMode = !yaz.DebugMode;
			}
		}
	}

}
