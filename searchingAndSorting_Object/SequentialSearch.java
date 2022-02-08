package jrJava.searchingAndSorting_Object;

public class SequentialSearch {

	
	private static int[] values = {45, 11, 9, 27, 81, 90, 65, 10, 2, 19, 22, 79, 95, 8, 70, 56, 17, 66, 34, 39, 20};
	
	
	public static int search(int key){
		
		for(int i=0; i<values.length; i++){
			if(values[i]==key) return i;
		}
		return -1;
		
	}
	
	
	
	public static void main(String[] args) {
		
		System.out.println(search(12));
	}

}
