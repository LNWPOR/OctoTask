package Object;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import GM.GameController;

public class Octopus {

	private Image octopus; //200*200
	private float x=GameController.gameWidth/2-100 ;
	private float y=GameController.gameHeight/2+50;
	public Octopus() throws SlickException{
		octopus =  new Image("res/Octopus2.png");
	}
	
	public void render(){
		octopus.draw(x ,y);
	}
	public void update(){
		

	}
	public void MoveLeft(){
		if(this.x!=0)
		this.x-=1;
	}
	public void MoveRight(){
		if(this.x!=GameController.gameWidth-200)
		this.x+=1;
	}
}
