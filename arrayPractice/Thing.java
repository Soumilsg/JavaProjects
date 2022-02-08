package jrJava.arrayPractice;

public class Thing {

	private int id;
	private double grade;
	
	public Thing(int id, double grade){
		this.id = id;
		this.grade = grade;
	}
	
	public void describe(){
		System.out.println("id=" + id + "   grade=" + grade); 
	}
}

