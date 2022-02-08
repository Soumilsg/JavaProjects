package jrJava.brickBuster_usingStatic;

import java.awt.Color;
import resources.SoundPlayer;
import javax.swing.JFrame;
import resources.DrawingBoard;
import resources.SoundPlayer;
import resources.Timer;

public class Coordinator {
	
	private static int screenWidth = 540;
	private static int screenHeight = 700;

	
	public static void main(String[] args) {
		
		SoundPlayer sound; 
		sound = new SoundPlayer("jrJava/brickBuster_ML/harryPotter_low.wav");
		
		//prepare DrawingBoard, Timer
		DrawingBoard board = new DrawingBoard(540, 700);
		Timer timer = new Timer();
		
		//prepare balls: ball2, ball2, ...
		int numOfBalls = 5; 
		Ball[] balls = new Ball[numOfBalls];
		for(int i = 0; i < balls.length; i++) {
			Color ballColor = new Color( (int)(Math.random()*120), (int)(Math.random()*120), (int)(Math.random()*120));
			balls[i] = new Ball(300, 500, (int)(Math.random()*6+2), -(int)(Math.random()*8+3), 6, ballColor);
		}
		
		//prepare wall
		Wall wall = new Wall();
		
		
		//prepare deflector
		Deflector deflector = new Deflector(80, 610);
		
		deflector.setWall(wall); 
		
		board.addMouseMotionListener(deflector); 
		board.addMouseListener(deflector); 
		
		board.getJFrame().addKeyListener(deflector); 
		
		int numOfColumns = 10; 
		int brickWidth = (Wall.getRight() - Wall.getLeft())/numOfColumns;
		int brickHeight = brickWidth/5;
		
		BrickManager[] brickManagers = new BrickManager[numOfColumns];
		for(int i = 0; i < brickManagers.length; i++) {
			brickManagers[i] = new BrickManager(Wall.getLeft() + i*brickWidth, Wall.getTop(), brickWidth, brickHeight, (int)(Math.random()*21+5));
		}
		
		for(int i = 0; i < balls.length; i++) {
			//balls[i].setwall(wall);
			balls[i].setDeflector(deflector);
			balls[i].setBrickManagers(brickManagers); 
		}
		
		int count = 0; 
		while(true){
			
			count++;
			if(count%10==0) balls[0].changeRadius();
			
			for(int i = 0; i < balls.length; i++) balls[i].move();
			
			board.clear();
			
			for(int i = 0; i < balls.length; i++) balls[i].draw(board); 
			deflector.draw(board); 
			wall.draw(board);
			
			for(int i = 0; i < brickManagers.length; i++) brickManagers[i].draw(board);
			
			sound.play();
			
			board.repaint();
			timer.pause(20);
 		}
	}

}






