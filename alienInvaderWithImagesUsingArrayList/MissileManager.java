package jrJava.alienInvaderWithImagesUsingArrayList;

import java.util.ArrayList;

import resources.DrawingBoard;


public class MissileManager {

	
	private static ArrayList<Missile> missiles; 
	
	static {
		missiles = new ArrayList<Missile>();
	}
	
	
	public static void draw(DrawingBoard board){
		for(int i=0; i<missiles.size(); i++){
			missiles.get(i).draw(board);
		}
	}
	
	
	public static boolean isHit(Torpedo torpedo){
		for(int i=0; i<missiles.size(); i++){
			if(missiles.get(i).isHit(torpedo)){
				return true;
			}
		}
		return false;
	}
	
	
	
	public static void move(Ship ship){
		
		//walk backward
		for(int i=missiles.size()-1; i>=0; i--){
			missiles.get(i).move(ship);
			if(missiles.get(i).getY()>Coordinator.SCREEN_HEIGHT){
				remove(i);
			}
		}
	}
	
	
	public static void add(Missile missile){
		missiles.add(missile);
	}
	
	
	public static void remove(int index){
		missiles.remove(index);
	}
	

	public static void remove(Missile missile){
		missiles.remove(missile);
	}
	
	
}





