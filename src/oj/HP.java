package oj;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import gm.AudioGM;

public class HP {

	public static int hp;
	public static int currentHp;
	private AudioGM audioRef;
	public SpriteSheet damageSP;
	public Animation damageAnim;
	public SpriteSheet healthSP;
	public Animation healthAnim;
	
	public HP() throws SlickException {
		audioRef = new AudioGM();
		damageSP = new SpriteSheet("res/damageSP.png",200,200);
		damageAnim = new Animation(damageSP,100);
		healthSP = new SpriteSheet("res/healthSP.png", 200, 200);
		healthAnim = new Animation(healthSP,100);
		currentHp=hp;
	}
	
	public void renderDamage(){
		damageAnim.draw(Octopus.octoShapeRec.getX(), Octopus.octoShapeRec.getY());
	}
	public void renderHealth(){
		healthAnim.draw(Octopus.octoShapeRec.getX(), Octopus.octoShapeRec.getY());
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
