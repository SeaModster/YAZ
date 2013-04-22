package yaz.game.main;

import it.randomtower.engine.ResourceManager;

import java.io.IOException;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import yaz.game.gameplay.StartingLevel;
import yaz.game.handling.SaveGameFactory;
import yaz.game.handling.ResourceHandling;



/**
 * The main class where all the magic happens and begins.
 * 
 * @author Brad Westley, Tyler Crowe
 */
public class yaz extends StateBasedGame {

	Rectangle viewPort;
	
	SaveGameFactory sgf;
	
	// Game Info //
	
	public static final String version = "N: You're a Zombie - V: B1.0";
	public static final String authors = "PROG: Tyler Crowe and Brad Westley - Art: Kyle Munroe";
	
	public static final int OPENINGSTATE = 0;
	public static final int	GAMEMENUSTATE = 1;
	public static final int GAMEPLAYSTATE = 2;
	public static final int CREDITSSTATE = 3;
	public static final int OPTIONSMENUSTATE = 4;
	public static final int INITRESOURCEMANAGER = 5;
	public static final int DEBUGMENUSTATE = 6;
	public static final int STARTINGLEVELSTATE = 10;
	
	public static int ScreenWidth = 1366;
	public static int ScreenHeight = 768;
	
	public static boolean DebugMode = false;
	public static boolean DisplayChangelog = true;
	public static boolean GamePaused = false;
	
	public static int Current_Choice = 0;

	public yaz(){
		super("You're a Zombie!");
	}
	
	/**
	 * Initializes the states that are prepared by the resource handler.
	 * 
	 * @param gc the GameContainer
	 */
	
	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		sgf = new SaveGameFactory();
		addState(new ResourceHandling(INITRESOURCEMANAGER));
		addState(new StartingLevel(STARTINGLEVELSTATE, gc));
		try { sgf.CreateINI("yaz/datastorage/YAZ.ini"); sgf.SetValue("{LOAD-DATA}", "test", true, "save_1"); } catch (IOException e) { e.printStackTrace(); }
		gc.setIcons(new String[] {"yaz/res/Game_Icon_16.png", "yaz/res/Game_Icon_32.png"});
		gc.setTargetFrameRate(60); gc.setShowFPS(false); gc.setVSync(true);
		enterState(INITRESOURCEMANAGER);
	}

	public static void main(String args[]) throws SlickException {
		System.out.println("[GAME INFO] - START");
		System.out.println("[GAME INFO] - "+ version);
		System.out.println("[GAME INFO] - "+ authors);
		System.out.println("[GAME INFO] - END");
		AppGameContainer app = new AppGameContainer(new yaz());
		app.setDisplayMode(ScreenWidth, ScreenHeight, false);
		app.start();
	}
}
