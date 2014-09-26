package oj;

import gm.GameController;

import java.util.Random;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Rat {

	
	protected float x;
	protected float y;
	protected float speed =1;
	protected Shape ratShapeRec;//160*80
	protected Image ratImg;

	
	protected boolean startFromleft = false;
	protected boolean startFromRight = false;
	
	Random rand = new Random();
	
	
	public Rat(){
	
		ratShapeRec = new Rectangle(this.x,this.y,160,80);
		randStartRatPos();
		
	}

	private void randStartRatPos() {
		
		y=GameController.gameHeight/2+140;
		if(rand.nextBoolean()){                  //start from left
			x = -10;	
			startFromleft = true;
		}else{
			x = GameController.gameWidth;     //start from right
			startFromRight = true;
		}
	
	}
	
	public void render(Graphics g){
		g.drawImage(ratImg, x, y);
	}
	public void update(){
		ratMove();
	}

	private void ratMove() {
		if(startFromleft)
		{
			 x+= speed;
		}
		if(startFromRight)
		{
			 x-= speed;
		}
	}
}
