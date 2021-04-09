package main;

import processing.core.PApplet;

public class Avatar {

	
	private int x;
	private int y;
	private int color;
	private Main main;
	private boolean moviendoarriba=false,moviendoabajo=false,moviendoderecho=false,moviendoizquierdo=false; 
	public Avatar(Main main, int x, int y, int color) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.main = main;
	}
	
	public void pintar() {
		if(moviendoarriba) {
			
			this.y-=2;
			
			
		}else if (moviendoabajo) {
			
			this.y+=2;
			
		}else if (moviendoderecho) {
			
			
			this.x+=2;
			
		}else if (moviendoizquierdo) {
			
			this.x-=2;
			
			
		}
		
		main.fill(this.color);
		main.ellipse(this.x, this.y, 50, 50);
		
		
	}
	
	public void moveRight() {
		this.x+=5;
	}
	
	public void moveLeft() {
		this.x-=5;
	}
	public void moveUp() {
		this.y-=5;
	}
	public void moveDown() {
		this.y+=5;
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

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
	
public void arribamuevalo() {
		
		moviendoarriba=true;
		
	}
	
	public void arribaparelo() {
		
		moviendoarriba=false;
		
	}
	
	public void abajomuevalo() {
		
		moviendoabajo=true;
		
	}
	
	public void abajoparelo() {
		
		moviendoabajo=false;
		
	}
	
	
	
	public void derechomuevalo() {
		
		moviendoderecho=true;
		
	}
	
	public void derechoparelo() {
		
		moviendoderecho=false;
		
	}
	
	public void izquierdomuevalo() {
		
		moviendoizquierdo=true;
		
	}
	
	public void izquierdoparelo() {
		
		moviendoizquierdo=false;
		
	}


	
	
	
}
