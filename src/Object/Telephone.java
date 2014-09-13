package Object;

import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import GM.GameController;

public class Telephone {

	private Octopus octopusRef;
	
	private Image smallPhoneImg1; //100*100
	private Image smallPhoneImg2; 
	private Image smallPhoneImg3; 
	private Image smallPhoneImg4;
	
	private Image bigPhoneImg1; //200*200
	private Image bigPhoneImg2;
	private Image bigPhoneImg3;
	private Image bigPhoneImg4;
	
	private int yourPhone=1;
	private int comingPhone;
	
	private float bx;
	private float by;
	private float sx;
	private float sy;
	Random rand = new Random();
	
	public Telephone() throws SlickException{
		smallPhoneImg1 = new Image("res/smallBlackPhone2.png");
		smallPhoneImg2 = new Image("res/smallGreenPhone2.png");
		smallPhoneImg3 = new Image("res/smallRedPhone2.png");
		smallPhoneImg4 = new Image("res/smallYellowPhone2.png");
		
		bigPhoneImg1 = new Image("res/bigBlackPhone.png");
		bigPhoneImg2 = new Image("res/bigGreenPhone.png");
		bigPhoneImg3 = new Image("res/bigRedPhone.png");
		bigPhoneImg4 = new Image("res/bigYellowPhone.png");
		
		octopusRef = new Octopus();
		
		this.bx = 0;
		this.by = GameController.gameHeight-220;
		this.sx = octopusRef.getX()+170;
		this.sy = octopusRef.getY()-50;
	}
	public void render( Graphics g){
		changePhone();
		smallPhoneImg1.draw(sx,sy);
	}
	private void changePhone() {
		if(yourPhone==1 )
		{
			bigPhoneImg1.draw(bx,by);
		}
		if(yourPhone==2)
		{
			bigPhoneImg2.draw(bx,by);
		}
		if(yourPhone==3)
		{
			bigPhoneImg3.draw(bx,by);
		}
		if(yourPhone==4)
		{
			bigPhoneImg4.draw(bx,by);
		}
	}
	public void update(GameContainer c){
		selectPhone(c);
		followOcto(c);
	}
	
	public void selectPhone(GameContainer c){

		if(c.getInput().isKeyPressed(Input.KEY_SPACE)){
			if(yourPhone ==4)
			{
				yourPhone=0;
			}
			yourPhone+=1;
			
		}
		
		
		
	}
	
	private void followOcto(GameContainer c) {
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
		if(this.sx!=180)
		this.sx-=1;
	}
	public void MoveRight(){
		if(this.sx!=GameController.gameWidth-30)
		this.sx+=1;
	}
	
	
	
}
