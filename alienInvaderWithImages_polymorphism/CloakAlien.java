package jrJava.alienInvaderWithImages_polymorphism;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Image;

import resources.DrawingBoard;

public class CloakAlien extends SimpleAlien {

	protected int cloakBegin = 0;
	protected int cloakComplete = (int)(0.4*Coordinator.SCREEN_HEIGHT);
	protected int cloakStop = (int)(0.8*Coordinator.SCREEN_HEIGHT);
	
	
	public CloakAlien(int x, int y, int vx, int vy, Image image1, Image image2) {
		super(x, y, vx, vy, image1, image2);
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
			
			Composite original = canvas.getComposite();
			
			float transparency = 1.0f;
			if(y>=cloakBegin && y<cloakComplete) transparency = 1.0f - ((float)y-cloakBegin)/(cloakComplete-cloakBegin);
			else if(y>=cloakComplete && y<cloakStop) transparency = 0.0f;
			else transparency = 1.0f;
			
			Composite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparency);
			canvas.setComposite(composite);
			
			numOfDraw++;
			if(numOfDraw%8<4) canvas.drawImage(image1, x-width/2, y-height, null);
			else canvas.drawImage(image2, x-width/2, y-height, null);
			
			canvas.setComposite(original);
		}
	}
	
}










