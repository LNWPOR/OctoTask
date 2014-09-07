package State;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GamePlayState extends BasicGameState{

	@Override
	public void init(GameContainer c, StateBasedGame s)throws SlickException {
		
		
	}

	@Override
	public void render(GameContainer c, StateBasedGame s, Graphics g)throws SlickException {
		
		g.drawRect(100, 100, 100, 100);
	}

	@Override
	public void update(GameContainer c, StateBasedGame s, int delta)throws SlickException {
	
		
	}

	@Override
	public int getID() {
		
		return StateController.GamePlay;
	}

}