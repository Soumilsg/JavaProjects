package jrJava.alienInvaderWithImages_polymorphism;

import java.awt.Image;

public class MultiShootAlien extends NastyAlien {

	
	public MultiShootAlien(int x, int y, int vx, int vy, Image image1, Image image2) {
		super(x, y, vx, vy, image1, image2);
	}

	
	public void shootMissile(){
		if(Math.random()<0.06){
			MissileManager.add( new Missile(x-width/4, y+10, 2*vy) );
			MissileManager.add( new Missile(x, y+10, 2*vy) );
			MissileManager.add( new Missile(x+width/4, y+10, 2*vy) );
		}
	}
	
	
}
