/****************************************************/
/* Adapted from CS36A - Introduction to Computer Programming Using Java
/* By Soumil Gupta
/****************************************************/

public class StructureGenerator {
	public static void run() {
		GeometricObjectQ3[] geometricObjects = new GeometricObjectQ3[4];
		geometricObjects[0] = new CircleQ3(12);
		geometricObjects[1] = new CircleQ3(10);
		geometricObjects[2] = new RectangleQ3(12, 8);
		geometricObjects[3] = new RectangleQ3(15, 2);
		System.out.println("The total area is: " + sumArea(geometricObjects));
	}

  public static double sumArea(GeometricObjectQ3[] objects){
    // double[] array = new double[objects.length];
    double total = 0;
    for (int i = 0; i < objects.length; i ++) {
      total += objects[i].getArea();
    }
    return total;
  }
}

class CircleQ3 extends GeometricObjectQ3 {
  private double radius;
  public CircleQ3() {}
  public CircleQ3(double radius) {this.radius = radius;}
  public CircleQ3(double radius, String color, boolean filled) {
    this.radius = radius;
    setColor(color);
    setFilled(filled);
  }
  public double getRadius() {return radius;}
  public void setRadius(double radius) {this.radius = radius;}
  public double getArea() {return radius * radius * Math.PI;}
  public double getDiameter() {return 2 * radius;}
  public double getPerimeter() {return 2 * radius * Math.PI;}
}


class RectangleQ3 extends GeometricObjectQ3 {
  private double width;
  private double height;
  public RectangleQ3() {}
  public RectangleQ3(double width, double height) {
    this.width = width;
    this.height = height;
  }
  public RectangleQ3(double width, double height, String color, boolean filled) {
    this.width = width;
    this.height = height;
    setColor(color);
    setFilled(filled);
  }
  public double getWidth() {return width;}
  public void setWidth(double width) {this.width = width;}
  public double getHeight() {return height;}
  public void setHeight(double height) {this.height = height;}
  public double getArea() {return width * height;}
  public double getPerimeter() {return 2 * (width + height);}
}

abstract class GeometricObjectQ3 {
  private String color = "white";
  private boolean filled;
  private java.util.Date dateCreated;
  public GeometricObjectQ3() {dateCreated = new java.util.Date();}
  public GeometricObjectQ3(String color, boolean filled) {
    dateCreated = new java.util.Date();
    this.color = color;
    this.filled = filled;
  }
  public String getColor() {return color;}
  public void setColor(String color) {this.color = color;}
  public boolean isFilled() {return filled;}
  public abstract double getArea();
  public void setFilled(boolean filled) {this.filled = filled;}
  public java.util.Date getDateCreated() {return dateCreated;}
}

