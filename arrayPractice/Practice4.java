package jrJava.arrayPractice;


public class Practice4 {

	public static void main(String[] args) {
		
		/*
		Thing[] things = new Thing[4];
		
		things[0] = new Thing(101, 3.5);
		things[1] = new Thing(102, 2.9);
		things[2] = new Thing(103, 4.3);
		things[3] = new Thing(104, 2.5);
		*/
		
		Thing[] things = new Thing[]{new Thing(101, 3.5), new Thing(102, 2.9), new Thing(103, 4.3), new Thing(104, 2.5) };
		
		for(int i=0; i<things.length; i++){
			things[i].describe();
		}
		
	}

}










