package State;

import java.util.LinkedList;

import org.newdawn.slick.Color;
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
	private Octopus octopusRef;
	private int dustCount=1;
	private LinkedList<Game2> game2;
	
	public GamePlayState() throws SlickException {
		blackground = new Image("res/bg.png");
		game2 = new LinkedList<Game2>();
	}
	
	@Override
	public void init(GameContainer c, StateBasedGame s)throws SlickException {
		octopusRef = new Octopus();
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
		g.setColor(Color.transparent);//collider จะได้ไม่มีสี
		blackground.draw(0,0);
	
		octopusRef.render(g);
	
		renderGame2(g);
		
		g.setColor(Color.white);//UI จะได้มีสี
		g.drawString("HP "+HP.hp, 100, 10);
	}

	private void renderGame2( Graphics g) {
		for (Game2 g2 :game2) {
		    g2.render(g);
		    }
	}

	@Override
	public void update(GameContainer c, StateBasedGame s, int delta)throws SlickException {
		
		updateGame2();
		octopusRef.update(c);
		//octopusController(c);
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
