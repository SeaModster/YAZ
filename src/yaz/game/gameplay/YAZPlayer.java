package yaz.game.gameplay;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

import it.randomtower.engine.ResourceManager;
import it.randomtower.engine.entity.Entity;

import yaz.game.handling.ResourceHandling;
import yaz.game.main.yaz;

@SuppressWarnings("unused")
public class YAZPlayer extends Entity {
	
	public static String PLAYER = "player"; 
		
	/*
	 * DO NOT rename this code!
	 * This is the camera for the game. Any alteration will require tons of renaming.
	 */
	public static Rectangle viewPort;
	public static float viewPortX;
	public static float viewPortY;
		
	/* Code from marteEngine
	 * 
	 * @param x,y where the player starts.
	 */
	
	public YAZPlayer(float x, float y) {
		super(x, y);
		setGraphic(ResourceHandling.CHARACTER_ZEKE);
		addType(PLAYER);
		define("right", Input.KEY_RIGHT, Input.KEY_D);
		define("left", Input.KEY_LEFT, Input.KEY_A);
		viewPort = new Rectangle(0, 0, width, height);
	}
	
	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		Vector2f trans = new Vector2f(0,0);
		if(this.check("right")){
			trans.x= 0.4f * delta;
		}
		if(this.check("left")){
			trans.x = -0.4f * delta;
		}
		if(gc.getInput().isKeyPressed(Input.KEY_P) || gc.getInput().isKeyPressed(Input.KEY_PAUSE)){
			if(yaz.GamePaused == true){
				yaz.GamePaused = false;
				gc.resume();
			}else{
				yaz.GamePaused = true;
				gc.pause();
			}
			
		}
		if(trans.x !=0 && trans.y != 0) {
			trans.set(trans.x/1.5f, trans.y/1.5f);
		}
		
		viewPort.setX(viewPort.getX()+trans.x);
		viewPort.setY(viewPort.getY()+trans.y);
		
		viewPortX = viewPort.getX();
		viewPortY = viewPort.getY();
	}
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		super.render(gc, g);
		g.translate(-viewPort.getX(), -viewPort.getY());
	}
	
}
