package state;

import gm.AudioGM;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MenuState extends BasicGameState{

	private Image menuBGImg;
	private AudioGM audioRef;
	@Override
	public void init(GameContainer c, StateBasedGame s)throws SlickException {
		menuBGImg = new Image("res/menuBG.png");
		audioRef = new AudioGM();
		audioRef.menuAD.loop();
	}

	@Override
	public void render(GameContainer c, StateBasedGame s, Graphics g)throws SlickException {
		menuBGImg.draw(0, 0);

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
