package jrJava.arrayPractice;

public class Practice3 {

	public static void main(String[] args) {
		
		//int[] abc = new int[5];
		//abc[0] = 5;
		//abc[1] = 0;
		//abc[2] = -2;
		
		int[] aaa = {5, 0, -1, 7, 3, 11, 8};
		
		// The following will not work.
		//int[] aaa;
		//aaa = {5, 0, -1, 7, 3};

		int[] bbb = new int[]{5, 0, -1, 7, 3, -9, 101};
		
		int[] ccc;
		ccc = new int[]{5, 0, -1, 7, 3};
		
		//System.out.println(aaa.length);
		//System.out.println(bbb.length);
		//System.out.println(ccc.length);
		
		for(int i=0; i<aaa.length; i++){
			System.out.println(aaa[i]);
		}
		
		
		
		
	}

}













