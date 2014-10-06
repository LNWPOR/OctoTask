package oj;

import gm.AudioGM;
import gm.GameController;

import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Rat {

	protected float startX;
	protected float x;
	protected float y;
	protected float speed = 1;
	protected Shape ratShapeRec;// 160*80
	protected Image ratImg;
	protected boolean startFromleft;
	protected boolean startFromRight;

	Random rand = new Random();
	private Octopus octopusRef;
	private HP hpRef;
	private AtkRat atkRef;
	private AudioGM audioRef;
	protected boolean canPlayRatAD = false;

	public Rat() throws SlickException {

		audioRef = new AudioGM();
		hpRef = new HP();
		ratShapeRec = new Rectangle(this.x, this.y, 150, 75);
		randStartRatPos();
		atkRef = new AtkRat();
	}

	private void randStartRatPos() {

		startFromleft = false;
		startFromRight = false;
		y = GameController.gameHeight / 2 + 140;
		if (rand.nextBoolean()) { // start from left
			x = -1000;
			startFromleft = true;
		} else {
			x = GameController.gameWidth + 1000; // start from right
			startFromRight = true;
		}
		if (canPlayRatAD) {
			audioRef.ratAD.play();
		}
	}

	public void render(Graphics g) {

		g.drawImage(ratImg, x, y);
	}

	public void update(GameContainer c) {

	}

	protected void checkCollision(GameContainer c) {

		if (ratShapeRec.intersects(octopusRef.octoShapeRec)) {
			hpRef.HpDamage();
			randStartRatPos();

		}

		if (ratShapeRec.intersects(atkRef.atkWhiteLeftShapeRec)) {
			if (c.getInput().isMouseButtonDown(0)) {
				randStartRatPos();
			}
		}

		if (ratShapeRec.intersects(atkRef.atkWhiteRightShapeRec)) {
			if (c.getInput().isMouseButtonDown(1)) {
				randStartRatPos();
			}
		}

	}

	protected void ratMove() {

		if (startFromleft) {
			x += speed;
		}
		if (startFromRight) {
			x -= speed;
		}
	}
}
