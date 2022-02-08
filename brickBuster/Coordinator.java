package jrJava.brickBuster;

import java.awt.Color;

import javax.swing.JFrame;

import resources.DrawingBoard;
import resources.Timer;

public class Coordinator {

	public static void main(String[] args) {
		
		//prepare DrawingBoard, Timer
		DrawingBoard board = new DrawingBoard(540, 700);
		Timer timer = new Timer();
		
		//prepare balls: ball2, ball2, ...
		Ball ball = new Ball(300, 500, 7, -9, 10, Color.red);
		
		//prepare wall
		Wall wall = new Wall();
		ball.setWall(wall);
		
		//prepare deflector
		Deflector deflector = new Deflector(80, 610);
		ball.setDeflector(deflector);
		deflector.setWall(wall); 
		
		JFrame frame = board.getJFrame();
		frame.addKeyListener(deflector);
		
		//prepare bricks: brick1, brick2, brick3, ...
		
		
		while(true){
			
			//ball1.move(); 
			//ball2.move();
			ball.move();
			
			board.clear();
			
			//ball1.draw(board); 
			//ball2.draw(board);
			ball.draw(board); 
			deflector.draw(board); 
			wall.draw(board);
			
			board.repaint();
			timer.pause(30);
 		}
	}

}






