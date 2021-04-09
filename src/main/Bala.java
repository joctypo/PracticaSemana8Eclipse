package main;

import processing.core.PApplet;

public class Bala {

	private PApplet app;
	private int  x,y; 
	private boolean movetoRight;
	
	public Bala(PApplet app, int x, int y, boolean movetoRight) {
		this.app = app;
		this.x=x;
		this.y=y;
		this.movetoRight = movetoRight;
			
	}
	
	public void pintar() {
		
		app.fill(255);
		app.ellipse(this.x,this.y,10,10);
		
		if(movetoRight) {
			
			x+=5;
			
		}else {
			
			x-=5;
			
		}
		
	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isMovetoRight() {
		return movetoRight;
	}

	public void setMovetoRight(boolean movetoRight) {
		this.movetoRight = movetoRight;
	}
	
	
}
