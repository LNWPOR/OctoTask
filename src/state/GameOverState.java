package state;

import gm.AudioGM;
import gm.GameController;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameOverState extends BasicGameState {

	private Image gameOverBGImg;
	private Image scoreBoxImg;
	private AudioGM audioRef;
	private boolean playOverAD = false;
	
	
	@Override
	public void init(GameContainer c, StateBasedGame s) throws SlickException {

		gameOverBGImg = new Image("res/gameOverBG.png");
		scoreBoxImg = new Image("res/scoreBox.png");
		audioRef = new AudioGM();
	}

	@Override
	public void render(GameContainer c, StateBasedGame s, Graphics g)
			throws SlickException {

		gameOverBGImg.draw();

		scoreBoxImg.draw(GameController.gameWidth / 2 - 100,
				GameController.gameHeight / 2 - 200);
		g.setColor(Color.red);
		g.drawString("" + GamePlayState.score, 600, 300);

	}

	@Override
	public void update(GameContainer c, StateBasedGame s, int delta)
			throws SlickException {

		playOverAD();

		enterMenuState(c, s);
		enterRankingState(c, s);
	}

	private void enterRankingState(GameContainer c, StateBasedGame s) throws SlickException {
		if (c.getInput().isKeyPressed(Input.KEY_2)
				&& !audioRef.gameOverAD.playing()) {
			GamePlayState.score = 0;
			playOverAD = false;
			RankingState.enterRankingState =true;
			s.enterState(StateController.RANKING);

		}
	}

	private void enterMenuState(GameContainer c, StateBasedGame s) {
		if (c.getInput().isKeyPressed(Input.KEY_1)
				&& !audioRef.gameOverAD.playing()) {
			GamePlayState.score = 0;
			playOverAD = false;
			s.enterState(StateController.MENU);

		}
	}

	private void playOverAD() {

		if (!audioRef.gameOverAD.playing() && !playOverAD) {
			audioRef.gameOverAD.play();
			playOverAD = true;
		}
	}

	@Override
	public int getID() {

		return StateController.GAMEOVER;
	}

}
