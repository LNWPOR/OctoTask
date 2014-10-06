package oj;

import gm.GameController;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Octopus {

	private Image octopusImg; // 200*200
	private static float x = GameController.gameWidth / 2 - 100;
	private static float y = GameController.gameHeight / 2 + 10;
	public static Shape octoShapeRec;
	public boolean octoCanMove = false;
	public float speed = 1;

	public Octopus() throws SlickException {

		octopusImg = new Image("res/Octopus2.png");
		x = GameController.gameWidth / 2 - 100;
		y = GameController.gameHeight / 2 + 10;
		octoShapeRec = new Rectangle(this.x, this.y, 200, 200);
	}

	public void render(Graphics g) {

		octopusImg.draw(x, y);

	}

	public void update(GameContainer c) {

		octoShapeRec.setLocation(x, y);
		octoMoveSet(c);
	}

	public void octoMoveSet(GameContainer c) {

		if (octoCanMove == true) {
			if (c.getInput().isKeyDown(Input.KEY_A)) {
				MoveLeft();
			}
			if (c.getInput().isKeyDown(Input.KEY_D)) {
				MoveRight();
			}
		}
	}

	public void MoveLeft() {

		if (this.x != 0)
			this.x -= speed;
	}

	public void MoveRight() {

		if (this.x != GameController.gameWidth - 200)
			this.x += speed;
	}

	public float getX() {

		return x;
	}

	public float getY() {
		return y;
	}
}
