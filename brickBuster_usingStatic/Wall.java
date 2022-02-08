package jrJava.brickBuster_usingStatic;

import java.awt.Color;
import java.awt.Graphics2D;

import resources.DrawingBoard;

public class Wall {

	private static int left = 20;
	private static int right = 520;
	private static int top = 20;
	private static int bottom = 630;
	private static Color color = Color.gray;
	
	
	public Wall(){ }
	
	
	public static int getLeft(){ return left; }
	public static int getRight(){ return right; }
	public static int getTop(){ return top;	}
	
	
	public void draw(DrawingBoard board){
		Graphics2D canvas = board.getCanvas();
		canvas.setColor(color);
		canvas.drawLine(left, top, right, top);
		canvas.drawLine(left, top, left, bottom);
		canvas.drawLine(right, top, right, bottom);
	}
	
}
 