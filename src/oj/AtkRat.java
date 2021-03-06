package oj;

import gm.AudioGM;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class AtkRat {

	private SpriteSheet atkWhiteLeftSP;
	private SpriteSheet atkWhiteRightSP;
	private Animation atkWhiteLeftAnim;
	private Animation atkWhiteRightAnim;

	public static Shape atkWhiteLeftShapeRec;
	public static Shape atkWhiteRightShapeRec;

	private Octopus octopusRef;
	private float x;
	private float y;

	private boolean isAtkLeft = false;
	private boolean isAtkRight = false;

	private AudioGM audioRef;

	public AtkRat() throws SlickException {

		audioRef = new AudioGM();
		atkWhiteLeftSP = new SpriteSheet("res/atk_white_sp_left2.png", 92, 200);
		atkWhiteLeftAnim = new Animation(atkWhiteLeftSP, 100);

		atkWhiteRightSP = new SpriteSheet("res/atk_white_sp_right2.png", 92, 200);
		atkWhiteRightAnim = new Animation(atkWhiteRightSP, 100);

		atkWhiteLeftShapeRec = new Rectangle(this.x, this.y, 92, 200);
		atkWhiteRightShapeRec = new Rectangle(this.x, this.y, 92, 200);

		octopusRef = new Octopus();

		x = octopusRef.getX() - 50;
		y = octopusRef.getY();
	}

	public void render() {
		renderAtk();
	}

	private void renderAtk() {

		if (isAtkLeft) {
			atkWhiteLeftAnim.draw(x, y);
			isAtkLeft = false;
		}

		if (isAtkRight) {
			atkWhiteRightAnim.draw(x + 225, y);
			isAtkRight = false;
		}
	}

	public void update(GameContainer c) {

		x = octopusRef.getX() - 50;
		atkWhiteLeftShapeRec.setLocation(x, y);
		atkWhiteRightShapeRec.setLocation(x + 225, y);
		atk(c);

	}

	private void atk(GameContainer c) {

		if (c.getInput().isMousePressed(0) || c.getInput().isMousePressed(1)) {
			audioRef.octoAtkAD.play();
		}

		if (c.getInput().isMouseButtonDown(0)) {
			isAtkLeft = true;
		} else if (c.getInput().isMouseButtonDown(1)) {
			isAtkRight = true;
		}
	}

}
