package yaz.game.gameplay;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import it.randomtower.engine.ResourceManager;
import it.randomtower.engine.entity.Entity;

import yaz.game.handling.ResourceHandling;

@SuppressWarnings("unused")
public class YAZPlayer extends Entity {
	
	public static String PLAYER = "player"; 
	
	private Image Player;
	
	/* Code from marteEngine
	 * 
	 * @param x,y where the player starts.
	 */
	
	public YAZPlayer(float x, float y) {
		super(x, y);
		Player = ResourceHandling.PLAYABLE_CHARACTER_Zeke;
		setGraphic(Player);
		addType(PLAYER);
		setHitBox(x, y, Player.getWidth(), Player.getHeight());
		define("right", Input.KEY_RIGHT, Input.KEY_D);
		define("left", Input.KEY_LEFT, Input.KEY_A);
		
	}
	
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		if(this.check("right")){
			x += (0.4 * delta);
		}
		if(this.check("left")){
			x -= (0.4 * delta);
		}
		
	}
	
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		super.render(container, g);
		
	}
	
}
