package gm;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class AudioGM {

	public Music menuAD;
	public Music gameOverAD;
	public Music gamePlayAD;
	
	public Sound damageAD;
	public Sound increaseHPAD;
	public Sound changePhoneAD;
	
	public AudioGM() throws SlickException{
		
		menuAD = new Music("res/menuAD.wav");
		gameOverAD = new Music("res/gameOverAD.wav");
		gamePlayAD = new Music("res/gamePlayAD.wav");
		
		damageAD = new Sound("res/damage.wav");
		increaseHPAD = new Sound("res/gainlp.wav");
		changePhoneAD = new Sound("res/changePhoneAD.wav");
	}
}