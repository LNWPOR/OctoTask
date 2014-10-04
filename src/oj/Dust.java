package oj;

import gm.AudioGM;
import gm.GameController;

import java.util.Random;





import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;



public class Dust {

	private Image dustImg; //60*60
	private float x;
	private float y;
	private float speedFallDown = (float) 0.3;
	private Octopus octopusRef ;
	private float rangeFall;
	private Shape dustShapeRec;
	private HP hpRef;
	private AudioGM audioRef;
	private boolean canPlayDustAD = false;
	
	public Dust(float rangeFall) throws SlickException{
		
		audioRef = new AudioGM();
		this.rangeFall=rangeFall;
		randomPosDust(this.rangeFall);
		dustImg = new Image("res/Dust2.png");
		dustShapeRec = new Rectangle(this.x,this.y,60,60);
		octopusRef = new Octopus();
		hpRef = new HP();
	}
	
	public void render(Graphics g){
	
		dustImg.draw(this.x,this.y);
		
	}
	
	public void update(GameContainer c){
		
		this.y+=speedFallDown;
		dustImg.rotate(-1);
		dustShapeRec.setLocation(this.x, this.y);
		OnCollider();
		canPlayDustAD = true;
	}
	
	public void randomPosDust(float rangeFall){
		
		this.y=-1;
		Random rand = new Random();
		this.y -=rangeFall;
		this.x = rand.nextFloat()*800;
		if(canPlayDustAD)
		{
			audioRef.dustAD.play();
		}
	}
	
	public void OnCollider(){
		
		if(this.dustShapeRec.intersects(octopusRef.octoShapeRec))
		{
		   randomPosDust(this.rangeFall);
		}
		if(this.y == GameController.gameHeight)
		{
			hpRef.HpDamage();
			randomPosDust(this.rangeFall);
		}
	}
	
	
}
