/****************************************************/
/* Adapted from CS 01B - Intermediate Software Design in Java
/* By Soumil Gupta
/****************************************************/

public class AreaComparator {
  public static void run() {
    Circle circle1 = new Circle(15);
    Circle circle2 = new Circle(20);
    if (GeometricObject.max(circle1, circle2) == 0)
    	System.out.println("The area of Circle1 is equal to the area of Circle2");
    else if(GeometricObject.max(circle1, circle2) == 1)
    	System.out.println("The area of Circle1 is greater than the area of Circle2");
    else
		System.out.println("The area of Circle1 is less than the area of Circle2");

    Rectangle rectangle1 = new Rectangle(10, 9);
    Rectangle rectangle2 = new Rectangle(12, 13);
	  if (GeometricObject.max(rectangle1, rectangle2) == 0)
		  System.out.println("The area of Rectangle1 is equal to the area of Rectangle2");
	  else if(GeometricObject.max(circle1, circle2) == 1)
		  System.out.println("The area of Rectangle1 is greater than the area of Rectangle2");
	  else
		  System.out.println("The area of Rectangle1 is less than the area of Rectangle2");

  }
}

abstract class GeometricObject implements Comparable<GeometricObject> {
	private String color = "white";
	private boolean filled;
	private java.util.Date dateCreated;

	public GeometricObject() {
		dateCreated = new java.util.Date();
	}

	public GeometricObject(String color, boolean filled) {
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public java.util.Date getDateCreated() {
		return dateCreated;
	}

	public String toString() {
		return "Created on " + dateCreated + "\ncolor: " + color + "\nfilled: " + filled;
	}

	 public static int max(GeometricObject A, GeometricObject B) {
		return (A.compareTo(B));
	}

	public abstract int compareTo(GeometricObject Obj);
	public abstract double getArea();
}

class Circle extends GeometricObject { 
	private double radius;
	public Circle() {}
	public Circle(double radius) {this.radius = radius;}
	public Circle(double radius, String color, boolean filled) {
		this.radius = radius;
		setColor(color);
		setFilled(filled);
	}
	public double getRadius() {return radius;}
	public void setRadius(double radius) {this.radius = radius;}
	public double getDiameter() {return 2*this.radius;}
	public double getArea() {return this.radius*this.radius*Math.PI;}
	public double getPerimeter() {return 2*this.radius*Math.PI;}
	public String toString() {
		return super.toString() + "\nradius: " + radius 
								+ "\ndiameter: " + getDiameter() 
								+ "\nperimeter: " + getPerimeter() 
								+ "\narea: " + getArea() ;
	}

	public int compareTo(GeometricObject Obj) {
		if (this.radius == ((Circle) Obj).radius)
			return 0;
		else if (this.radius < ((Circle) Obj).radius)
			return -1;
		else
			return 1;
	}
}

class Rectangle extends GeometricObject {
	private double width, height;
	public Rectangle() {}
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	public Rectangle(double width, double height, String color, boolean filled) {
		this.width = width;
		this.height = height;
		setColor(color);
		setFilled(filled);
	}
	public double getWidth() {return this.width;}
	public void setWidth(double width) {this.width = width;}
	public double getHeight() {return this.height;}
	public void setHeight(double height) {this.height = height;}
	public double getArea() {return this.width*this.height;}
	public double getPerimeter() {return 2*(this.width + this.height);}
	public String toString() {
		return super.toString() + "\nheight: " + height 
								+ "\nwidth: " + width
								+ "\nperimeter: " + getPerimeter() 
								+ "\narea: " + getArea() ;
	}

	public int compareTo(GeometricObject Obj) {
		if (this.getArea() == ((Rectangle) Obj).getArea())
			return 0;
		else if (this.getArea() < ((Rectangle) Obj).getArea())
			return -1;
		else
			return 1;
	}
}