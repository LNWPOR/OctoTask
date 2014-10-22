package state;

import gm.AudioGM;
import gm.GameController;
import gm.WritingRanking;
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

public class GamePlayState extends BasicGameState {

	private Image blackground;

	private Dust[] dusts;
	private int dustCount = 5;

	private Octopus octopusRef;

	private Calculator calRef;

	private Telephone phoneRef;
	private HP hpRef;
	private int maxHP = 5;
	private Image heart;
	private boolean getDamage = false;
	private int maxDamageDelay=4;
	private int damageDelay = maxDamageDelay;
	private boolean getHealth = false;
	private int maxHealthDelay=4;
	private int healthDelay = maxHealthDelay;
	
	
	
	public static int score = 0;

	private MyClock myClockRef;
	private int maxtimeIncreaseHP = 15;
	private int timeIncreaseHP = maxtimeIncreaseHP;
	private int startTimeGame2 = 10;
	private int startTimeGame3 = 20;
	private int startTimeGame4 = 30;
	private int tutorTime = 5;

	private Rat_White ratWhiteRef;
	private Rat_Black ratBlackRef;

	private AtkRat atkRef;
	private AudioGM audioRef;
	
	private int[] timeLv = {45,60,75};//Lv2,3,4
	private boolean[] checkLv = {true,true,true};
	private int showLvTime = 3;

	public GamePlayState() throws SlickException {

		blackground = new Image("res/bg.png");
		heart = new Image("res/heart.png");
		hpRef = new HP();
		HP.hp = maxHP;
		audioRef = new AudioGM();

	}

	@Override
	public void init(GameContainer c, StateBasedGame s) throws SlickException {
		setupLv();
		octopusRef = new Octopus();
		myClockRef = new MyClock();
		initGame1();
		initGame2();
		initGame3();
		initGame4();
	}

	private void setupLv() {
	
		for(int i = 0 ;i<3;i++)
		{
			checkLv[i]=true;
		}
		
		getDamage=false;
		getHealth=false;
		damageDelay=maxDamageDelay;
		healthDelay=maxHealthDelay;
	
		hpRef.hp = maxHP;
		timeIncreaseHP = maxtimeIncreaseHP;
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

		float rangeFall = 500;
		dusts = new Dust[dustCount];
		for (int i = 0; i < dustCount; i++) {
			dusts[i] = new Dust(i * rangeFall);
		}
	}

	private void initGame4() throws SlickException {

		phoneRef = new Telephone();
	}

	@Override
	public void render(GameContainer c, StateBasedGame s, Graphics g)
			throws SlickException {

		blackground.draw(0, 0);
		renderGetHealthSP();
		renderGetDamageSP();
		
		octopusRef.render(g);
		renderHeart();
		
		renderGame(g);

		g.setColor(Color.white);
		g.drawString("HP " + HP.hp, 100, 10);
		g.drawString("Time : " + myClockRef.getTime(), 150, 10);
		drawTutorial(g);
		
		renderLvChange(g);
		
	}

	private void renderLvChange(Graphics g) {
		if (myClockRef.getTime() > timeLv[0] && myClockRef.getTime()<= timeLv[0]+showLvTime) {
			renderLv2Text(g);
		}
		else if (myClockRef.getTime() > timeLv[1]&&myClockRef.getTime() <= timeLv[1]+showLvTime)
		{
			renderLv3Text(g);
		}
		else if (myClockRef.getTime() > timeLv[2]&&myClockRef.getTime() <= timeLv[2]+showLvTime)
		{
			renderLv4Text(g);
		}
	}

	private void renderLv4Text(Graphics g) {
		g.fillRect(GameController.gameWidth / 2 - 90, GameController.gameHeight / 2 -265,175,55 );
		g.setColor(Color.red);
		g.drawString("Lv "+4,GameController.gameWidth / 2 - 25, GameController.gameHeight / 2 -245);
	}

	private void renderLv3Text(Graphics g) {
		g.fillRect(GameController.gameWidth / 2 - 90, GameController.gameHeight / 2 -265,175,55 );
		g.setColor(Color.red);
		g.drawString("Lv "+3,GameController.gameWidth / 2 - 25, GameController.gameHeight / 2 -245);
	}

	private void renderLv2Text(Graphics g) {
		g.fillRect(GameController.gameWidth / 2 - 90, GameController.gameHeight / 2 -265,175,55 );
		g.setColor(Color.red);
		g.drawString("Lv "+2, GameController.gameWidth / 2 - 25, GameController.gameHeight / 2 -245);
	}

	private void renderGetDamageSP() {
		if(getDamage&&damageDelay>0)
		{
			hpRef.renderDamage();
		}
	}
	private void renderGetHealthSP() {
		if(getHealth&&healthDelay>0)
		{
			hpRef.renderHealth();
		}
	}

	private void renderHeart() {

		for (int i = 0; i < hpRef.hp; i++) {
			heart.draw(50 + 50 * i, 50);
		}
	}

	private void drawTutorial(Graphics g) {

		if (myClockRef.getTime() < tutorTime) {
			tutor1(g);
		} else if (myClockRef.getTime() >= startTimeGame2
				&& myClockRef.getTime() - startTimeGame2 < tutorTime) {
			tutor2(g);
		} else if (myClockRef.getTime() >= startTimeGame3
				&& myClockRef.getTime() - startTimeGame3 < tutorTime) {
			tutor3(g);
		} else if (myClockRef.getTime() >= startTimeGame4
				&& myClockRef.getTime() - startTimeGame4 < tutorTime) {
			tutor4(g);
		}
	}

	private void tutor4(Graphics g) {

		g.fillRect(150, 80, 720, 50);
		g.setColor(Color.red);
		g.drawString(
				"Objective4: Answer the telephone by matching the phone with SPACEBAR button",
				180, 100);
	}

	private void tutor3(Graphics g) {

		g.fillRect(175, 80, 740, 50);
		g.setColor(Color.red);
		g.drawString(
				"Objective3: Clean the falling dust by collecting them with A,D button to move",
				200, 100);
	}

	private void tutor2(Graphics g) {

		g.fillRect(175, 80, 770, 50);
		g.setColor(Color.red);
		g.drawString(
				"Objective2: Defend your house from rat by attacking them with left or right click",
				200, 100);
	}

	private void tutor1(Graphics g) {

		g.fillRect(250, 80, 530, 70);
		g.setColor(Color.red);
		g.drawString("Objective1: Answer the algorithm by 1 , 2 or 3 button",
				275, 100);
		g.setColor(Color.black);
		g.drawString("(HP will +1 every 15 sec if you survive :P)", 325, 120);
	}

	private void renderGame(Graphics g) {

		renderGame1(g);
		if (myClockRef.getTime() >= startTimeGame2) {
			renderGame2(g);
		}
		if (myClockRef.getTime() >= startTimeGame3) {
			renderGame3(g);
		}
		if (myClockRef.getTime() >= startTimeGame4) {
			renderGame4(g);
		}
	}

	private void renderGame1(Graphics g) {

		calRef.render(g);
	}

	private void renderGame4(Graphics g) {

		phoneRef.render(g);
	}

	private void renderGame2(Graphics g) {

		ratWhiteRef.render(g);
		ratBlackRef.render(g);
		atkRef.render();
	}

	private void renderGame3(Graphics g) {

		for (Dust dust : dusts) {
			dust.render(g);
		}
	}

	@Override
	public void update(GameContainer c, StateBasedGame s, int delta)
			throws SlickException {
		
		myClockRef.update(delta);
		
		checkHpToDrawSP();
		
		playGamePlayStateAD();

		checkTimeIncreaseHP();

		lvChanger();
		
		
		octopusRef.update(c);
		updateGame(c, delta);
		score = myClockRef.currentTime;
		
		checkHP(s, c);
	}

	private void lvChanger() {
		for(int i=0;i<3;i++)
		{
			if(myClockRef.getTime() ==timeLv[i] && checkLv[i] )
			{
				calRef.maxCalTime -= 1;
				ratBlackRef.speed *= 1.25;
				ratWhiteRef.speed *= 1.25;
				for(int j =0;j<dustCount;j++)
				{
					dusts[j].speedFallDown *=1.25;
				}
				phoneRef.maxLimitComingPhoneTime -=2;
				phoneRef.MaxtTimeForNextCall -=1;
				checkLv[i]=false;
			}
		}
	}

	private void checkHpToDrawSP() {
		getDamageSP();
		getHealthSP();
		hpRef.currentHp = hpRef.hp;
	}

	private void getDamageSP() {
		if(hpRef.hp<hpRef.currentHp)
		{
			getDamage=true;
		}
		
		damageDelay-=myClockRef.getOneSec();
		if(damageDelay==0){
			getDamage = false;
			damageDelay=maxDamageDelay;
		}
	}
	private void getHealthSP(){
		if(hpRef.hp>hpRef.currentHp)
		{
			getHealth=true;
		}
		
		healthDelay-=myClockRef.getOneSec();
		if(healthDelay==0){
			getHealth = false;
			healthDelay=maxHealthDelay;
		}
	}
	

	private void playGamePlayStateAD() {

		if (!audioRef.gamePlayAD.playing()) {
			audioRef.gamePlayAD.loop();
		}
	}

	private void checkTimeIncreaseHP() {

		timeIncreaseHP -= myClockRef.getOneSec();
		if (timeIncreaseHP < 0) {
			hpRef.HpIncrease();
			timeIncreaseHP = maxtimeIncreaseHP;
		}

		myClockRef.currentTime = myClockRef.getTime();
	}

	private void updateGame(GameContainer c, int delta) {

		updateGame1(c, delta);
		if (myClockRef.getTime() >= startTimeGame2) {
			updateGame2(c, delta);

		}
		if (myClockRef.getTime() >= startTimeGame3) {
			updateGame3(c);

		}
		if (myClockRef.getTime() >= startTimeGame4) {
			updateGame4(c, delta);

		}
	}

	private void updateGame1(GameContainer c, int delta) {

			calRef.update(c, delta);
	}

	private void checkHP(StateBasedGame s, GameContainer c)
			throws SlickException {

		if (hpRef.hp == 0) {
		
			WritingRanking.scoreToWrite = this.score;
			this.init(c, s);
			s.enterState(StateController.GAMEOVER);

		}
	}

	private void updateGame2(GameContainer c, int delta) {
		ratWhiteRef.update(c);
		ratBlackRef.update(c);
		atkRef.update(c);
	}

	private void updateGame3(GameContainer c) {

		for (Dust dust : dusts) {
			dust.update(c);
		}
		if (!octopusRef.octoCanMove) {
			octopusRef.octoCanMove = true;
		}
	}

	private void updateGame4(GameContainer c, int delta) {

		phoneRef.update(c, delta);
	}

	@Override
	public int getID() {

		return StateController.GAMEPLAY;
	}

}
