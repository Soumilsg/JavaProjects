package jrJava.twoDimenArray;

public class Practice1 {

	
	public static void main(String[] args) {
		
		int[][] a = new int[4][];
		
		a[0] = new int[]{1, 2, 3};
		a[1] = new int[]{11, 12};
		a[2] = new int[]{21, 22, 23, 24};
		a[3] = new int[]{31, 32,33, 34, 35};
		
		//for(int i=0; i<a.length; i++) System.out.println(a[i]);    
		
		//System.out.println( a[2][1] ); 
		//System.out.println( a[0][0] ); 
		//System.out.println( a[a.length-1][a[a.length-1].length-1] ); 
		
		for(int i=0; i<a.length; i++){
			// target secondary array a[i].
			for(int j=0; j<a[i].length; j++){
				System.out.print(a[i][j] + " "); 
			}
			System.out.println();
		}
		
	}

}




















