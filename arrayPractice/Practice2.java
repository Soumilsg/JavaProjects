package jrJava.arrayPractice;

public class Practice2 {

	public static void main(String[] args) {
		
		int length = 5;
		
		int[] abc = new int[length];

		abc[0] = 5;  // (abc)[0] = 5;
		abc[1] = 6;
		abc[3] = -1;
		abc[length-1] = 7;  // abc[4] = 7;
		
		
		System.out.println( abc[4] ); 
		System.out.println( abc[length] );
		
		for(int i=0; i<length; i++){
			System.out.println( abc[i] );
		}
		  
		
		int[] def = new int[length+1];
		
		for(int i=0; i<length; i++) def[i] = abc[i];
		
	}

}






