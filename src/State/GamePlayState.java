package State;

import java.util.LinkedList;

import org.lwjgl.util.Timer;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;








import Object.Calculator;
import Object.Dust;
import Object.HP;
import Object.Octopus;

 public class GamePlayState extends BasicGameState{

	private Image blackground;
	private Dust[] dusts;
	private int dustCount=10;
	private Octopus octopusRef;
	private Calculator calRef;
	
	public GamePlayState() throws SlickException {
		blackground = new Image("res/bg.png");

	}
	
	@Override
	public void init(GameContainer c, StateBasedGame s)throws SlickException {
		octopusRef = new Octopus();
		initGame2();
		initGame3();
	}
	private void initGame2() throws SlickException {
		float rangeFall=500;
		dusts = new Dust[dustCount];
	   for(int i =0; i<dustCount;i++)
	   {
		  dusts [i] = new Dust(i*rangeFall);
	     
	    }
	}
	private void initGame3() throws SlickException {
		calRef = new Calculator();
	}


	@Override
	public void render(GameContainer c, StateBasedGame s, Graphics g)throws SlickException {
		//g.setColor(Color.transparent);//collider จะได้ไม่มีสี
		blackground.draw(0,0);
		
		octopusRef.render(g);
		renderGame3(g);
		renderGame2(g);
		
		g.setColor(Color.white);//UI จะได้มีสี
		g.drawString("HP "+HP.hp, 100, 10);
	}
	private void renderGame2( Graphics g) {
		for (Dust dust :dusts) {
		    dust.render(g);
		    }
	}
	private void renderGame3(Graphics g) {
		calRef.render(g);
	}



	@Override
	public void update(GameContainer c, StateBasedGame s, int delta)throws SlickException {
		octopusRef.update(c);
		updateGame2();
		updateGame3(c);
		
		
      
	}
	private void updateGame2() {
		for (Dust dust :dusts) {
			    dust.update();
			    }
	}

	private void updateGame3(GameContainer c) {
		calRef.update(c);
	}

	

	
	@Override
	public int getID() {
		
		return StateController.GamePlay;
	}

	

}
