package state;

import gm.ReadRanking;
import gm.WritingRanking;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class RankingState extends BasicGameState{

	private Image rankingBG;
	private WritingRanking writterRef;
	private ReadRanking readerRef;
	public static boolean enterRankingState = false;
	@Override
	public void init(GameContainer c, StateBasedGame s) throws SlickException {
		rankingBG = new Image("res/rankingBG.png");
		
		readerRef = new ReadRanking();
		writterRef = new WritingRanking();
	}

	@Override
	public void render(GameContainer c, StateBasedGame s, Graphics g) throws SlickException {
		rankingBG.draw(0, 0);
		readerRef.showRanking(g);
	}

	@Override
	public void update(GameContainer c, StateBasedGame s, int delta)throws SlickException {
		
		updateRanking();
		enterMenuState(c, s);
		
	}

	private void updateRanking() {
		if(enterRankingState)
		{
			writterRef = new WritingRanking();
			readerRef = new ReadRanking();
			enterRankingState=false;
		}
	}

	private void enterMenuState(GameContainer c, StateBasedGame s) {
		if(c.getInput().isKeyPressed(Input.KEY_1))
		{
			s.enterState(StateController.MENU);
		}
	}

	@Override
	public int getID() {
		return StateController.RANKING;
	}

}
