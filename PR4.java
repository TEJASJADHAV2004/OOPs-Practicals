import java.util.Scanner;
/*Design a base class shape with two double type values and member functions to input the data 
and compute_area() for calculating area of shape. Derive two classes: triangle and rectangle. Make 
compute_area() as abstract function and redefine this function in the derived class to suit their 
requirements. Write a program that accepts dimensions of triangle rectangle  */
// Abstract base class
abstract class Shape {
    protected double dimension1;
    protected double dimension2;

    public Shape() {
        dimension1 = 0;
        dimension2 = 0;

    }

    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first dimension: ");
        dimension1 = sc.nextDouble();
        System.out.print("Enter second dimension: ");
        dimension2 = sc.nextDouble();
        sc.close();

    }

    public abstract double computeArea(); // Abstract method
}

// Derived class for Triangle
class Triangle extends Shape {
    
    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base of the triangle: ");
        dimension1 = sc.nextDouble();
        System.out.print("Enter height of the triangle: ");
        dimension2 = sc.nextDouble();
        sc.close();
    }


    public double computeArea() {
        return 0.5 * dimension1 * dimension2; // Area = 0.5 * base * height
    }
}

// Derived class for Rectangle
class Rectangle extends Shape {
    
    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of the rectangle: ");
        dimension1 = sc.nextDouble();
        System.out.print("Enter width of the rectangle: ");
        dimension2 = sc.nextDouble();
        sc.close();
    }

   
    public double computeArea() {
        return dimension1 * dimension2; // Area = length * width
    }
}

public class PR4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shape shape = null;

        System.out.println("Select the shape to calculate area:");
        System.out.println("1. Triangle");
        System.out.println("2. Rectangle");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                shape = new Triangle();
                break;
            case 2:
                shape = new Rectangle();
                break;
            default:
                System.out.println("Invalid choice.");
                System.exit(1);
        }

        shape.inputData();
        System.out.println("Area: " + shape.computeArea());
        sc.close();

    }
}