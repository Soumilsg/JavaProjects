package jrJava.alienInvaderWithImages_polymorphism;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

import resources.DrawingBoard;

public class AlienManager {

	private static int maxNumber = 100; // length of the array
	private static int size; //number of live aliens.
	private static Alien[] aliens; 
	private static Image[] images1, images2;
	
	
	static {
		aliens = new Alien[maxNumber];
		images1 = new Image[3];
		images2 = new Image[3];
		
		images1[0] = new ImageIcon(Coordinator.RESOURCE_PATH + "greenAlien_1.png").getImage();
		images2[0] = new ImageIcon(Coordinator.RESOURCE_PATH + "greenAlien_2.png").getImage();
		images1[1] = new ImageIcon(Coordinator.RESOURCE_PATH + "blueAlien_1.png").getImage();
		images2[1] = new ImageIcon(Coordinator.RESOURCE_PATH + "blueAlien_2.png").getImage();
		images1[2] = new ImageIcon(Coordinator.RESOURCE_PATH + "orangeAlien_1.png").getImage();
		images2[2] = new ImageIcon(Coordinator.RESOURCE_PATH + "orangeAlien_2.png").getImage();
	}
	
	
	public static void draw(DrawingBoard board){
		for(int i=0; i<size; i++){
			aliens[i].draw(board);
		}
	}
	
	
	public static boolean isHit(Torpedo torpedo){
		for(int i=0; i<size; i++){
			if(aliens[i].isHit(torpedo)){
				return true;
			}
		}
		return false;
	}
	
	
	public static void create(){
		
		int x = (int)(Coordinator.SCREEN_WIDTH*Math.random());
		int vx = (int)(11*Math.random() - 5);
		int vy = (int)(6*Math.random() + 5);
		
		int imageIndex = (int)(Math.random()*images1.length);
		
		
		Alien alien;
		
		double rand = Math.random();
		
		if(rand>=0.8) alien = new MultiShootAlien(x, -100, vx, vy, images1[imageIndex], images2[imageIndex]);
		else if(rand>0.6) alien = new SimpleAlien(x, -100, vx, vy, images1[imageIndex], images2[imageIndex]);
		else if(rand>0.4) alien = new CloakAlien(x, -100, vx, vy, images1[imageIndex], images2[imageIndex]);
		else if(rand>0.2) alien = new RealNastyAlien(x, -100, vx, vy, images1[imageIndex], images2[imageIndex]);
		else alien = new NastyAlien(x, -100, vx, vy, images1[imageIndex], images2[imageIndex]);
		
		add(alien);
	}
	
	
	
	public static void move(Ship ship){
		
		if(Math.random()>0.95) create();
		
		//walk backward
		for(int i=size-1; i>=0; i--){
			aliens[i].move(ship);
			if(aliens[i].getY()>Coordinator.SCREEN_HEIGHT){
				remove(i);
			}
		}
		
		/*
		// walk forward
		for(int i=0; i<size; i++){
			aliens[i].move(ship);
			if(aliens[i].getY()<0){
				remove(i);
				i--; // rewind the index
			}
		}
		*/
	}
	
	
	public static void add(Alien alien){
		if(size==maxNumber) return;
		aliens[size] = alien;
		size++;
	}
	
	
	public static void remove(int index){
		for(int i=index+1; i<size; i++){
			aliens[i-1] = aliens[i];
		}
		aliens[size-1] = null;
		size--;
	}
	

	public static void remove(Alien alien){
		for(int i=0; i<size; i++){
			if(aliens[i]==alien){
				remove(i);
				return;
			}
		}
	}
	
	
	
}
