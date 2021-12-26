import java.util.Scanner;
/****************************************************/
/* Adapted from CS36A - Introduction to Computer Programming Using Java
/* By Soumil Gupta
/****************************************************/

public class Triangles {
	public static void run() {
		Triangle triangle = new Triangle(1, 1.5, 1);
		triangle.setColor("yellow");
		triangle.setFilled(true);

		System.out.println(triangle);
		System.out.println("The area is " + triangle.getArea());
		System.out.println("The perimeter is " + triangle.getPerimeter());
	}
}

class GeometricObject {
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

	public String getColor() {return color;}

	public void setColor(String color) {this.color = color;}

	public boolean isFilled() {return filled;}

	public void setFilled(boolean filled) {this.filled = filled;}

	public java.util.Date getDateCreated() {return dateCreated;}

	public String toString() {
		return "Created on " + dateCreated + "\ncolor: " + color + "\nfilled: " + filled;
	}
}

class Triangle extends GeometricObject{
	double side1;
	double side2;
	double side3;

	public Triangle() {
		super();
		side1 = 1.0;
		side2 = 1.0;
		side3 = 1.0;
	}

	public Triangle(double s1, double s2, double s3) {
		super();
		side1 = s1;
		side2 = s2;
		side3 = s3;
	}
	public double getSide1() {
		return side1;
	}

	public double getSide2() {
		return side2;
	}

	public double getSide3() {
		return side3;
	}

	public java.lang.String toString() {
		return ( super.toString() +
				" , side1 : " + getSide1() +
				" , side2 : " + getSide2() +
				" , side3 : " + getSide3() );
	}

	public double getPerimeter() {
		return ( getSide1() + getSide2() + getSide3() );
	}

	public double getArea() {
        /*
            Heron's Formula for the area of a triangle
            A method for calculating the area of a triangle when you know the lengths of all three sides.

            Let a,b,c be the lengths of the sides of a triangle. The area is given by:
            Area	=	 SQRT(	 p	 (	p	−	a	) 	(	p	−	b	)	 (	p	−	c	)    )
                where p is half the perimeter, or   (a	+	b	+	c ) / 2
         */
		double p = (side1 + side2 + side3) / 2;

		return (java.lang.Math.sqrt(p * (p - side1) * (p - side2) * (p - side3)));

	}

	public static void run() {
		Triangle triangle = new Triangle(1, 1.5, 1);
		triangle.setColor("yellow");
		triangle.setFilled(true);

		System.out.println(triangle);
		System.out.println("The area is " + triangle.getArea());
		System.out.println("The perimeter is " + triangle.getPerimeter());
	}

	public static void test_main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the length of one side: ");
		double length1 = scanner.nextDouble();
		System.out.println("Please enter the length of another side: ");
		double length2 = scanner.nextDouble();
		System.out.println("Please enter the length of a third side: ");
		double length3 = scanner.nextDouble();
		Triangle t = new Triangle(length1, length2, length3);
		System.out.println ("t: " + t.toString());
		System.out.println( "Area: " + t.getArea());
		System.out.println("Perimeter: " + t.getPerimeter());
	}
}