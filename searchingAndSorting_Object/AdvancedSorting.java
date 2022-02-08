package jrJava.searchingAndSorting_Object;

public class AdvancedSorting {

	

	public static void selectSort(int[] values){
	
		int i, j, minIndex, temp;
		for(i=0; i<values.length-1; i++){
		
			minIndex = i;
			for(j=i+1; j<values.length; j++){
				if(values[j]%2<values[minIndex]%2 || values[j]%2==values[minIndex]%2 && values[j]<values[minIndex])  minIndex = j;
			}
		
			temp = values[i];
			values[i] = values[minIndex];
			values[minIndex] = temp;
		}
		
	}
	
	
	
	
	public static void bubbleSort(int[] values){
		int i, temp; 
		boolean sorted = false; 
		while(!sorted){ 
			sorted = true; 
			for(i=0; i<values.length-1; i++){
				if(values[i]%2>values[i+1]%2 || values[i]%2==values[i+1]%2 && values[i]>values[i+1]){ 
					temp = values[i];
					values[i] = values[i+1];
					values[i+1] = temp;	
					sorted = false;  
				}
			}
		}
	}
	

	private static void print(int[] values){
		for(int i=0; i<values.length; i++) System.out.print(values[i] + " ");
		System.out.println();
	}
	
	
	private static int[] createIntArray(int size){
		int[] values = new int[size];
		for(int i=0; i<values.length; i++){
			values[i] = (int)(Math.random()*size/2);
		}
		return values;
	}
	
	
	public static void main(String[] args) {
		int[] a = createIntArray(40);
		print(a);
		selectSort(a);
		print(a);
	}

}
