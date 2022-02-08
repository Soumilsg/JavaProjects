package jrJava.searchingAndSorting_Object;

public class BinarySearch {

	
	private static int[] values = {3, 7, 10, 11, 17, 19, 21, 22, 25, 28, 33, 35, 39, 44, 48, 57, 61, 74, 88, 89, 91, 92, 98, 99};
	
	
	public static int search(int key){
		
		int low=0, high=values.length-1, mid;
		
		while(low<=high){
			mid = (low+high)/2;
			if(values[mid]<key) low = mid+1;
			else if(values[mid]>key) high = mid-1;
			else return mid;
		}
		return -1;
	}
	
	
	
	public static void main(String[] args) {
		
		System.out.println(search(85)); 
	}

}
