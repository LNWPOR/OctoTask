package gm;



import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.*;

import state.GameOverState;
import state.GamePlayState;
import state.MenuState;

public class GameController extends StateBasedGame{
    public static int gameWidth=1024;
    public static int gameHeight=720;
    
    
    
	public GameController(String name) {
		super(name);
		
	}

	public static void main(String[] args) {
	
		try{
			AppGameContainer app  = new AppGameContainer(new GameController("OctoTask"));
			app.setDisplayMode(gameWidth,gameHeight, false);
			//app.setMinimumLogicUpdateInterval(1000 / 60);
			app.start();
		}catch(SlickException e)
		{
			System.out.println(e);
		}
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		// TODO Auto-generated method stub
		this.addState(new MenuState());
		this.addState(new GamePlayState());
		this.addState(new GameOverState());
	}

}
