package jrJava.twoDimenArray;

public class Practice4 {

	public static void main(String[] args) {
		
		int[][] a = new int[4][3];
		
		for(int i=0; i<a.length; i++) System.out.println(a[i]); 
		
		a[1][2] = 123;
		a[2][0] = a[1][2]*10;
		System.out.println(a[2][0]);
		
		
		Employee[][] emps = new Employee[4][3];
		
		emps[0][0] = new Employee(101, 1000000);
		emps[emps.length-1][emps[emps.length-1].length-1] = new Employee(211, emps[0][0].getSalary()/2);
		
		System.out.println(emps[3][2]);
	}

}
