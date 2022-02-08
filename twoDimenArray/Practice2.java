package jrJava.twoDimenArray;

public class Practice2 {

	public static void main(String[] args) {
		
		int[][] a = new int[4][];
		
		a[0] = new int[]{1, 2, 3};
		//a[1] = new int[]{11, 12};
		a[2] = new int[]{21, 22, 23, 24};
		a[3] = new int[]{31, 32,33, 34, 35};

		printAll(a);
	}

	
	public static void printAll(int[][] values){
		
		if(values==null) return;
		
		int i, j;
		
		for(i=0; i<values.length; i++){
			// target secondary array values[i].
			if(values[i]==null){
				System.out.println();
				continue;
			}
			
			for(j=0; j<values[i].length; j++){
				System.out.print(values[i][j] + " "); 
			}
			System.out.println();
		}
		
	}
	
	
}








