package jrJava.alienInvaderWithImages_polymorphism;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;

import resources.DrawingBoard;
import resources.SoundPlayer;

public class Ship implements MouseListener, MouseMotionListener, KeyListener {

	private int x, y; // center, top
	private static int topWidth = 4;
	private static int middleWidth = 20;
	private static int bottomWidth = 60;
	private static int height = 20;
	private Image image;
	
	private int lastX;
	private SoundPlayer laser;
	
	
	public Ship(int x, int y){
		this.x = x;
		this.y = y;
		
		//ImageIcon icon = new ImageIcon(Coordinator.RESOURCE_PATH + "ship.png");
		//image = icon.getImage();
		
		image = new ImageIcon(Coordinator.RESOURCE_PATH + "ship.png").getImage();
		bottomWidth = image.getWidth(null);
		
		laser = new SoundPlayer(Coordinator.RESOURCE_PATH + "laser.wav");
	}
	
	
	public int getX(){ return x; }
	
	
	public boolean isHit(Missile missile){
		int eX = missile.getX();
		int eY = missile.getY();
		int eW = Missile.getWidth();
		int eH = Missile.getHeight();
		
		if(eX>x-topWidth/2-eW/2 && eX<x+topWidth/2+eW/2 && eY>y && eY<y+height+eH ||
		   eX>x-middleWidth/2-eW/2 && eX<x+middleWidth/2+eW/2 && eY>y+height && eY<y+2*height+eH ||	
		   eX>x-bottomWidth/2-eW/2 && eX<x+bottomWidth/2+eW/2 && eY>y+2*height && eY<y+3*height+eH ){
			return true;
		}
		return false;
	}
	
	
	public boolean isHit(Alien alien){
		int eX = alien.getX();
		int eY = alien.getY();
		int eW = alien.getWidth();
		int eH = alien.getHeight();
		
		if(eX>x-topWidth/2-eW/2 && eX<x+topWidth/2+eW/2 && eY>y && eY<y+height+eH ||
		   eX>x-middleWidth/2-eW/2 && eX<x+middleWidth/2+eW/2 && eY>y+height && eY<y+2*height+eH ||	
		   eX>x-bottomWidth/2-eW/2 && eX<x+bottomWidth/2+eW/2 && eY>y+2*height && eY<y+3*height+eH ){
			return true;
		}
		return false;
	}
	
	public void draw(DrawingBoard board){
		Graphics2D canvas = board.getCanvas();
		canvas.drawImage(image, x-bottomWidth/2, y, null);
	}


	public void mousePressed(MouseEvent e) {
		//System.out.println("pressed");
		lastX = e.getX();
	}
	
	
	public void mouseDragged(MouseEvent e) {
		int mx = e.getX();
		int dx = mx - lastX;
		x += dx;
		
		//System.out.println("dragged and ship's x=" + x);
		lastX = mx;
	}
	
	
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if(keyCode==KeyEvent.VK_LEFT) x = x - 10;
		else if(keyCode==KeyEvent.VK_RIGHT) x = x + 10;
		
		if(keyCode==KeyEvent.VK_SPACE){
			 TorpedoManager.add( new Torpedo(x, y-12, -7) );
			 laser.play();
		}
	}
	
	
	public void mouseMoved(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	
}

















