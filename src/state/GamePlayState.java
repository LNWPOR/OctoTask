package state;

import oj.AtkRat;
import oj.Calculator;
import oj.Dust;
import oj.HP;
import oj.MyClock;
import oj.Octopus;
import oj.Rat_Black;
import oj.Rat_White;
import oj.Telephone;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

 public class GamePlayState extends BasicGameState{

	private Image blackground;
	//----------------------
	private Dust[] dusts;
	private int dustCount=50;
	//----------------------
	private Octopus octopusRef;
	//----------------------
	private Calculator calRef;
	//----------------------
	private Telephone phoneRef;
	private HP hpRef;
	//----------------------
	private MyClock myClockRef;
	//----------------------
	private Rat_White ratWhiteRef;
	private Rat_Black ratBlackRef;
	//----------------------
	private AtkRat atkRef;
	//----------------------
	public GamePlayState() throws SlickException {
		blackground = new Image("res/bg.png");
		hpRef = new HP();
	}
	
	@Override
	public void init(GameContainer c, StateBasedGame s)throws SlickException {
		octopusRef = new Octopus();
		myClockRef = new MyClock();
		initGame1();
		initGame2();
		initGame3();
		initGame4();
	}

	private void initGame1() throws SlickException {
		calRef = new Calculator();
	}
	private void initGame2() throws SlickException {
		ratWhiteRef = new Rat_White();
		ratBlackRef = new Rat_Black();
		atkRef = new AtkRat();
	}
	private void initGame3() throws SlickException {
		
		float rangeFall=500;
		dusts = new Dust[dustCount];
	   for(int i =0; i<dustCount;i++)
	   {
		  dusts [i] = new Dust(i*rangeFall);
	     
	    }
	}
	private void initGame4() throws SlickException {
		phoneRef = new Telephone();
	}


	@Override
	public void render(GameContainer c, StateBasedGame s, Graphics g)throws SlickException {
		
		blackground.draw(0,0);
		octopusRef.render(g);
		
		renderGame(g);
		
		g.setColor(Color.white);//UI จะได้มีสี
		g.drawString("HP "+HP.hp, 100, 10);
		g.drawString("Time : " + myClockRef.getTime(), 150, 10);
	}

	private void renderGame(Graphics g) {
		renderGame1(g);
		if(myClockRef.getTime()>=10 )
		{
			renderGame2(g);
		}
		if(myClockRef.getTime()>=20 )
		{
			renderGame3(g);
		}
		if(myClockRef.getTime()>=30 )
		{
			renderGame4(g);
		}
	}

	private void renderGame1(Graphics g) {
		
		calRef.render(g);
	}

	private void renderGame4( Graphics g) {
		phoneRef.render(g);
	}
	private void renderGame2( Graphics g) {
		
		ratWhiteRef.render(g);
		ratBlackRef.render(g);
		atkRef.render();
	}
	private void renderGame3(Graphics g) {
		for (Dust dust :dusts) {
		    dust.render(g);
		    }
	}

	@Override
	public void update(GameContainer c, StateBasedGame s, int delta)throws SlickException {
		myClockRef.update(delta);
		octopusRef.update(c);	
		updateGame(c,delta);	
		checkHP(s);
        
	}

	private void updateGame(GameContainer c,int delta) {
		
		updateGame1(c,delta);
		if(myClockRef.getTime()>=10)
		{
			updateGame2(c,delta);
		
		}
		if(myClockRef.getTime()>=20 )
		{
			updateGame3(c);
			
		}
		if(myClockRef.getTime()>=30 )
		{
			updateGame4(c);
			
		}
	}

	private void updateGame1(GameContainer c,int delta) {
		
		calRef.update(c,delta);
	}

	private void checkHP(StateBasedGame s) {
		if(hpRef.hp ==0)
		{
			resetGamePlayScene();
			s.enterState(StateController.Menu);
		}
	}

	private void resetGamePlayScene() {
		hpRef.hp=3;
		myClockRef.time = 0;
	}

	private void updateGame4(GameContainer c) {
		phoneRef.update(c);
	}
	private void updateGame2(GameContainer c,int delta) {
		
		ratWhiteRef.update(c);
		ratBlackRef.update(c);
		atkRef.update(c);
	}
	private void updateGame3(GameContainer c) {
		for (Dust dust :dusts) {
		    dust.update();
		    }
	}

	
	

	
	@Override
	public int getID() {
		
		return StateController.GamePlay;
	}

	

}
