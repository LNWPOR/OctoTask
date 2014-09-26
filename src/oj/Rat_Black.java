package oj;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Rat_Black extends Rat{
	public Rat_Black() throws SlickException{
		super();
	
		selectImgTomatchDirection();
	}

	private void selectImgTomatchDirection() throws SlickException {
		
		if(startFromleft)
		{
			ratImg = new Image("res/rat_black_right.png");
			
		}
		if(startFromRight)
		{
			ratImg = new Image("res/rat_black_left.png");
		}
	}
	
}
