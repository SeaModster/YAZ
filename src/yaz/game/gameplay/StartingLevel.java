package yaz.game.gameplay;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import it.randomtower.engine.World;

import yaz.game.handling.ResourceHandling;
import yaz.game.main.yaz;

public class StartingLevel extends World {

	YAZPlayer ply;
 
	
	
	/**
	 * @param id, unique identifier for World
	 * @param container, container for World
	 */
	
	Rectangle Test_Test_Test = new Rectangle(height, height, height, height);
	
	public StartingLevel(int id, GameContainer container) {
		super(id, container);
	}

	
	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		super.init(gc, game);
		ply = new YAZPlayer(getWidth() / 2, 655);
		add(ply);
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame stg, int delta) throws SlickException {
		super.update(gc, stg, delta);
	}
	
	@Override
	public void render(GameContainer gc, StateBasedGame stg, Graphics g) throws SlickException {
		super.render(gc, stg, g);
		ResourceHandling.LEVEL_OBJECT_Floor.draw(0, 757);
		if(yaz.GamePaused){
			ResourceHandling.GAME_GamePaused.draw(0, 0);
		}
	}
	
}
