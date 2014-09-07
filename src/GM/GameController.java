package GM;

import java.util.concurrent.ExecutionException;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.*;

import State.GamePlayState;
import State.MenuState;

public class GameController extends StateBasedGame{
    public static int gameWidth=1024;
    public static int gameHeight=720;
    
    
    
	public GameController(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			AppGameContainer app  = new AppGameContainer(new GameController("OctoTask"));
			app.setDisplayMode(gameWidth,gameHeight, false);
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
	}

}
