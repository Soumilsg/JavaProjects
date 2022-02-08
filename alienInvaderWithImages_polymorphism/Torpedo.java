package jrJava.alienInvaderWithImages_polymorphism;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import resources.DrawingBoard;

public class Torpedo {

	public static final int WIDTH, HEIGHT;
	
	private static Image image;
	private int x, y; // center, top
	private int vy; // vy<0
	private boolean collided1, collided2; // 1: with Alien,  2: with Missile
	private static Color explosionColor1, explosionColor2;
	private static int explosionRadius1, explosionRadius2;
	
	static {
		image = new ImageIcon(Coordinator.RESOURCE_PATH + "torpedo.png").getImage();
		
		WIDTH = image.getWidth(null);
		HEIGHT = image.getHeight(null);
		
		explosionColor1 = Color.orange;
		explosionRadius1 = 50;
		explosionColor2 = Color.pink;
		explosionRadius2 = 25;
	}
	
	
	public Torpedo(int x, int y, int vy){
		this.x = x;
		this.y = y;
		this.vy = vy;
	}
	
	
	public int getX(){ return x; }
	public int getY(){ return y; }
	public static int getWidth(){ return WIDTH; }
	public static int getHeight(){ return HEIGHT; }
	
	
	public void move(){
		y += vy;
	
		if(AlienManager.isHit(this)){
			collided1 = true;
			return;
		}
		
		
		if(MissileManager.isHit(this)){
			collided2 = true;
			return;
		}
	
	}
	
	
	public void draw(DrawingBoard board){
		Graphics2D canvas = board.getCanvas();
		
		if(collided1){
			canvas.setColor(explosionColor1);
			canvas.fillOval(x-explosionRadius1, y-explosionRadius1, 2*explosionRadius1, 2*explosionRadius1);
			TorpedoManager.remove(this);
		}
		
		else if(collided2){
			canvas.setColor(explosionColor2);
			canvas.fillOval(x-explosionRadius2, y-explosionRadius2, 2*explosionRadius2, 2*explosionRadius2);
			TorpedoManager.remove(this);
		}
		
		else {
			canvas.drawImage(image, x-WIDTH/2, y, null);
		}
	}
}
 

















