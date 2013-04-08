package yaz.game.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import yaz.game.handling.ResourceHandling;
import yaz.game.main.yaz;

public class GamePlay extends BasicGameState {


	ResourceHandling reshandle = null;

	Image GPBackground = null;	

	protected int GAMEPLAY = 2;
	
	private int MouseX, MouseY; 
	private int Current_Choice = 0;
	
	private boolean Arrow_Right = false;
	private boolean Arrow_Left = false;
	private boolean Select_Button = false;
	
	private boolean Clicked_Arrow_Right = false;
	private boolean Clicked_Arrow_Left = false;
	private boolean Clicked_Select_Button = false;
	
	boolean IsInBackButton = false;
	
	Rectangle Filler = new Rectangle(0, 0, 1366, 768);

	public GamePlay(int gameplaystate) {
		this.GAMEPLAY = gameplaystate;
	}

	/**
	 * Get method that gives the identifier.
	 * 
	 * @return integer identifier
	 */
	@Override
	public int getID() {
		return this.GAMEPLAY;
	}

	/**
	 * Initializes the resources for this state.
	 * 
	 * @param gc the GameContainer
	 * @param stg represents the game itself
	 * @throws SlickException general slick2d exception
	 */
	@Override
	public void init(GameContainer gc, StateBasedGame stg) throws SlickException {
		this.reshandle = new ResourceHandling();
	}

	/**
	 * Renders this state (currently nothing to render!).
	 * 
	 * @param gc the GameContainer
	 * @param stg represents the game itself
	 * @param g the graphics resources
	 * @throws SlickException general slick2d exception
	 */
	@Override
	public void render(GameContainer gc, StateBasedGame stg, Graphics g) throws SlickException {
		g.setColor(Color.lightGray);
		g.fill(Filler);
		switch(Current_Choice){
			case 0: 
				ResourceHandling.CHARACTER_ZEKE.draw(650, 300);
				break;
			case 1: 
				ResourceHandling.CHARACTER_OLGA.draw(650, 300);
				break;
			case 2: 
				ResourceHandling.CHARACTER_NATHAN.draw(650, 300);
				break;
			case 3: 
				ResourceHandling.CHARACTER_JEWEL.draw(650, 300);
				break;
			case 4: 
				ResourceHandling.CHARACTER_POPS.draw(650, 300);
				break;
			case 5: 
				ResourceHandling.CHARACTER_HARRIS.draw(650, 300);
				break;
		}
		if(Clicked_Arrow_Left){
			ResourceHandling.GAME_Arrow_Left_alt.draw(225, 550);
			Clicked_Arrow_Left = false;
		}else{
			ResourceHandling.GAME_Arrow_Left.draw(225, 550);
		}
		
		if(Clicked_Arrow_Right){
			ResourceHandling.GAME_Arrow_Right_Alt.draw(1025, 550);
			Clicked_Arrow_Right = false;
		}else{
			ResourceHandling.GAME_Arrow_Right.draw(1025, 550);
		}
		
		if(Clicked_Select_Button){
			ResourceHandling.GAME_Select_Button_Alt.draw(475, 550);
			Clicked_Select_Button = false;
		}else{
			ResourceHandling.GAME_Select_Button.draw(475, 550);
		}
		
		if(IsInBackButton){
			ResourceHandling.GAME_BackButton_Alt.draw(10, 650);
		}else{
			ResourceHandling.GAME_BackButton.draw(10, 650);
		}
		//Code goes here n' shit
	}

	/**
	 * Updates this state with any potential user input.
	 * 
	 * @param gc the GameContainer
	 * @param stg represents the game itself
	 * @param delta frames
	 * @throws SlickException general slick2d exception
	 */
	@Override
	public void update(GameContainer gc, StateBasedGame stg, int delta) throws SlickException {
		Input i = gc.getInput();
		MouseX = i.getMouseX();
		MouseY = i.getMouseY();
		if(i.isKeyPressed(Input.KEY_ENTER)) {
			stg.enterState(1);
		}
		
		Arrow_Left = ((MouseX >= 225 && MouseX <= 225 + ResourceHandling.GAME_Arrow_Left.getWidth()) 
				&& (MouseY >= 550 && MouseY <= 550 + ResourceHandling.GAME_Arrow_Left.getHeight()));
			
		
		Select_Button = ((MouseX >= 475 && MouseX <= 475 + ResourceHandling.GAME_Select_Button.getWidth()) 
				&& (MouseY >= 550 && MouseY <= 550 + ResourceHandling.GAME_Select_Button.getHeight()));
		
		Arrow_Right = ((MouseX >= 1025 && MouseX <= 1025 + ResourceHandling.GAME_Arrow_Right.getWidth()) 
				&& (MouseY >= 550 && MouseY <= 550 + ResourceHandling.GAME_Arrow_Right.getHeight()));
		
		IsInBackButton = ((MouseX >= 10 && MouseX <= 10 + ResourceHandling.GAME_BackButton.getWidth()) && 
				(MouseY >= 650 && MouseY <= 650 + ResourceHandling.GAME_BackButton.getHeight()));
		
		if(i.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
			
			if(Arrow_Left){
				Clicked_Arrow_Left = true;
				if(Current_Choice <= 5 && Current_Choice > 0){
					Current_Choice--;
					Clicked_Arrow_Left = false;
				}else{
					Current_Choice = 5;
				}
			}
			
			if(Select_Button){
				Clicked_Select_Button = true;
				if(yaz.Current_Choice == 0){
					stg.enterState(10, new FadeOutTransition(), new FadeInTransition());
				}
			}
			
			if(Arrow_Right){
				Clicked_Arrow_Right = true;
				if(Current_Choice < 5 && Current_Choice >= 0){
					Current_Choice++;
					Clicked_Arrow_Right = false;
				}else{
					Current_Choice = 0;
				}
			}
			
			if(IsInBackButton){
				stg.enterState(1, new FadeOutTransition(), new FadeInTransition());
			}
		}
	}

}
