package jrJava.bouncyBall;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.xml.soap.SOAPPart;

import resources.DrawingBoard;
import resources.SoundPlayer;

public class Ball {

	private int x; // center
	private int y; // center
	private int vx;
	private int vy;
	private int radius = 99;
	private Wall wall;
	
	private SoundPlayer sound;
	private Image image;
	

	public Ball(String imageFileName){
		sound = new SoundPlayer("jrJava/bouncyBall/boing.wav");
		ImageIcon icon = new ImageIcon("jrJava/bouncyBall/" + imageFileName);
		image = icon.getImage();
		radius = image.getWidth(null)/2;
	}
	
	
	public void setWall(Wall _wall){
		wall = _wall;
	}
	
	
	
	public int getRadius(){
		return radius;
	}
	
	
	
	public void setX(int _x){
		x = _x;
	}
	
	public void setPosition(int _x, int _y){
		x = _x;
		y = _y;
	}
	
	public void setAll(int _x, int _y, int _vx, int _vy){
		x = _x;
		y = _y;
		vx = _vx;
		vy = _vy;
	}
	
	
	
	public void move(){
		x = x + vx;
		y = y + vy;
		
		if(x<=wall.getLeft()+radius){
			x = wall.getLeft() + radius;
			vx = -vx;
			sound.play();
		}
		else if(x>=wall.getRight()-radius){
			x = wall.getRight()-radius;
			vx = -vx;
			sound.play();
		}
		
		if(y<=wall.getTop()+radius){
			y = wall.getTop()+radius;
			vy = -vy;
			sound.play();
		}
		else if(y>=wall.getBottom()-radius){
			y = wall.getBottom()-radius;
			vy = -vy;
			sound.play();
		}
		
	}

	
	
	public void grow(){
		radius++;
		if(radius>150) radius = 150;
	}
	
	public void shrink(){
		radius--;
		if(radius<5) radius = 5;
	}
	
	
	public void draw(DrawingBoard board){
		Graphics2D canvas = board.getCanvas();
		canvas.drawImage(image, x-radius, y-radius, board);
		
	}
}

















