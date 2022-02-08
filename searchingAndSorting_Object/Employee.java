package jrJava.searchingAndSorting_Object;


public class Employee implements Comparable {

	private int id;
	private int salary;
	
	
	public Employee(int id, int salary){
		this.id = id;
		this.salary = salary;
	}
	
	public int getId(){ return id; }
	public int getSalary(){ return salary; }

	
	public String toString(){
		return "[" + id + ", " + salary + "]";
	}

	
	public int compareTo(Object obj){
		Employee o = (Employee) obj;
		if(salary>o.salary) return 1;
		else if(salary<o.salary) return -1;
		else return 0;
	}
	
}
















