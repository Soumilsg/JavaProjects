package jrJava.twoDimenArray;

public class Practice5 {

	
	public static void main(String[] args) {
		
		//int[][] a = new int[][]{ new int[4], new int[2], new int[5]}; 
		
		//int[][] a = { new int[4], new int[2], new int[5]};
		
		//int[][] a = { new int[]{1, 2, 3}, new int[]{11, 12}, new int[]{21, 22, 23, 24, 25} };
		
		int[][] a = { {1, 2, 3}, {11, 12}, {21, 22, 23, 24, 25} };
		
		Employee[][] emps1 = new Employee[][]{ new Employee[3], new Employee[2] };
		
		Employee[][] emps2 = new Employee[][]{ new Employee[]{ new Employee(101, 10), new Employee(102, 11), new Employee(102, 12)}, 
			                                   new Employee[]{ new Employee(101, 10), new Employee(102, 11)} };
			                                   
		Employee[][] emps3 = { new Employee[]{ new Employee(101, 10), new Employee(102, 11), new Employee(102, 12)}, 
				               new Employee[]{ new Employee(101, 10), new Employee(102, 11)} };	 
		
		Employee[][] emps4 = { { new Employee(101, 10), new Employee(102, 11), new Employee(102, 12)}, 
	                           { new Employee(101, 10), new Employee(102, 11)} };	 
	} 

}
