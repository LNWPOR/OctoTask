package Object;

import java.util.Random;





import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import State.Game2;

public class Dust implements Game2{

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
		drawCollider(g);
		dustImg.draw(this.x,this.y);
	}

	private void drawCollider(Graphics g) {
		g.draw(dustShapeRec);
		dustShapeRec.setLocation(this.x, this.y);
	}
	public void update(){
		this.y+=speedFallDown;
		
		
		
		
	}
	public void randomPosDust(float rangeFall){
		this.y=-1;
		Random rand = new Random();
		this.y -=rangeFall;
		this.x= rand.nextFloat()*800;
	}
	public boolean isCollide(){
	
		return false;
		
	}
	
	
}
