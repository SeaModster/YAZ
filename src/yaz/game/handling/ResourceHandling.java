package yaz.game.handling;

import java.io.File;
import java.io.IOException;

import org.ini4j.InvalidFileFormatException;
import org.ini4j.Wini;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.loading.DeferredResource;
import org.newdawn.slick.loading.LoadingList;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import yaz.game.main.yaz;
import yaz.game.states.Credits;
import yaz.game.states.DebugMenu;
import yaz.game.states.GamePlay;
import yaz.game.states.MainMenu;
import yaz.game.states.Opening;
import yaz.game.states.OptionsMenu;

public class ResourceHandling extends BasicGameState {
	
	protected int INIT = 5;
	public static boolean IsLoaded = false;
	private DeferredResource nextResource;
	
	// Loading Screen Resource Loading //
	public SpriteSheet lo_sheet;
	public Animation loadingAnimation;
	public Image LO_Background = null;
	
	// Main Menu Resources //
	public static Image MMBackground_Final, MM_Text_YAZ, MM_Text_Play, MM_Text_Options, MM_Text_LoadGame, MM_Text_Credits, MM_Text_Quit, 
		MM_TextOverlay_YAZ, MM_TextOverlay_Play, MM_TextOverlay_Options, MM_TextOverlay_LoadGame, MM_TextOverlay_Credits, MM_TextOverlay_Quit,
		MM_Button_Sound, MM_ButtonOverlay_Sound = null;
	public static  Sound MM_yaz, GAME_Zombie_Sound_1, GAME_Zombie_Sound_2, GAME_Zombie_Sound_3;
	
	// Opening Resources //
	public static  Image OP_Background = null;
	
	// Credits Resources //
	public static  Image CRE_Background = null;
	
	// Options Resources loading //
	public static  Image OPT_Background = null;
	
	// GamePlay Resources //
	public static Image CHARACTER_ZEKE, CHARACTER_NATHAN, CHARACTER_OLGA, CHARACTER_POPS, CHARACTER_JEWEL, CHARACTER_HARRIS = null;
	public static Image PLAYABLE_CHARACTER_Zeke = null;
	public static Image GAME_Arrow_Left_alt,  GAME_Arrow_Right_Alt, GAME_Arrow_Left, GAME_Arrow_Right, GAME_Select_Button_Alt, GAME_Select_Button = null;
	
	// Overall Game Resources //
	public static Image GAME_BackButton, GAME_BackButton_Alt = null;
	
	// Level Resources //
	public static Image LEVEL_OBJECT_Backdrop, LEVEL_OBJECT_Floor = null;
	
	@SuppressWarnings("unused")
	private int MouseX, MouseY, Frame; 

	public ResourceHandling(int resourceshandling) {
		this.INIT = resourceshandling;
	}
	
	public ResourceHandling() {}

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
		lo_sheet = new SpriteSheet("res/SpriteSheet_Loading_Test.png", 169, 153);
		loadingAnimation = new Animation(lo_sheet, 500);
		LO_Background = new Image("res/LO_Background.png");
		// - Begin loading list - //
		LoadingList.setDeferredLoading(true);
		// Begin Resource Loading || Opening resource loading //
		OP_Background = new Image("res/OP_Background.png");
		// Main Menu Resource Loading //
		MMBackground_Final = new Image("res/MMBackground_Final.png");
		MM_Text_YAZ = new Image("res/MM_Text_YAZ.png");
		MM_Text_Play = new Image("res/MM_Text_Play.png");
		MM_Text_Options = new Image("res/MM_Text_Options.png");
		MM_Text_LoadGame = new Image("res/MM_Text_LoadGame.png");
		MM_Text_Credits = new Image("res/MM_Text_Credits.png");
		MM_Text_Quit = new Image("res/MM_Text_Quit.png");
		MM_TextOverlay_YAZ = new Image("res/MM_TextOverlay_YAZ.png");
		MM_TextOverlay_Play = new Image("res/MM_TextOverlay_Play.png");
		MM_TextOverlay_Options = new Image("res/MM_TextOverlay_Options.png");
		MM_TextOverlay_LoadGame = new Image("res/MM_TextOverlay_LoadGame.png");
		MM_TextOverlay_Credits = new Image("res/MM_TextOverlay_Credits.png");
		MM_TextOverlay_Quit = new Image("res/MM_TextOverlay_Quit.png");
		MM_Button_Sound = new Image("res/MM_Button_Sound.png");
		MM_ButtonOverlay_Sound = new Image("res/MM_ButtonOverlay_Sound.png");
		MM_yaz = new Sound("res/MM_yaz.ogg");
		// Credits Resource Loading //
		CRE_Background = new Image("res/CRE_Background.png");
		// Options Menu Resource Loading //
		OPT_Background = new Image("res/OPT_Background.png");
		// Overall Game Buttons/Image/Fonts/Sounds //
		GAME_BackButton = new Image("res/GAME_BackButton.png");
		GAME_BackButton_Alt = new Image("res/GAME_BackButton_Alt.png");
		GAME_Zombie_Sound_1 = new Sound("res/MM_ZombieSound_1.ogg");
		GAME_Zombie_Sound_2 = new Sound("res/MM_ZombieSound_2.ogg");
		GAME_Zombie_Sound_3 = new Sound("res/MM_ZombieSound_3.ogg");
		// Gameplay Resource Loading //
		CHARACTER_ZEKE = new Image("res/CHARACTER_Zeke.png");
		PLAYABLE_CHARACTER_Zeke = new Image("res/PLAYABLE_CHARACTER_Zeke.png");
		CHARACTER_NATHAN = new Image("res/CHARACTER_Nathan.png");
		CHARACTER_OLGA = new Image("res/CHARACTER_Olga.png");
		CHARACTER_POPS = new Image("res/CHARACTER_Pops.png");
		CHARACTER_JEWEL = new Image("res/CHARACTER_Jewel.png");
		CHARACTER_HARRIS = new Image("res/CHARACTER_Harris.png");
		GAME_Arrow_Left_alt = new Image("res/GAME_Arrow_Left_alt.png");
		GAME_Arrow_Right_Alt = new Image("res/GAME_Arrow_Right_Alt.png");
		GAME_Arrow_Left = new Image("res/GAME_Arrow_Left.png");
		GAME_Arrow_Right = new Image("res/GAME_Arrow_Right.png");
		GAME_Select_Button_Alt = new Image("res/GAME_Select_button_Alt.png");
		GAME_Select_Button = new Image("res/GAME_Select_button.png");
		// Level Data loading // 
		LEVEL_OBJECT_Backdrop = new Image("res/LEVEL_OBJECT_Backdrop.png");
		LEVEL_OBJECT_Floor = new Image("res/LEVEL_OBJECT_Floor.png");
		
	}

	/**
	 * Renders the resources for the handler.
	 * 
	 * @param gc the GameContainer
	 * @param stg represents the game itself
	 * @param g the graphics resources
	 * @throws SlickException general slick2d exception
	 */
	@Override
	public void render(GameContainer gc, StateBasedGame stg, Graphics g) throws SlickException {
		loadingAnimation.draw(585, 300);
		if(!IsLoaded){
            int total = LoadingList.get().getTotalResources();
            int loaded = LoadingList.get().getTotalResources() - LoadingList.get().getRemainingResources();
			g.drawString("Loading: "+loaded+" out of "+total, 575, 500);
		}else{
			loadingAnimation.stop();
			g.drawString("Loading Complete!", 600, 500);
		}
		if(yaz.DebugMode && IsLoaded){
			g.drawString("Loading Complete! DEBUG MODE", 600, 500);
		}
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
		Frame += delta;
		stg.addState(new Opening(yaz.OPENINGSTATE));
		stg.addState(new MainMenu(yaz.GAMEMENUSTATE));
		stg.addState(new GamePlay(yaz.GAMEPLAYSTATE));
		stg.addState(new Credits(yaz.CREDITSSTATE));
		stg.addState(new OptionsMenu(yaz.OPTIONSMENUSTATE));
		stg.addState(new DebugMenu(yaz.DEBUGMENUSTATE));
		if(!IsLoaded){
			if(nextResource != null){
				if(nextResource != null){
	                try {
	                	nextResource.load();
	                }catch(IOException e){
	                	throw new SlickException("Failed to load: "+nextResource.getDescription(), e);
	                }
	                nextResource = null;
				}
			}
			if(LoadingList.get().getRemainingResources() > 0){
	            nextResource = LoadingList.get().getNext();
			}else{
				IsLoaded = true;
			}
		}else if(gc.getInput().isKeyPressed(Input.KEY_ENTER)){
			stg.enterState(0, new FadeOutTransition(), new FadeInTransition());
			MM_yaz.loop();
		}else if(Frame/1000 == 3){
			stg.enterState(0, new FadeOutTransition(), new FadeInTransition());
			try {
				Wini ini = new Wini(new File("datastorage/YAZ.ini"));
				if(!ini.get("CORE", "Sound", boolean.class) == false){
					MM_yaz.loop();
				}
			}catch (InvalidFileFormatException e) {e.printStackTrace();}catch (IOException e){e.printStackTrace();}
		}
	}
}
