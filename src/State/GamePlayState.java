package State;

import java.util.LinkedList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;





import Object.Dust;
import Object.HP;
import Object.Octopus;

 public class GamePlayState extends BasicGameState{

	private Image blackground;
	private Dust[] dusts;
	private Octopus octopus;
	private int dustCount=5;
	private LinkedList<Game2> game2;
	
	public GamePlayState() throws SlickException {
		blackground = new Image("res/bg.png");
		game2 = new LinkedList<Game2>();
	}
	
	@Override
	public void init(GameContainer c, StateBasedGame s)throws SlickException {
		octopus = new Octopus();
		initGame2();
	}

	private void initGame2() throws SlickException {
		 float rangeFall=500;
		dusts = new Dust[dustCount];
	   for(int i =0; i<dustCount;i++)
	   {
		  dusts [i] = new Dust(i*rangeFall);
	      game2.add(dusts[i]);
	    }
	}

	@Override
	public void render(GameContainer c, StateBasedGame s, Graphics g)throws SlickException {
		
		blackground.draw(0,0);
		octopus.render();
		g.drawString("HP "+HP.hp, 100, 10);
		renderGame2();
		
		
	}

	private void renderGame2() {
		for (Game2 g2 :game2) {
		    g2.render();
		    }
	}

	@Override
	public void update(GameContainer c, StateBasedGame s, int delta)throws SlickException {
		octopus.update();  
		updateGame2();
		octopusController(c);
	}

	private void octopusController(GameContainer c) {
		if(c.getInput().isKeyDown(Input.KEY_A))
		{
			octopus.MoveLeft();
		}
		if(c.getInput().isKeyDown(Input.KEY_D))
		{
			octopus.MoveRight();
		}
	}

	private void updateGame2() {
		for (Game2 g2 :game2) {
			    g2.update();
			    }
	}

	@Override
	public int getID() {
		
		return StateController.GamePlay;
	}

	

}
