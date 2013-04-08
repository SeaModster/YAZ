package yaz.game.handling;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.Drawable;
import org.lwjgl.opengl.SharedDrawable;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.PackedSpriteSheet;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.loading.LoadingList;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import yaz.game.main.yaz;
import yaz.game.states.Credits;
import yaz.game.states.GamePlay;
import yaz.game.states.MainMenu;
import yaz.game.states.Opening;

public class ResourceHandling extends BasicGameState {

	PackedSpriteSheet lo_sheet;
	protected int INIT = 4;
	
	@SuppressWarnings("unused")
	private int MouseX, MouseY, Frame; 

	public ResourceHandling(int resourceshandling) {
		this.INIT = resourceshandling;
	}
	
	@Override
	public int getID() {
		return this.INIT;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame stg) throws SlickException {
		lo_sheet = new PackedSpriteSheet("res/SpriteSheet_Loading.def");
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame stg, Graphics g) throws SlickException {
		
	}

	@SuppressWarnings("static-access")
	@Override
	public void update(GameContainer gc, StateBasedGame stg, int delta) throws SlickException {
		yaz y = new yaz();
		stg.addState(new Opening(y.OPENINGSTATE));
		stg.addState(new MainMenu(y.GAMEMENUSTATE));
		stg.addState(new GamePlay(y.GAMEPLAYSTATE));
		stg.addState(new Credits(y.CREDITSSTATE));
	}
	
}