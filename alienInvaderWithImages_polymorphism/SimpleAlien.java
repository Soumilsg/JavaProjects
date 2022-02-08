package jrJava.alienInvaderWithImages_polymorphism;

import java.awt.Image;
import java.awt.Graphics2D;
import resources.DrawingBoard;


public class SimpleAlien extends Alien {

	
	public SimpleAlien(int x, int y, int vx, int vy, Image image1, Image image2) {
		super(x, y, vx, vy, image1, image2);
	}

	
	public void move(Ship ship){
		x += vx;
		y += vy;
		
		shootMissile();
		
		if(ship.isHit(this)){
			collided = true;
		}
	}
	
	
	public void shootMissile(){
		if(Math.random()<0.06) MissileManager.add( new Missile(x, y+10, 2*vy) );
	}
	
	
	public void draw(DrawingBoard board){
		Graphics2D canvas = board.getCanvas();
		
		if(collided){
			canvas.setColor(explosionColor);
			canvas.fillOval(x-explosionRadius, y-explosionRadius, 2*explosionRadius, 2*explosionRadius);
			//Coordinator.missile = null;
			Coordinator.gameOver = true;
		}
		else {
			numOfDraw++;
			if(numOfDraw%8<4) canvas.drawImage(image1, x-width/2, y-height, null);
			else canvas.drawImage(image2, x-width/2, y-height, null);
		}
	}
	
}
