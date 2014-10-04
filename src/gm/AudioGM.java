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
	public Sound phone1AD;
	public Sound phone2AD;
	public Sound phone3AD;
	public Sound phone4AD;
	public Sound octoAtkAD;
	
	public AudioGM() throws SlickException{
		
		menuAD = new Music("res/menuAD.wav");
		gameOverAD = new Music("res/gameOverAD.wav");
		gamePlayAD = new Music("res/gamePlayAD.wav");
		
		damageAD = new Sound("res/damage2.wav");
		increaseHPAD = new Sound("res/gainlp.wav");
		changePhoneAD = new Sound("res/changePhoneAD.wav");
		phone1AD = new Sound("res/phone1AD.wav");
		phone2AD = new Sound("res/phone2AD.wav");
		phone3AD = new Sound("res/phone3AD.wav");
		phone4AD = new Sound("res/phone4AD.wav");
		octoAtkAD = new Sound("res/octoAtkAD.wav");
	}
}