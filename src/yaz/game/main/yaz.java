package yaz.game.main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import yaz.game.handling.ResourceHandling;

public class yaz extends StateBasedGame {

	public static final int OPENINGSTATE = 0;
	public static final int	GAMEMENUSTATE = 1;
	public static final int GAMEPLAYSTATE = 2;
	public static final int CREDITSSTATE = 3;
	public static final int OPTIONSMENUSTATE = 4;
	public static final int INITRESOURCEMANAGER = 5;
	public static int ScreenWidth = 1366;
	public static int ScreenHeight = 768;

	public yaz(){
		super("You're a Zombie!");
	}
	
	/*
	 * @initStateList
	 * Called on when the application is created in the main method below it.
	 */
	
	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.addState(new ResourceHandling(INITRESOURCEMANAGER));
		gc.setIcons(new String[] {"res/Game_Icon_16.png", "res/Game_Icon_32.png"});		
		gc.setTargetFrameRate(60);
		gc.setShowFPS(false);
		gc.setVSync(true);
		this.enterState(INITRESOURCEMANAGER);
	}

	public static void main(String args[]) throws SlickException {
		AppGameContainer app = new AppGameContainer(new yaz());
		app.setDisplayMode(ScreenWidth, ScreenHeight, false);
		app.start();
	}
}
