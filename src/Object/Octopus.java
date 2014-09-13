package Object;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import GM.GameController;

public class Octopus {

	private Image octopusImg; //200*200
	private float x  =GameController.gameWidth/2-100 ;
	private float y  =GameController.gameHeight/2+20;
	public Shape OctoShapeRec;
	
	

	public Octopus() throws SlickException{
		octopusImg =  new Image("res/Octopus2.png");
		OctoShapeRec  = new Rectangle(this.x,this.y,200,200);
	}
	
	public void render(Graphics g){

		g.draw(OctoShapeRec);
		octopusImg.draw(x ,y);
		
	}

	public void update(GameContainer c){
		OctoShapeRec.setLocation(x, y);
		OctoMoveSet2(c);
		
	}
	
	public void OctoMoveSet2(GameContainer c){
		if(c.getInput().isKeyDown(Input.KEY_A))
		{
			MoveLeft();
		}
		if(c.getInput().isKeyDown(Input.KEY_D))
		{
			MoveRight();
		}
	}
	public void MoveLeft(){
		if(this.x!=0)
		this.x-=1;
	}
	public void MoveRight(){
		if(this.x!=GameController.gameWidth-200)
		this.x+=1;
	}
	public float returnX(){
		return this.x;
}
	public float returnY(){
		return this.y;
}
}
