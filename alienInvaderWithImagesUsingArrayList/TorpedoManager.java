package jrJava.alienInvaderWithImagesUsingArrayList;

import java.util.ArrayList;
import resources.DrawingBoard;

public class TorpedoManager {

	
	private static ArrayList<Torpedo> torpedoes; 
	
	
	static {
		torpedoes = new ArrayList<Torpedo>();
	}
	
	
	public static void draw(DrawingBoard board){
		for(int i=0; i<torpedoes.size(); i++){
			torpedoes.get(i).draw(board);
		}
	}
	
	
	public static void move(){
		
		//walk backward
		for(int i=torpedoes.size()-1; i>=0; i--){
			torpedoes.get(i).move();
			if(torpedoes.get(i).getY()<0){
				remove(i);
			}
		}
	
	}
	
	
	public static void add(Torpedo torpedo){
		torpedoes.add(torpedo);
	}
	
	
	public static void remove(int index){
		torpedoes.remove(index);
	}
	

	public static void remove(Torpedo torpedo){
		torpedoes.remove(torpedo);
	}
	
}
















