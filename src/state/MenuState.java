package state;



import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MenuState extends BasicGameState{

	private Image menuBGImg;
	private Music menuMS;
	@Override
	public void init(GameContainer c, StateBasedGame s)throws SlickException {
		menuBGImg = new Image("res/menuBG.png");
		menuMS = new Music("res/menuAD.wav");
	}

	@Override
	public void render(GameContainer c, StateBasedGame s, Graphics g)throws SlickException {
		menuBGImg.draw(0, 0);

	}

	@Override
	public void update(GameContainer c, StateBasedGame s, int delta)throws SlickException {
	
		//if(!audioRef.menuAD.playing())
		//{
		//	audioRef.menuAD.play();
		//	System.out.println("KUY");
		//d}
		
		
		
		if(c.getInput().isKeyPressed(Input.KEY_1))
		{
			//audioRef.menuAD.stop();
			s.enterState(StateController.GamePlay);
		}
	}

	@Override
	public int getID() {
		return StateController.Menu;
	}

}
