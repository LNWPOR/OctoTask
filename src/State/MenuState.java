package State;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MenuState extends BasicGameState{

	@Override
	public void init(GameContainer c, StateBasedGame s)throws SlickException {
		
		
	}

	@Override
	public void render(GameContainer c, StateBasedGame s, Graphics g)throws SlickException {
		g.drawString("1-Play", 512, 340);
		g.drawString("2-Custom", 512, 360);
		g.drawString("3-Ranking", 512, 380);
	}

	@Override
	public void update(GameContainer c, StateBasedGame s, int delta)throws SlickException {
	
		if(c.getInput().isKeyPressed(Input.KEY_1))
		{
			s.enterState(StateController.GamePlay);
		}
	}

	@Override
	public int getID() {
		return StateController.Menu;
	}

}
