package state;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameOverState extends BasicGameState{

	private Image gameOverBGImg;
	@Override
	public void init(GameContainer c, StateBasedGame s)throws SlickException {
		gameOverBGImg = new Image("res/gameOverBG.png");
		
	}

	@Override
	public void render(GameContainer c, StateBasedGame s, Graphics g)throws SlickException {
		gameOverBGImg.draw();
		g.setColor(Color.red);
		g.drawString("Your score is "+GamePlayState.score, 500,300);
		g.drawString("KAK mak mak eiei :P", 500, 375);
		g.drawString("1-Menu", 500, 450);
	}

	@Override
	public void update(GameContainer c, StateBasedGame s, int delta)throws SlickException {
		
		if(c.getInput().isKeyPressed(Input.KEY_1))
		{
			GamePlayState.score=0;
			s.enterState(StateController.Menu);
		}
	}

	@Override
	public int getID() {
		
		return StateController.GameOver;
	}
		
}
