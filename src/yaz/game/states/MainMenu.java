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

public class MainMenu extends BasicGameState {
	
	ResourceHandling reshandle = null;
	protected int MAINMENU = 1;
	
	@SuppressWarnings("unused")
	private int MouseX, MouseY, Frame; 
	
	boolean IsInYAZ = false;
	boolean IsInPlay = false;
	boolean IsInLoad = false;
	boolean IsInOptions = false;
	boolean IsInCredits = false;
	boolean IsInQuit = false;
	boolean Button_Sound = false;
	boolean Clicked_Button_Sound = false;

	public MainMenu(int mainmenustate) {
		this.MAINMENU = mainmenustate;
	}
	
	@Override
	public int getID() {
		return this.MAINMENU;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame stg) throws SlickException {
		this.reshandle = new ResourceHandling();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame stg, Graphics g) throws SlickException {
		ResourceHandling.MMBackground_Final.draw(0, 0);
		if(IsInYAZ)
			ResourceHandling.MM_TextOverlay_YAZ.draw(8, 10);
		else
			ResourceHandling.MM_Text_YAZ.draw(8, 10);
		
		
		if(IsInPlay)
			ResourceHandling.MM_TextOverlay_Play.draw(120, 120);
		else
			ResourceHandling.MM_Text_Play.draw(120, 120);
		
		
		if(IsInLoad)
			ResourceHandling.MM_TextOverlay_LoadGame.draw(120, 200);
		else
			ResourceHandling.MM_Text_LoadGame.draw(120, 200);
		
		
		if(IsInOptions)
			ResourceHandling.MM_TextOverlay_Options.draw(120, 280);
		else
			ResourceHandling.MM_Text_Options.draw(120, 280);
		
		
		if(IsInCredits)
			ResourceHandling.MM_TextOverlay_Credits.draw(120, 360);
		else
			ResourceHandling.MM_Text_Credits.draw(120, 360);
		
		if(IsInQuit)
			ResourceHandling.MM_TextOverlay_Quit.draw(120, 440);
		else
			ResourceHandling.MM_Text_Quit.draw(120, 440);
		
		if(Clicked_Button_Sound)
			ResourceHandling.MM_ButtonOverlay_Sound.draw(400, 10);
		else
			ResourceHandling.MM_Button_Sound.draw(400, 10);

		if(yaz.DebugMode){
			g.drawString("Available  processors (cores): "+Runtime.getRuntime().availableProcessors(), 500, 440);
			g.drawString("Total Memory (bytes): "+Runtime.getRuntime().totalMemory(), 500, 460);
			g.drawString("Free Memory (bytes): "+Runtime.getRuntime().freeMemory(), 500, 480);
			g.drawString("Is In YAZ_TEXT: "+IsInYAZ, 500, 500);
			g.drawString("Is In PLAY_TEXT: "+IsInPlay, 500, 520);
			g.drawString("Is In LOAD_TEXT: "+IsInLoad, 500, 540);
			g.drawString("Is In OPTION_TEXT: "+IsInOptions, 500, 560);
			g.drawString("Is In CREDITS_TEXT: "+IsInCredits, 500, 580);
			g.drawString("Is In QUIT_TEXT: "+IsInQuit, 500, 600);
			g.drawString("Is In SONND_BUTTON: "+Button_Sound, 500, 620);
			g.drawString("Frames: "+gc.getFPS(), 500, 640);
			g.drawString("Music Volume: "+gc.getMusicVolume(), 500, 660);
			
		}
		
	}

	/*
	 * @param delta = frames
	 * Ugly I know, but it works efficiently :)
	 */
	@Override
	public void update(GameContainer gc, StateBasedGame stg, int delta) throws SlickException {
		Input i = gc.getInput();
		MouseX = i.getMouseX();
		MouseY = i.getMouseY();
		if((MouseX >= 8 && MouseX <= 8 + ResourceHandling.MM_Text_YAZ.getWidth()) && (MouseY >= 10 && MouseY <= 10 + ResourceHandling.MM_Text_YAZ.getHeight())) {
			IsInYAZ = true;
		}else{
			IsInYAZ = false;
		}
		
		if((MouseX >= 120 && MouseX <= 120 + ResourceHandling.MM_Text_Play.getWidth()) && (MouseY >= 120 && MouseY <= 120 + ResourceHandling.MM_Text_Play.getHeight())) {
			IsInPlay = true;
		}else{
			IsInPlay = false;
		}
		
		if((MouseX >= 120 && MouseX <= 120 + ResourceHandling.MM_Text_LoadGame.getWidth()) && (MouseY >= 200 && MouseY <= 200 + ResourceHandling.MM_Text_LoadGame.getHeight())) {
			IsInLoad = true;
		}else{
			IsInLoad = false;
		}
		
		if((MouseX >= 120 && MouseX <= 120 + ResourceHandling.MM_Text_Options.getWidth()) && (MouseY >= 280 && MouseY <= 280 + ResourceHandling.MM_Text_Options.getHeight())) {
			IsInOptions = true;
		}else{
			IsInOptions = false;
		}
		
		if((MouseX >= 120 && MouseX <= 120 + ResourceHandling.MM_Text_Credits.getWidth()) && (MouseY >= 360 && MouseY <= 360 + ResourceHandling.MM_Text_Credits.getHeight())) {
			IsInCredits = true;
		}else{
			IsInCredits = false;
		}
		
		if((MouseX >= 120 && MouseX <= 120 + ResourceHandling.MM_Text_Quit.getWidth()) && (MouseY >= 440 && MouseY <= 440 + ResourceHandling.MM_Text_Quit.getHeight())) {
			IsInQuit = true;
		}else{
			IsInQuit = false;
		}
		
		if((MouseX >= 400 && MouseX <= 400 + ResourceHandling.MM_Button_Sound.getWidth()) && (MouseY >= 10 && MouseY <= 10 + ResourceHandling.MM_Button_Sound.getHeight())) {
			Button_Sound = true;
		}else{
			Button_Sound = false;
		}
		
		if(i.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
			
			if(Button_Sound && ResourceHandling.MM_yaz.playing()){
				Clicked_Button_Sound = true;
				ResourceHandling.MM_yaz.stop();
			} else if(Button_Sound && !ResourceHandling.MM_yaz.playing()){
				Clicked_Button_Sound = false;
				ResourceHandling.MM_yaz.loop();
			}
			
			if(IsInYAZ){
				int Random_Sound_Choice = 1 + (int)(Math.random() * ((3 - 1) + 1));
				switch(Random_Sound_Choice){
					case 1:
						ResourceHandling.GAME_Zombie_Sound_1.play();
						break;
					case 2:
						ResourceHandling.GAME_Zombie_Sound_2.play();
						break;
					case 3:
						ResourceHandling.GAME_Zombie_Sound_3.play();
						break;
				}
			}
			
			if(IsInOptions){
				stg.enterState(4, new FadeOutTransition(), new FadeInTransition());
			}
			
			if(IsInQuit){
				gc.exit();
			}
			
			if(IsInCredits){
				stg.enterState(3, new FadeOutTransition(), new FadeInTransition());
			}
			
			if(IsInPlay){
				stg.enterState(2, new FadeOutTransition(), new FadeInTransition());
			}
		
		}
	}
}
