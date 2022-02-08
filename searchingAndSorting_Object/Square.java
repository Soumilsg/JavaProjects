package jrJava.searchingAndSorting_Object;

import java.awt.Color;

public class Square implements Comparable {

	private int x, y;
	private int side;
	private Color color;
	
	public Square(int x, int y, int side, Color color){
		this.x = x;
		this.y = y;
		this.side = side;
		this.color = color;
	}
	
	public String toString(){
		return "[" + color + ", " + side + ", " + x + "]";
	}
	
	
	public int compareTo(Object obj){
		Square o = (Square) obj;
		if(color.getRed()>o.color.getRed()) return 1;
		else if(color.getRed()<o.color.getRed()) return -1;
		else {
			if(side>o.side) return 1;
			else if(side<o.side) return -1;
			else {
				if(x>o.x) return 1;
				else if(x<o.x) return -1;
				else return 0;
			}
		}
	}
	
}











