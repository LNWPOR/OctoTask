package Object;

import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import GM.GameController;


public class Calculator {

	private Octopus octopusRef;
	private Image calBoxImg;//300*150
	private HP hpRef;
	private float x;
	private float y;
	private int num1;
	private int num2;
	private int num3;
	private int ansnum;
	private int ans1;
	private int ans2;
	private int ans3;
	Random rand = new Random();
	public Calculator() throws SlickException{
		octopusRef = new Octopus();
		calBoxImg = new Image("res/calBox.png");
		hpRef = new HP();
		this.x=octopusRef.returnX()-50;
		this.y=octopusRef.returnY()-200;
		
		startCal(rand);
	}
	private void startCal(Random rand) {
		num1=rand.nextInt(30);
		num2=rand.nextInt(30);
		num3=num1+num2;
		ansnum=rand.nextInt(3)+1;
		System.out.println(ansnum);
		if(ansnum ==1)
		{
			ans1 = num3;
			ans2 = num3+rand.nextInt(10)+1;
		    ans3 = num3+rand.nextInt(10)+1;
		}
		else if(ansnum ==2)
		{
			ans1 = num3+rand.nextInt(10)+1;
			ans2 = num3;
		    ans3 = num3+rand.nextInt(10)+1;
		}
		else if(ansnum ==3)
		{
			ans1 = num3+rand.nextInt(10)+1;
			ans2 = num3+rand.nextInt(10)+1;
		    ans3 = num3;
		}
	}
	public void render(Graphics g)
	{
	
		calBoxImg.draw(this.x,this.y);
		g.drawString(num1+"+"+num2+"=?", this.x+120, this.y+50);
		g.drawString("1."+ans1+"  2."+ans2+"  3."+ans3,this.x+80, this.y+80);
	}

	public void update(GameContainer c) {
	
		yourAns(c);
		followOcto(c);
		
	}
	private void yourAns(GameContainer c) {
		if(ansnum==1)
		{
		if(c.getInput().isKeyPressed(Input.KEY_1))
		{
			startCal(rand);
		}else if(c.getInput().isKeyPressed(Input.KEY_2)||c.getInput().isKeyPressed(Input.KEY_3))
			{
			hpRef.HpDamage();
			}
		}
		
		if(ansnum==2)
		{
		if(c.getInput().isKeyPressed(Input.KEY_2))
		{
			startCal(rand);
		}else if(c.getInput().isKeyPressed(Input.KEY_1)||c.getInput().isKeyPressed(Input.KEY_3))
			{
			hpRef.HpDamage();
			}
		}
		
		if(ansnum==3)
		{
		if(c.getInput().isKeyPressed(Input.KEY_3))
		{
			startCal(rand);
		}else if(c.getInput().isKeyPressed(Input.KEY_1)||c.getInput().isKeyPressed(Input.KEY_2))
			{
			hpRef.HpDamage();
			}
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
		if(this.x!=0)
		this.x-=1;
	}
	public void MoveRight(){
		if(this.x!=GameController.gameWidth-200)
		this.x+=1;
	}
	
	
	
	
}
