package oj;

import gm.GameController;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

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
	//------------------------------
	private MyClock myClockRef;
	private int maxLimitComingPhoneTime = 10;
	private int limitComingPhoneTime = maxLimitComingPhoneTime;
	
	private int MaxtTimeForNextCall = 5;
	private int timeForNextCall = MaxtTimeForNextCall;
	//------------------------------
	private HP hpRef;
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
		myClockRef = new MyClock();
		
		this.bx = GameController.gameWidth-220;
		this.by = 0;
		this.sx = octopusRef.getX()+170;
		this.sy = octopusRef.getY()-50;
		
		randComingPhone();
		
		hpRef = new HP();
	}
	private void randComingPhone() {
		comingPhone=rand.nextInt(3)+1;
	}
	public void render( Graphics g){
		changePhone();
		changeComingPhone();
		g.setColor(Color.red);
		g.drawString(" "+limitComingPhoneTime, sx+100, sy);
	}
	private void changeComingPhone() {
		smallPhoneImg1.draw(sx,sy);
		if(comingPhone==1 )
		{
			smallPhoneImg1.draw(sx,sy);
		}
		if(comingPhone==2)
		{
			smallPhoneImg2.draw(sx,sy);
		}
		if(comingPhone==3)
		{
			smallPhoneImg3.draw(sx,sy);
		}
		if(comingPhone==4)
		{
			smallPhoneImg4.draw(sx,sy);
		}
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
	public void update(GameContainer c,int delta){
		checkLimitComingPhone(delta);
		selectPhone(c);
		this.sx = octopusRef.getX()+170;
		
	}
	private void checkLimitComingPhone(int delta) {
		myClockRef.update(delta);

		
		if(yourPhone!= comingPhone)
		{
			
			limitComingPhoneTime -= myClockRef.getOneSec();
			if(limitComingPhoneTime <0)
			{
				hpRef.HpDamage();
				limitComingPhoneTime =maxLimitComingPhoneTime;
				randComingPhone();
			}
		}else
		{
			timeForNextCall -= myClockRef.getOneSec();
			if(timeForNextCall <0)
			{
				randComingPhone();
				limitComingPhoneTime =maxLimitComingPhoneTime;
				timeForNextCall=MaxtTimeForNextCall;
			}
		}

		myClockRef.currentTime =myClockRef.getTime();
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
	
	
}
