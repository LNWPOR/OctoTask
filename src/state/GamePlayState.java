package state;

import gm.AudioGM;
import gm.GameController;
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
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

 public class GamePlayState extends BasicGameState{

	private Image blackground;
	//----------------------
	private Dust[] dusts;
	private int dustCount=5;
	//----------------------
	private Octopus octopusRef;
	private boolean octocacmove = false;
	//----------------------
	private Calculator calRef;
	//----------------------
	private Telephone phoneRef;
	private HP hpRef;
	private int maxHP=5;
	//----------------------
	public static int score =0;
	//----------------------
	private MyClock myClockRef;
	private int maxtimeIncreaseHP=15;
	private int timeIncreaseHP = maxtimeIncreaseHP;
	private int startTimeGame2=10;
	private int startTimeGame3=20;
	private int startTimeGame4=30;
	private int tutorTime = 5;
	//----------------------
	private Rat_White ratWhiteRef;
	private Rat_Black ratBlackRef;
	//----------------------
	private AtkRat atkRef;
	//----------------------
	private AudioGM audioRef;
	
	
	public GamePlayState() throws SlickException {
		blackground = new Image("res/bg.png");
		hpRef = new HP();
		HP.hp = maxHP;
		
	}
	
	
	
	@Override
	public void init(GameContainer c, StateBasedGame s)throws SlickException {
		audioRef = new AudioGM();
		
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
		
		g.setColor(Color.white);
		g.drawString("HP "+HP.hp, 100, 10);
		g.drawString("Time : " + myClockRef.getTime(), 150, 10);
		
		drawTutorial(g);
		
	}

	private void drawTutorial(Graphics g) {
		if(myClockRef.getTime()<tutorTime)
		{
			g.fillRect(250,80, 530,70);
			g.setColor(Color.red);
			g.drawString("Objective1: Answer the algorithm by 1 , 2 or 3 button",275, 100);
			g.setColor(Color.black);
			g.drawString("(HP will +1 every 15 sec if you survive :P)", 325, 120);
		}
		else if(myClockRef.getTime()>=startTimeGame2 && myClockRef.getTime()- startTimeGame2 < tutorTime)
		{
			g.fillRect(175,80, 770,50);
			g.setColor(Color.red);
			g.drawString("Objective2: Defend your house from rat by attacking them with left or right click",200, 100);
		}
		else if(myClockRef.getTime()>=startTimeGame3 && myClockRef.getTime()- startTimeGame3 < tutorTime)
		{
			g.fillRect(175,80, 740,50);
			g.setColor(Color.red);
			g.drawString("Objective3: Clean the falling dust by collecting them with A,D button to move",200, 100);
		}
		else if(myClockRef.getTime()>=startTimeGame4 && myClockRef.getTime()- startTimeGame4 < tutorTime)
		{
			g.fillRect(150,80, 720,50);
			g.setColor(Color.red);
			g.drawString("Objective4: Answer the telephone by matching the phone with SPACEBAR button",180, 100);
		}
	}

	private void renderGame(Graphics g) {
		renderGame1(g);
		if(myClockRef.getTime()>=startTimeGame2 )
		{
			renderGame2(g);
		}
		if(myClockRef.getTime()>=startTimeGame3 )
		{
			renderGame3(g);
		}
		if(myClockRef.getTime()>=startTimeGame4 )
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
		
		if(!audioRef.gamePlayAD.playing())
		{
			audioRef.gamePlayAD.loop();
		}
		
		checkTimeIncreaseHP();
		
		octopusRef.update(c);	
		updateGame(c,delta);	
		score = myClockRef.currentTime;
		checkHP(s,c);
		
	}

	private void checkTimeIncreaseHP() {
		timeIncreaseHP-=myClockRef.getOneSec();
		if(timeIncreaseHP<0)
		{
			hpRef.HpIncrease();
			timeIncreaseHP=maxtimeIncreaseHP;
		}
	
		myClockRef.currentTime = myClockRef.getTime();
	}

	private void updateGame(GameContainer c,int delta) {
		
		updateGame1(c,delta);
		if(myClockRef.getTime()>=startTimeGame2)
		{
			updateGame2(c,delta);
		
		}
		if(myClockRef.getTime()>=startTimeGame3 )
		{
			updateGame3(c);
			
		}
		if(myClockRef.getTime()>=startTimeGame4 )
		{
			updateGame4(c,delta);
			
		}
	}

	private void updateGame1(GameContainer c,int delta) {
		
		calRef.update(c,delta);
	}

	private void checkHP(StateBasedGame s,GameContainer c) throws SlickException {
		if(hpRef.hp ==0)
		{
			resetGamePlayScene();
			this.init(c, s);
			s.enterState(StateController.GameOver);
		
		}
	}

	private void resetGamePlayScene() {
		hpRef.hp=maxHP;
		myClockRef.time = 0;
	}

	
	private void updateGame2(GameContainer c,int delta) {
		
		ratWhiteRef.update(c);
		ratBlackRef.update(c);
		atkRef.update(c);
	}
	private void updateGame3(GameContainer c) {
		for (Dust dust :dusts) {
		    dust.update(c);
		    }
		if(!octocacmove)
		{	
			octopusRef.octoCanMove =true;
			octocacmove = true;
		}
	}
	private void updateGame4(GameContainer c,int delta) {
		phoneRef.update(c,delta);
	}

	
	

	
	@Override
	public int getID() {
		
		return StateController.GamePlay;
	}

	

}
