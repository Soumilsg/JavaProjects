package jrJava.brickBuster_usingStatic;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import resources.DrawingBoard;

public class Deflector implements KeyListener, MouseMotionListener, MouseListener {

	private int x, y; //left, top
	private int width = 500, height = 15;
	private Color color = Color.black;
	private Wall wall;
	private int lastX;
	
			
	public Deflector(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	
	public void setWall(Wall wall){
		this.wall = wall;
	}
	
	
	public int getX(){ return x; }
	public int getY(){ return y; }
	public int getWidth(){ return width; }
	public int getHeight(){ return height; }
	
	
	
	public void draw(DrawingBoard board){
		Graphics2D canvas = board.getCanvas();
		canvas.setColor(color);
		canvas.fillRect(x, y, width, height); 
	}


	
	public void mouseDragged(MouseEvent e) {
		int currentX = e.getX();
		int dx = currentX - lastX;
		x += dx;
		lastX = currentX; 
		
		if(x<Wall.getLeft()) x = Wall.getLeft();
		else if(x>Wall.getRight()-width) x = Wall.getRight()-width;
	}


	public void mousePressed(MouseEvent e) {
		lastX = e.getX();
	}
	
	
	
	public void mouseMoved(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	

	public void keyTyped(KeyEvent e) {
		//System.out.println("I am awt-thread and in keyTyped() method.");
	}


	public void keyPressed(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		if(keyCode==KeyEvent.VK_LEFT) x = x - 10;
		else if(keyCode==KeyEvent.VK_RIGHT) x = x + 10;
		
		if(x<Wall.getLeft()) x = Wall.getLeft();
		else if(x>Wall.getRight()-width) x = Wall.getRight()-width;
		
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			x = Wall.getLeft();
			width = Wall.getRight() - Wall.getLeft();
		}
		
		//char typed = e.getKeyChar();
		//System.out.println(typed);
		
		//System.out.println("I am awt-thread and in keyPressed() method.");
	}


	public void keyReleased(KeyEvent e) {
		//System.out.println("I am awt-thread and in keyReleased() method.");
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			x = (Wall.getLeft() + Wall.getRight())/2;
			width = 100;
		}
	}
	
	
	
	

}











