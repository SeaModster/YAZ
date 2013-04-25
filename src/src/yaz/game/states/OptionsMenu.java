package yaz.game.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.VerticalSplitTransition;

import yaz.game.handling.ResourceHandling;
import yaz.game.handling.SaveGameFactory;
import yaz.game.main.yaz;

public class OptionsMenu extends BasicGameState {
	
	SaveGameFactory sgf;

	ResourceHandling reshandle = null;
	protected int OPTIONSMENU = 0;

	boolean IsInBackButton = false;
	boolean IsInChangelog = false;
	
	
	Rectangle Res = new Rectangle(48, 250, 275, 20);
	Rectangle Changelog = new Rectangle(48, 300, 275, 20);

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
		this.sgf = new SaveGameFactory();
		this.reshandle = new ResourceHandling();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame stg, Graphics g) throws SlickException {
		ResourceHandling.OPT_Background.draw(0, 0);
		g.drawString("Current Resolution: "+ yaz.ScreenWidth + ", " + yaz.ScreenHeight, 50, 250);
		g.draw(Res);
		g.drawString("Display Changelog?: "+ yaz.DisplayChangelog, 50, 300);
		g.draw(Changelog);
		ResourceHandling.GAME_BackButton.draw(10, 650);
		if(IsInBackButton)
			ResourceHandling.GAME_BackButton_Alt.draw(10, 650);
		else
			ResourceHandling.GAME_BackButton.draw(10, 650);
		
		if(yaz.DebugMode){
			g.drawString("Available  processors (cores): "+Runtime.getRuntime().availableProcessors(), 500, 240);
			g.drawString("Total Memory (bytes): "+Runtime.getRuntime().totalMemory(), 500, 260);
			g.drawString("Free Memory (bytes): "+Runtime.getRuntime().freeMemory(), 500, 280);
			g.drawString("Frames: "+gc.getFPS(), 500, 300);
			g.drawString("Is in back button: " + IsInBackButton, 500, 320);
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame stg, int delta) throws SlickException {
		Input i = gc.getInput();
		MouseX = i.getMouseX();
		MouseY = i.getMouseY();
		if(i.isKeyPressed(Input.KEY_ENTER) || IsInBackButton && i.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
			stg.enterState(1, null, new VerticalSplitTransition());
			
		}
		
		IsInBackButton = ((MouseX >= 10 && MouseX <= 10 + 
				ResourceHandling.GAME_BackButton.getWidth()) 
				&& (MouseY >= 650 && MouseY <= 650 + 
				ResourceHandling.GAME_BackButton.getHeight()));
		
		IsInChangelog = ((MouseX >= 48 && MouseX <= 48 + Changelog.getWidth()) 
				&& (MouseY >= 300 && MouseY <= 300 + Changelog.getHeight()));
		
		if(i.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
			if(IsInChangelog){
				if(yaz.DisplayChangelog){
			        yaz.DisplayChangelog = false;
				}else{
			        yaz.DisplayChangelog = true;
				}
			}
		}
		
	}
}
