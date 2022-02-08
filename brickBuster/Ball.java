package jrJava.brickBuster;

import java.awt.Color;
import java.awt.Graphics2D;

import resources.DrawingBoard;

public class Ball {

	private int x, y; // center
	private int vx, vy;
	private int radius;
	private Color color;
	
	private Wall wall;
	private Deflector deflector;
	
	
	
	public Ball(int _x, int _y, int _vx, int _vy, int _radius, Color _color){
		x = _x;
		y = _y;
		vx = _vx;
		vy = _vy;
		radius = _radius;
		color = _color;
	}
	
	
	public void setWall(Wall _wall) {
		wall = _wall; 
	}
	
	
	public void setDeflector(Deflector _deflector) {
		deflector = _deflector;
	}
	
	
	public void move(){		
		x += vx; //x = x + vx;
		y += vy; //y = y + vy;
		
		//Check collision with the wall.
		if(x <= wall.left + radius) {
			x = wall.left + radius;
			vx = -vx;
		}
		else if(x >= wall.getRight() - radius) {
			x = wall.getRight() - radius;
			vx = -vx;
		}
		
		if(y <= wall.getTop() + radius) {
			y = wall.getTop() + radius;
			vy = -vy;
		}
		
		//Check collision with deflector
		if(x >= deflector.getX() - radius &&
			x <= deflector.getX() + deflector.getWidth() + radius &&
			y >= deflector.getY() - radius &&
			y <= deflector.getY() + deflector.getHeight()) {
			
			y = deflector.getY() - radius;
			vy = -vy;
		}
		
		
	}
	
	
	public void draw(DrawingBoard board){
		Graphics2D canvas = board.getCanvas();
		canvas.setColor(color);
		canvas.fillOval(x-radius, y-radius, 2*radius, 2*radius);
	}
	
}










