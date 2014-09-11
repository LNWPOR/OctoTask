package Object;

import java.util.Random;


import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import State.Game2;

public class Dust implements Game2{

	private Image dust;
	private int x=10;//เป็นint เนื่องจากจะใช้ random
	private float y=-1;
	private float speedFallDown = (float) 0.5;
	
	public Dust(float y) throws SlickException{
		randomPosDust(y);
		dust = new Image("res/Dust.png");
	}
	
	public void render(){
		dust.draw(x,y);
	}
	public void update(){
		this.y+=speedFallDown;
	}
	public void randomPosDust(float y){
		Random rand = new Random();
		this.y -=y;
		this.x= rand.nextInt(900);
	}
}
