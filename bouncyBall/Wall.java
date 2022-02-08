package jrJava.bouncyBall;

import java.awt.Color;
import java.awt.Graphics2D;
import resources.DrawingBoard;

public class Wall {

	private int left = 50;
	private int right = 750;
	private int top = 50;
	private int bottom = 550;
	private Color color = Color.darkGray;
	
	
	
	public int getLeft(){
		return left;
	}
	
	public int getRight(){
		return right;
	}
	
	public int getTop(){
		return top;
	}
	
	public int getBottom(){
		return bottom;
	}
	
	
	
	public void draw(DrawingBoard board){
		Graphics2D canvas = board.getCanvas();
		canvas.setColor(color);
		canvas.drawRect(left, top, right-left, bottom-top); 
	}
	
}
