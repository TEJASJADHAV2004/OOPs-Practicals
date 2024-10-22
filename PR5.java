import java.util.Scanner;

// Define an interface for Vehicles
interface Vehicle {
    void gearChange(int gear);
    void speedUp();
    void applyBrakes();
    void displaySpeed();
}

// Bicycle class
class Bicycle implements Vehicle {
    int speed = 0;
    int gear = 1;

    public void gearChange(int gear) {
        this.gear = gear;
        System.out.println("Bicycle gear changed to " + gear);
    }

    public void speedUp() {
        speed += 5;
        System.out.println("Bicycle speed increased to " + speed + " km/h");
    }

    public void applyBrakes() {
        speed -= 5;
        if (speed < 0) speed = 0;
        System.out.println("Bicycle speed decreased to " + speed + " km/h");
    }

    public void displaySpeed() {
        System.out.println("Bicycle current speed: " + speed + " km/h, Gear: " + gear);
    }
}

// Bike class
class Bike implements Vehicle {
    int speed = 0;
    int gear = 1;

    public void gearChange(int gear) {
        this.gear = gear;
        System.out.println("Bike gear changed to " + gear);
    }

    public void speedUp() {
        speed += 10;
        System.out.println("Bike speed increased to " + speed + " km/h");
    }

    public void applyBrakes() {
        speed -= 10;
        if (speed < 0) speed = 0;
        System.out.println("Bike speed decreased to " + speed + " km/h");
    }

    public void displaySpeed() {
        System.out.println("Bike current speed: " + speed + " km/h, Gear: " + gear);
    }
}

// Car class
class Car implements Vehicle {
    int speed = 0;
    int gear = 1;

    public void gearChange(int gear) {
        this.gear = gear;
        System.out.println("Car gear changed to " + gear);
    }

    public void speedUp() {
        speed += 20;
        System.out.println("Car speed increased to " + speed + " km/h");
    }

    public void applyBrakes() {
        speed -= 20;
        if (speed < 0) speed = 0;
        System.out.println("Car speed decreased to " + speed + " km/h");
    }

    public void displaySpeed() {
        System.out.println("Car current speed: " + speed + " km/h, Gear: " + gear);
    }
}

// Main class
public class PR5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select vehicle type (1-3):");
        System.out.println("1. Bicycle");
        System.out.println("2. Bike");
        System.out.println("3. Car");
        int choice = scanner.nextInt();

        Vehicle vehicle = null;

        switch (choice) {
            case 1:
                vehicle = new Bicycle();
                break;
            case 2:
                vehicle = new Bike();
                break;
            case 3:
                vehicle = new Car();
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        while (true) {
            System.out.println("\nSelect action (1-5):");
            System.out.println("1. Gear change");
            System.out.println("2. Speed up");
            System.out.println("3. Apply brakes");
            System.out.println("4. Display speed");
            System.out.println("5. Exit");
            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    System.out.println("Enter gear (1-5):");
                    int gear = scanner.nextInt();
                    vehicle.gearChange(gear);
                    break;
                case 2:
                    vehicle.speedUp();
                    break;
                case 3:
                    vehicle.applyBrakes();
                    break;
                case 4:
                    vehicle.displaySpeed();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid action");
                    scanner.close();
            }
        }
    }
}