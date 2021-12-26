import java.util.Scanner;

/****************************************************/
/* Adapted from CS 01B - Intermediate Software Design in Java
/* By Soumil Gupta
/****************************************************/

public class ShapeOverlapDetector {
  public static void run() {
    Circle2D c1 = new Circle2D(2, 2, 5.5);
    System.out.println("Area is " + c1.getArea());
    System.out.println("Perimeter is " + c1.getPerimeter());
    System.out.println(c1.contains(3, 3));
    System.out.println(c1.contains(new Circle2D(4, 5, 10.5)));
    System.out.println(c1.overlaps(new Circle2D(3, 5, 2.3)));
  }
}

class Circle2D {

  double x;
  double y;
  double radius;

  public double getRadius(){
    return radius;
  }
  public Circle2D(){
    x = 0;
    y = 0;
    radius = 1;
  }
  public Circle2D(double x, double y, double radius){
    this.x = x;
    this.y = y;
    this.radius = radius;
  }

  public double getArea(){
    double area = Math.PI * Math.pow(radius, 2);
    return area;
  }

  public double getPerimeter(){
    double perimeter = 2 * Math.PI * radius;
    return perimeter;
  }

  public boolean contains(double x1, double y1){
    if((Math.sqrt(Math.pow(x1-x, 2.0) + Math.pow(y1-y, 2.0)) < getRadius())) {
      return true;
    }
    else {
      return false;
    }
  }
  public boolean contains (Circle2D circle){
    // A circle A contains another circle B if
    // radius A > radius B + (distance between centers of A and B)
    double centerDist = Math.sqrt( Math.pow((circle.y - y), 2.0) + Math.pow((circle.x - x), 2.0) );
    return (radius > (circle.getRadius() + centerDist));
  }

  public boolean overlaps (Circle2D circle){
    // A circle A overlaps another circle B if
    // (distance between centers of A and B) < radius A + radius B
    // and B is not contained in A
    double centerDist = Math.sqrt(Math.pow((circle.y - y), 2.0) + Math.pow((circle.x - x), 2.0));
    return (!(contains(circle)) &&
            (centerDist < radius + circle.getRadius()));
  }

  public static void test_main(String[] args) {

    Circle2D c1 = new Circle2D(2, 2, 5.5);
    System.out.println("Area is " + c1.getArea());
    System.out.println("Perimeter is " + c1.getPerimeter());
    System.out.println(c1.contains(3, 3));
    System.out.println(c1.contains(new Circle2D(4, 5, 10.5)));
    System.out.println(c1.overlaps(new Circle2D(3, 5, 2.3)));

    // Additional Tests Below

    Circle2D CircleA = new Circle2D(0, 0, 1);
    System.out.println ("Created Circle A with center ( " + 0 + "," + 0 + " ) , radius:  " + 1);
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please enter a X-coordinate for your circle: ");
    double xCoordinate = scanner.nextDouble();
    System.out.println("Please enter a Y-coordinate for your circle: ");
    double yCoordinate = scanner.nextDouble();
    System.out.println("Please enter a Radius for your circle: ");
    double radius = scanner.nextDouble();
    Circle2D CircleB = new Circle2D(xCoordinate, yCoordinate, radius);

    System.out.println ("Created Circle B with center ( " + xCoordinate + "," + yCoordinate + " ) , radius:  " + radius);
    System.out.println("Area: " + CircleB.getArea());
    System.out.println("Perimeter: " + CircleB.getPerimeter());

    boolean containsCenter = CircleB.contains(0, 0);
    if(containsCenter == true){
      System.out.println("The circle A with radius 1 has its center within your circle");
    }
    else{
      System.out.println("the circle A with radius 1 does NOT have its center within your circle");
    }

    boolean containsCircle = CircleB.contains(CircleA);
    if(containsCircle == true){
      System.out.println("Your circle B contains the circle A with radius 1");
    }
    else{
      System.out.println("Your circle B does NOT contain the circle A with radius 1");
    }
    boolean overlapsCircle = CircleB.overlaps(CircleA);
    if(overlapsCircle == true){
      System.out.println("Your circle B overlaps with the circle A with radius 1");
    }
    else{
      System.out.println("Your circle B does NOT overlap with the circle A with radius 1");
    }
  }
}
