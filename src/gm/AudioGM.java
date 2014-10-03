package gm;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

public class AudioGM {

	public Music menuAD;
	public Music gameOverAD;
	public Music gamePlayAD;
	
	public AudioGM() throws SlickException{
		
		menuAD = new Music("res/menuAD.wav");
		gameOverAD = new Music("res/gameOverAD.wav");
		gamePlayAD = new Music("res/gamePlayAD.wav");
	}
}