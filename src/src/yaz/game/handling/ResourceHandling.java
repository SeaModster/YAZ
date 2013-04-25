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
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.loading.DeferredResource;
import org.newdawn.slick.loading.LoadingList;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.BlobbyTransition;
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
		MM_Button_Sound, MM_ButtonOverlay_Sound, MM_Changelog = null;
	public static  Sound MM_yaz, GAME_Zombie_Sound_1, GAME_Zombie_Sound_2, GAME_Zombie_Sound_3;
	
	// Opening Resources //
	public static  Image OP_Background = null;
	
	// Credits Resources //
	public static  Image CRE_Background = null;
	
	// Options Resources loading //
	public static  Image OPT_Background = null;
	
	// GamePlay Resources //
	public static Image CHARACTER_ZEKE, CHARACTER_NATHAN, CHARACTER_OLGA, CHARACTER_POPS, CHARACTER_JEWEL, CHARACTER_HARRIS = null;
	public static Image BIO_ZEKE, BIO_NATHAN, BIO_OLGA, BIO_POPS, BIO_JEWEL, BIO_HARRIS = null;
	public static Image PLAYABLE_CHARACTER_Zeke_Right, PLAYABLE_CHARACTER_Zeke_Left = null;
	public static Image GAME_Arrow_Left_alt,  GAME_Arrow_Right_Alt, GAME_Arrow_Left, GAME_Arrow_Right, GAME_Select_Button_Alt, GAME_Select_Button, GAME_GamePaused = null;
	
	// Overall Game Resources //
	public static Image GAME_BackButton, GAME_BackButton_Alt = null;
	
	
	// Level Resources //
	public static Image LEVEL_OBJECT_Backdrop, LEVEL_OBJECT_Floor = null;
	public static UnicodeFont MGS_FONT;
	
	public static Image PROP_Crate, PROP_Crate_2, PROP_Crate_3, PROP_Crate_4 = null;
	
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
	@SuppressWarnings("unchecked")
	@Override
	public void init(GameContainer gc, StateBasedGame stg) throws SlickException {
		lo_sheet = new SpriteSheet("yaz/res/sprites/SpriteSheet_Loading.png", 180, 50);
		loadingAnimation = new Animation(lo_sheet, 15);
		LO_Background = new Image("yaz/res/loadingstate/LO_Background.png");
		// - Begin loading list - //
		LoadingList.setDeferredLoading(true);
		// Begin Resource Loading || Opening resource loading //
		OP_Background = new Image("yaz/res/openingstate/OP_Background.png");
		// Main Menu Resource Loading //
		MMBackground_Final = new Image("yaz/res/mainmenustate/MM_Background_Final.png");
		MM_Text_YAZ = new Image("yaz/res/mainmenustate/MM_Text_YAZ.png");
		MM_Text_Play = new Image("yaz/res/mainmenustate/MM_Text_Play.png");
		MM_Text_Options = new Image("yaz/res/mainmenustate/MM_Text_Options.png");
		MM_Text_LoadGame = new Image("yaz/res/mainmenustate/MM_Text_LoadGame.png");
		MM_Text_Credits = new Image("yaz/res/mainmenustate/MM_Text_Credits.png");
		MM_Text_Quit = new Image("yaz/res/mainmenustate/MM_Text_Quit.png");
		MM_TextOverlay_YAZ = new Image("yaz/res/mainmenustate/MM_TextOverlay_YAZ.png");
		MM_TextOverlay_Play = new Image("yaz/res/mainmenustate/MM_TextOverlay_Play.png");
		MM_TextOverlay_Options = new Image("yaz/res/mainmenustate/MM_TextOverlay_Options.png");
		MM_TextOverlay_LoadGame = new Image("yaz/res/mainmenustate/MM_TextOverlay_LoadGame.png");
		MM_TextOverlay_Credits = new Image("yaz/res/mainmenustate/MM_TextOverlay_Credits.png");
		MM_TextOverlay_Quit = new Image("yaz/res/mainmenustate/MM_TextOverlay_Quit.png");
		MM_Button_Sound = new Image("yaz/res/mainmenustate/MM_Button_Sound.png");
		MM_ButtonOverlay_Sound = new Image("yaz/res/mainmenustate/MM_ButtonOverlay_Sound.png");
		MM_yaz = new Sound("yaz/res/sound/MM_SilentPiano.wav");
		MM_Changelog = new Image("yaz/res/mainmenustate/MM_Changelog.png");
		// Credits Resource Loading //
		CRE_Background = new Image("yaz/res/creditsstate/CRE_Background.png");
		// Options Menu Resource Loading //
		OPT_Background = new Image("yaz/res/optionsstate/OPT_Background.png");
		// Overall Game Buttons/Image/Fonts/Sounds //
		GAME_BackButton = new Image("yaz/res/GAME_BackButton.png");
		GAME_BackButton_Alt = new Image("yaz/res/GAME_BackButton_Alt.png");
		GAME_Zombie_Sound_1 = new Sound("yaz/res/sound/MM_ZombieSound_1.ogg");
		GAME_Zombie_Sound_2 = new Sound("yaz/res/sound/MM_ZombieSound_2.ogg");
		GAME_Zombie_Sound_3 = new Sound("yaz/res/sound/MM_ZombieSound_3.ogg");
		// Gameplay Resource Loading //
		CHARACTER_ZEKE = new Image("yaz/res/characters/CHARACTER_Zeke.png");
		CHARACTER_NATHAN = new Image("yaz/res/characters/CHARACTER_Nathan.png");
		CHARACTER_OLGA = new Image("yaz/res/characters/CHARACTER_Olga.png");
		CHARACTER_POPS = new Image("yaz/res/characters/CHARACTER_Pops.png");
		CHARACTER_JEWEL = new Image("yaz/res/characters/CHARACTER_Jewel.png");
		CHARACTER_HARRIS = new Image("yaz/res/characters/CHARACTER_Harris.png");
		BIO_ZEKE = new Image("yaz/res/characters/bios/BIO_ZEKE.png");
		BIO_NATHAN = new Image("yaz/res/characters/bios/BIO_NATHAN.png");
		BIO_OLGA = new Image("yaz/res/characters/bios/BIO_OLGA.png");
		BIO_POPS = new Image("yaz/res/characters/bios/BIO_POPS.png");
		BIO_JEWEL = new Image("yaz/res/characters/bios/BIO_JEWEL.png");
		BIO_HARRIS = new Image("yaz/res/characters/bios/BIO_HARRIS.png");
		GAME_Arrow_Left_alt = new Image("yaz/res/characterselectstate/GAME_Arrow_Left_alt.png");
		GAME_Arrow_Right_Alt = new Image("yaz/res/characterselectstate/GAME_Arrow_Right_Alt.png");
		GAME_Arrow_Left = new Image("yaz/res/characterselectstate/GAME_Arrow_Left.png");
		GAME_Arrow_Right = new Image("yaz/res/characterselectstate/GAME_Arrow_Right.png");
		GAME_Select_Button_Alt = new Image("yaz/res/characterselectstate/GAME_Select_button_Alt.png");
		GAME_Select_Button = new Image("yaz/res/characterselectstate/GAME_Select_button.png");
		GAME_GamePaused = new Image("yaz/res/gameplaystate/GAME_GamePaused.png");
		// Level Data loading // 
		LEVEL_OBJECT_Floor = new Image("yaz/res/gameplaystate/GAME_PROP_Floor.png");
		// Prop Loading //
		PROP_Crate = new Image("yaz/res/gameplaystate/GAME_PROP_Crate.png");
		MGS_FONT = new UnicodeFont("yaz/res/fonts/MGS.ttf", 60, false, false);
		MGS_FONT.addAsciiGlyphs();
		MGS_FONT.getEffects().add(new ColorEffect());
		MGS_FONT.loadGlyphs();
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
		LO_Background.draw(0, 0);
		loadingAnimation.draw(450, 8);
		g.setFont(MGS_FONT);
		if(!IsLoaded){
			loadingAnimation.setLooping(true);
            int total = LoadingList.get().getTotalResources();
            int loaded = LoadingList.get().getTotalResources() - LoadingList.get().getRemainingResources();
			g.drawString("Loading: "+loaded+" out of "+total, 10, 18);
		}else{
			loadingAnimation.setLooping(false);
			loadingAnimation.setCurrentFrame(11);
			g.drawString("Loading Complete!", 10, 18);
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
			stg.enterState(0, null, new BlobbyTransition());
			MM_yaz.loop();
		} else {
			stg.enterState(0, null, new BlobbyTransition());
			try {
				Wini ini = new Wini(new File("yaz/datastorage/YAZ.ini"));
				if(!ini.get("CORE", "Sound", boolean.class) == false){
					MM_yaz.loop();
				}
			}catch (InvalidFileFormatException e) {e.printStackTrace();}catch (IOException e){e.printStackTrace();}
		}
	}
}
