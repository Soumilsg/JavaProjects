package jrJava.searchingAndSorting_Object;

public class ObjectSearch {

	private static Employee[] employees;
	
	
	public static int search(int salary){
		
		int low=0, high=employees.length-1;
		int mid;
		
		int trials = 0;
		
		while(low<=high){
			
			trials++;
			System.out.println("trials="+trials); 
			
			mid = (low+high)/2;
			if(salary>employees[mid].getSalary()) low = mid+1;
			else if(salary<employees[mid].getSalary())high = mid-1;
			else return mid;
		}
		return -1;
	}
	
	
	
	public static void createEmployees(int size){
		employees = new Employee[size];
		for(int i=0; i<size; i++){
			employees[i] = new Employee(101+i, 100000 + 500*i);
		}
	}
	
	
	public static void print(){
		for(int i=0; i<employees.length; i++){
			if(i%10==0) System.out.println();
			System.out.print(employees[i].toString() + " ");
		}
	}
	
	
	public static void main(String[] args) {
		createEmployees(1000);
		print();
		
		System.out.println();
		int index = search(597000);
		System.out.println(employees[index].toString());
		
	}

}









