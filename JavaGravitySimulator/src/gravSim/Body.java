package gravSim;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Observable;

public class Body extends Observable{
	private double mass;
	private double radius;
	private double xpos, ypos;
	private double xvel, yvel;
	private Vector2D pos, vel;
	private static SimulatorViewer view;
	private static SimulatorWin win;
	private static BodyList bodyList= new BodyList();
	
	final double G = 6.674e-11;
	final double dT = 10000;
	
	public Body() {
		setMass(100);
		vel = new Vector2D(0,0);
		setPos(0,0);
		bodyList.add(this);
		bodyList.changed();
	}
	public Body(double posx, double posy) {
		setMass(100);
		vel = new Vector2D(0,0);
		setPos(posx,posy);
		bodyList.add(this);
		bodyList.changed();
	}
	
	public void setMass(double mass) {
		this.mass = mass;
		this.radius = mass/5;
		bodyList.changed();
	}
	
	public void setPos(double x, double y) {
		pos = new Vector2D(x,y);
		bodyList.changed();
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval((int)pos.x, (int)pos.y, (int)radius, (int)radius);
	}
	
	public void calculate(int index) {
		if(bodyList.bodies.size() == 1) {
			setPos(xpos + xvel, ypos + yvel);
			return;
		}
		double posChangeX = 0;
		double posChangeY = 0;
		double distX;
		double distY;
		double dist;

		for(int i = 0; i < bodyList.bodies.size(); i++) {
			if(i != index) {
				Body temp = bodyList.bodies.get(i);
				dist = this.pos.getDistance(temp.pos);
				dist = Math.max(dist, this.radius + temp.radius);
				Vector2D direction = new Vector2D();
				direction.setDirection(this.pos, temp.pos);
				vel.calculateVelocity(dist, this.mass, temp.mass, direction);
				
				
				//distX = this.xpos - temp.xpos;
				//distY = this.ypos - temp.ypos;
				//distX = Math.max(distX, radius);
				//distY = Math.max(distY, radius);
//				this.xvel += dT *(G*this.mass*temp.mass/(distX*distX) / mass) * -Math.signum(distX);
//				this.yvel += dT *(G*this.mass*temp.mass/(distY*distY) / mass) * -Math.signum(distY);
			}
		}
		setPos(pos.x + vel.x, pos.y + vel.y);
		bodyList.changed();
	}
	
	public static void main(String[] a) {
		view = new SimulatorViewer();
		win = new SimulatorWin();
		win.add(bodyList);
		
		
		Body b = new Body(0,0);
		Body b1 = new Body(500,500);
		Body b2 = new Body(0,1000);
		Body b3 = new Body(100,500);
		
//		for(int i = 0; i < 10; i++) {
//			for(int k = 0; k < 10; k++) {
//				new Body(i*100,k*100);
//			}
//		}

		bodyList.changed();
		
		while(true) {
			for(int i = 0; i < bodyList.bodies.size();i++)
				bodyList.bodies.get(i).calculate(i);
		}
		
	}
}
