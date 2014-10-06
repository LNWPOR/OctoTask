package oj;

import org.newdawn.slick.SlickException;

import gm.AudioGM;

public class HP {

	public static int hp;
	private AudioGM audioRef;

	public HP() throws SlickException {
		audioRef = new AudioGM();
	}

	public void HpDamage() {
		hp -= 1;
		audioRef.damageAD.play();
	}

	public void HpIncrease() {
		hp += 1;
		audioRef.increaseHPAD.play();
	}

}
