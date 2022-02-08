package jrJava.alienInvaderWithImages_polymorphism;

import java.awt.Image;

public class NastyAlien extends SimpleAlien {

	
	public NastyAlien(int x, int y, int vx, int vy, Image image1, Image image2) {
		super(x, y, vx, vy, image1, image2);
	}

	

	public void move(Ship ship){
		
		if(x<ship.getX()) x += (ship.getX()-x)/15;
		else if(x>ship.getX()) x -= (x-ship.getX())/15;
		
		y += vy;
		
		shootMissile();
		
		if(ship.isHit(this)){
			collided = true;
		}
	}
	
	
}
