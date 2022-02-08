package jrJava.twoDimenArray;

public class Practice3 {

	public static void main(String[] args) {
		
		Employee[][] emps;
		emps = new Employee[3][];
		
		//Employee[][] emps = new Employee[3][];
		
		emps[0] = new Employee[3];
		emps[1] = new Employee[2];
		emps[2] = new Employee[4];
		
		emps[0][0] = new Employee(101, 1000000);
		emps[0][1] = new Employee(102, 500000);
		emps[0][2] = new Employee(103, 270000);
		
		emps[1][0] = new Employee(104, 150000);
		emps[1][1] = new Employee(105, 120000);
		
		emps[2][0] = new Employee(106, 80000);
		emps[2][1] = new Employee(107, 175000);
		emps[2][2] = new Employee(108, 191000);
		
		//System.out.println( emps[0][0]);
		
		emps[2][3] = new Employee(901, emps[2][2].getSalary()*2);
		
		System.out.println( emps[2][3]);
		System.out.println( emps[emps.length-1][emps[emps.length-1].length-1] );
		 	
	}

}

















