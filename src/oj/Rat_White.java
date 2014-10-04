package oj;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Rat_White extends Rat{

	public Rat_White() throws SlickException{
		
		super();
	}

	private void selectImgTomatchDirection() throws SlickException {
		
		if(startFromleft)
		{
			ratImg = new Image("res/rat_white_right.png");
			
		}
		if(startFromRight)
		{
			ratImg = new Image("res/rat_white_left.png");
		}
	}
	
	public void update(GameContainer c){
		
		try {
			selectImgTomatchDirection();
			
		} catch (SlickException e) {
		
			e.printStackTrace();
		}
		
		canPlayRatAD = true;
		ratMove();
		ratShapeRec.setLocation(x, y);
		checkCollision(c);
	}
}
