package Object;


import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;
import org.jbox2d.testbed.framework.j2d.DebugDrawJ2D;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import GM.GameController;

public class Seesaw {

	private Image triangleImg;//70*70
	private Image rectangleImg;//350*30
	private Image ballImg;//80*80
	
	private float tx ;
	private float ty ;
	private float rx ;
	private float ry ;
	private float bx ;
	private float by ;
	
	//-------
		Vec2 gravity = new Vec2(0.0f, 9.8f);
		boolean doSleep = true;
		World world ;
	//-------
		float timeStep = 1.0f/60.0f;
		int velocityIterations = 6 ;
		int positionIterations = 2;
    //-------
		BodyDef ballBD;
		Body ballB;
		PolygonShape ballPolygon;
		FixtureDef ballFD;
    //-------
		BodyDef recBD;
		Body recB;
		PolygonShape recPolygon;
		FixtureDef recFD;
	//-------
		
	public Seesaw(GameContainer c) throws SlickException{
		
		world = new World(gravity);
		//----------------------------------------
		triangleImg = new Image("res/triangle.png");
		rectangleImg = new Image("res/Rectangle.png");	
		ballImg = new Image("res/ball.png");
		this.rx = GameController.gameWidth-400;
		this.ry = GameController.gameHeight-200;
		 
		this.tx = GameController.gameWidth-260;
		this.ty = GameController.gameHeight-200;
		
		this.bx = tx-5;
		this.by = ty-80;
		//------------------------------------------
		ballBD = new BodyDef();
		ballBD.type = BodyType.DYNAMIC;
		ballBD.position.set(bx,by);
		ballB = world.createBody(ballBD);
		ballPolygon = new PolygonShape();
		ballPolygon.setAsBox(1.0f, 1.0f);// 30 pixel = 1 meter
		ballFD = new FixtureDef();
		ballFD.shape = ballPolygon;
		ballFD.density = 1;
		ballFD.friction = 0.3f;
		ballB.createFixture(ballFD);
		//-------------------------------------------
		recBD = new BodyDef();
		recBD.type = BodyType.KINEMATIC;
		recBD.position.set(rx,ry);
		recB = world.createBody(recBD);
		recPolygon = new PolygonShape();
		recPolygon.setAsBox(175, 15);
		recFD = new FixtureDef();
		recFD.shape = recPolygon;
		recFD.density = 1;
		recFD.friction = 0.3f;
		recB.createFixture(recFD);
		
	}
	
	public void render(Graphics g){
		
		rectangleImg.draw(recB.getPosition().x,recB.getPosition().y);
		triangleImg.draw(tx, ty);
		ballImg.draw(ballB.getPosition().x,ballB.getPosition().y);
		
		
		
	}
	public void update(GameContainer c,int delta){
		
		 
		
		if(c.getInput().isKeyDown(Input.KEY_LEFT)&&rectangleImg.getRotation()>=-20){
			
			rectangleImg.rotate((float) -0.3);
			recB.setAngularVelocity(-0.1f);
			//ballB.applyAngularImpulse(-20);
			System.out.println(ballB.getAngularVelocity());
		
		}
		if(c.getInput().isKeyDown(Input.KEY_RIGHT)&&rectangleImg.getRotation() <=20){
			
			rectangleImg.rotate((float) +0.3);
			recB.setAngularVelocity(0.1f);
		}
		world.step(timeStep, velocityIterations, positionIterations);
		
		
	}
}
