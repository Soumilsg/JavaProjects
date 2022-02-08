package jrJava.bouncyBall;

import java.awt.Color;

import resources.DrawingBoard;
import resources.SoundPlayer;
import resources.Timer;

public class Coordinator {

	
	public static void main(String[] args) {
		
		Ball b1, b2, b3;
		
		b1 = new Ball("redBall.png");
		b2 = new Ball("greenBall.png");
		b3 = new Ball("yellowBall.png");

		b1.setAll(100, 200, 5, -3);
		b2.setAll(500, 300, -4, 2);
		b3.setAll(300, 400, 3, 3);
		
		Wall wall = new Wall();
		
		b1.setWall(wall); 
		b2.setWall(wall); 
		b3.setWall(wall); 
		
		
		
		DrawingBoard board = new DrawingBoard(800, 600);
		Timer timer = new Timer();
		
		board.setBackgroundImage("jrJava/bouncyBall/bg.png");
		
		SoundPlayer bgSound = new SoundPlayer("jrJava/bouncyBall/harryPotter_low.wav");
		bgSound.playLoop();
		
		while(true){
			
			b1.move();
			b2.move();
			b3.move();
			
			board.clear();
			wall.draw(board);
			b1.draw(board);
			b2.draw(board);
			b3.draw(board);
			board.repaint();
			timer.pause(20); 
		}
		
	}

}






















