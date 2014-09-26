package oj;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Rat_White extends Rat{

	public Rat_White() throws SlickException{
		super();
	
		selectImgTomatchDirection();
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
	
	
}
