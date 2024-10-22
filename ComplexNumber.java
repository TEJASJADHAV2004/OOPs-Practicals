import java.util.Scanner;

class ComplexNumber {
    
    private double real;
    private double imaginary;

    //define a paramitries  Constructor
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }



    // accept  methods
    public double getR() {
        return real;
    }

//accept imaginary
    public double getI() {
        return imaginary;
    }



    // Method to add two complex numbers
    public ComplexNumber add(ComplexNumber other) {//function of adding two numbers 
        double newReal = this.real + other.real;
        double newImaginary = this.imaginary + other.imaginary;
        return new ComplexNumber(newReal, newImaginary);
    }


    
    

    // Method to multiply two complex numbers
    public ComplexNumber multiply(ComplexNumber other) {
        double newReal = this.real * other.real - this.imaginary * other.imaginary;
        double newImaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(newReal, newImaginary);
    }
    

    // print complex  number
    public void print() {
        System.out.println(real + " + " + imaginary + "i");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the real part and imaginary part of the first complex number: ");
        double real1 = scanner.nextDouble();
         double imaginary1 = scanner.nextDouble();

      
        System.out.println("Enter the real part imaginery part of the second complex number: ");
        double real2 = scanner.nextDouble();
        double imaginary2 = scanner.nextDouble();

      

        ComplexNumber num1 = new ComplexNumber(real1, imaginary1);
        ComplexNumber num2 = new ComplexNumber(real2, imaginary2);

        System.out.println("Number 1: ");
        num1.print();

        System.out.println("Number 2: ");
        num2.print();

        ComplexNumber sum = num1.add(num2);
        System.out.println("Sum: ");
        sum.print();


        ComplexNumber product = num1.multiply(num2);
        System.out.println("Product: ");
        product.print();
        scanner.close();
    }
}