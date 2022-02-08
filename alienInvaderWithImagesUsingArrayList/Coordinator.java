package jrJava.alienInvaderWithImagesUsingArrayList;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.HashSet;

import javax.swing.ImageIcon;

import resources.DrawingBoard;
import resources.SoundPlayer;
import resources.Timer;

public class Coordinator {

	
	public static final String RESOURCE_PATH = "jrJava/alienInvaderWithImages/ImagesAndSounds/";
	
	public static boolean gameOver;
	
	public static final int SCREEN_WIDTH;  // AM_I_PRETTY 
	public static final int SCREEN_HEIGHT;
	
	//public static Torpedo torpedo;
	//public static Alien alien;
	//public static Missile missile;
	
	static {
		SCREEN_WIDTH = 800;
		SCREEN_HEIGHT = 750;
	}
	
	 
	public static void main(String[] args){
	
		DrawingBoard board = new DrawingBoard(SCREEN_WIDTH, SCREEN_HEIGHT);
		Timer timer  = new Timer();
		
		Ship ship = new Ship(300, 610);
		
		board.addMouseListener(ship); 
		board.addMouseMotionListener(ship);
		board.getJFrame().addKeyListener(ship); 
		
		board.setBackgroundImage(RESOURCE_PATH  + "bg.png"); 
		
		SoundPlayer bgSound = new SoundPlayer(RESOURCE_PATH + "bgMusic.wav");
		bgSound.playLoop();
		
		
		while(!gameOver){
		
			board.clear();
			
			AlienManager.move(ship);
			AlienManager.draw(board);
			
			TorpedoManager.move();
			TorpedoManager.draw(board);
		
			MissileManager.move(ship);
			MissileManager.draw(board);
			
			ship.draw(board);
		
			board.repaint();
			timer.pause(30);			
		}
		
		bgSound.stop();
		
		Image gameOverImage = new ImageIcon(RESOURCE_PATH + "gameOver.png").getImage();
		Graphics2D canvas = board.getCanvas();
		
		canvas.drawImage(gameOverImage, 
				         SCREEN_WIDTH/2 - gameOverImage.getWidth(null)/2,  
				         SCREEN_HEIGHT/2 - gameOverImage.getHeight(null)/2, 
				         null);
		board.repaint();
	}
	
}















