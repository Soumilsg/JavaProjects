package jrJava.alienInvaderWithImages_polymorphism;

import java.awt.Image;

public class RealNastyAlien extends CloakAlien {

	
	public RealNastyAlien(int x, int y, int vx, int vy, Image image1, Image image2) {
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
	
	
	public void shootMissile(){
		if(Math.random()<0.06){
			MissileManager.add( new Missile(x-width/4, y+10, 2*vy) );
			MissileManager.add( new Missile(x, y+10, 2*vy) );
			MissileManager.add( new Missile(x+width/4, y+10, 2*vy) );
		}
	}
	
	
}
