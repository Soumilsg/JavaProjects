package jrJava.searchingAndSorting_Object;

import java.awt.Color;

public class Sorter {

	
	
	public static void insertSort(Comparable[] comparables){
		int i, j;
		Comparable temp;
		for(i=1; i<comparables.length; i++){
		temp = comparables[i];
			for(j=i-1; j>=0; j--){
				if(comparables[j].compareTo(temp)>0)  comparables[j+1] = comparables[j];
				else break;
			}
			comparables[j+1] = temp;
		}
	}
	
	
	
	
	public static void selectSort(Comparable[] comparables){
		int i, j, minIndex;
		Comparable temp;
		for(i=0; i<comparables.length-1; i++){
			minIndex = i;
			for(j=i+1; j<comparables.length; j++){
				if(comparables[j].compareTo(comparables[minIndex])<0)  minIndex = j;
			}
			temp = comparables[i];
			comparables[i] = comparables[minIndex];
			comparables[minIndex] = temp;
		}
	}
	
	
	
	public static void bubbleSort(Comparable[] comparables){
		int i;
		Comparable temp; 
		boolean sorted = false; 
		while(!sorted){ 
			sorted = true; 
			for(i=0; i<comparables.length-1; i++){
				if(comparables[i].compareTo(comparables[i+1])>0){ 
					temp = comparables[i];
					comparables[i] = comparables[i+1];
					comparables[i+1] = temp;	
					sorted = false; 
				}
			}
		}
	}
	
	
	
	private static void print(Object[] objs){
		for(int i=0; i<objs.length; i++){
			if(i%3==0) System.out.println();
			System.out.print(objs[i] + " ");
		}
		System.out.println();
	}
	
	
	
	private static Employee[] createEmployeeArray(int size){
		Employee[] emps = new Employee[size];
		for(int i=0; i<size; i++){
			emps[i] = new Employee(100+i, (int)(60000 + Math.random()*40001));
		}
		return emps;
	}
	
	
	
	public static void main(String[] args) {
		
		Square[] ss = {
			new Square(100, 150, 50, Color.red),
			new Square(200, 150, 50, Color.red),
			new Square(100, 150, 60, Color.red),
			new Square(200, 150, 60, Color.red),
			new Square(100, 150, 60, Color.blue),
			new Square(200, 150, 60, Color.blue),
			new Square(100, 150, 50, Color.blue),
			new Square(200, 150, 50, Color.blue)
		};
		
		
		print(ss);
		bubbleSort(ss);
		print(ss);
		
		
		/*
		String[] names = {"Vaikundh", "Peter", "Grant", "Jackson", "Ofek", "Chris", "Aadesh", "Roma", "Anika", "Neha", "Gaya"};
		bubbleSort(names);
		print(names);
		*/
		
		/*
		Integer[] nums = {14, 9, 5, 11, 32, 12, 32, 44, 8, 21};
		bubbleSort(nums);
		print(nums);
		*/
		
		
		/*
		Employee[] emps = createEmployeeArray(42);
		print(emps);
		insertSort(emps);
		print(emps);
		*/
	}

}













