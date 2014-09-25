package oj;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;



public class Dust {

	private Image dustImg; //60*60
	private float x;
	private float y;
	private float speedFallDown = (float) 0.5;
	private Octopus octopusRef ;
	private float rangeFall;
	private Shape dustShapeRec;
	
	public Dust(float rangeFall) throws SlickException{
		this.rangeFall=rangeFall;
		randomPosDust(this.rangeFall);
		dustImg = new Image("res/Dust2.png");
		dustShapeRec = new Rectangle(this.x,this.y,60,60);
		octopusRef = new Octopus();
		
	}
	
	public void render(Graphics g){
		g.setColor(Color.transparent);
		g.draw(dustShapeRec);
		dustImg.draw(this.x,this.y);
		
	}
	
	public void update(){
		this.y+=speedFallDown;
		dustShapeRec.setLocation(this.x, this.y);
		OnCollider();
		
		
	}
	
	public void randomPosDust(float rangeFall){
		this.y=-1;
		Random rand = new Random();
		this.y -=rangeFall;
		this.x = rand.nextFloat()*800;
		
	}
	public void OnCollider(){
		
		if(this.dustShapeRec.intersects(octopusRef.OctoShapeRec))
		{
		   randomPosDust(this.rangeFall);
		}
	}
	
	
}
