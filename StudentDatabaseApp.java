/*Implement a program for maintaining a database of student records using Files.
Student has Student_id,name, Roll_no, Class, marks and address. Display the data for few 
students.
1. Create Database
2. Display Database 
3. Delete Records
4. Update Record
5. Search Record
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Student {
    String studentId;
    String name;
    String rollNo;
    String className;
    double marks;
    String address;

    Student(String studentId, String name, String rollNo, String className, double marks, String address) {
        this.studentId = studentId;
        this.name = name;
        this.rollNo = rollNo;
        this.className = className;
        this.marks = marks;
        this.address = address;
    }

    
    
    public String toString() {
        return "ID: " + studentId + ", Name: " + name + ", Roll No: " + rollNo + ", Class: " + className + ", Marks: " + marks + ", Address: " + address;
    }
}

class StudentDatabase {
    private final String filename;
    private List<Student> students;

    public StudentDatabase(String filename) {
        this.filename = filename;
        this.students = new ArrayList<>();
        loadStudents();
    }

    private void loadStudents() {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");                           //converts a string from the parts array into a double
                students.add(new Student(parts[0], parts[1], parts[2], parts[3], Double.parseDouble(parts[4]), parts[5]));
            }
        } catch (IOException e) {
            System.out.println("Could not load students: " + e.getMessage());
        }
    }

    private void saveStudents() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Student student : students) {
                bw.write(student.studentId + "," + student.name + "," + student.rollNo + "," + student.className + "," + student.marks + "," + student.address);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Could not save students: " + e.getMessage());
        }
    }

    public void addStudent(String studentId, String name, String rollNo, String className, double marks, String address) {
        students.add(new Student(studentId, name, rollNo, className, marks, address));
        saveStudents();
        System.out.println("Student added: " + name);
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void deleteStudent(String studentId) {
        for (Iterator<Student> iterator = students.iterator(); iterator.hasNext();) {
            Student student = iterator.next();
            if (student.studentId.equals(studentId)) {
                iterator.remove();
                saveStudents();
                System.out.println("Deleted student ID: " + studentId);
                return;
            }
        }
        System.out.println("Student ID not found: " + studentId);
    }
    public void updateStudent(String studentId, String name, String rollNo, String className, double marks, String address) {
        for (Student student : students) {
            if (student.studentId.equals(studentId)) {
                student.name = name;
                student.rollNo = rollNo;
                student.className = className;
                student.marks = marks;
                student.address = address;
                saveStudents();
                System.out.println("Updated student ID: " + studentId);
                return;
            }
        }
        System.out.println("Student ID not found: " + studentId);
    }

    public void searchStudent(String studentId) {
        for (Student student : students) {
            if (student.studentId.equals(studentId)) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student ID not found: " + studentId);
    }
}

public class StudentDatabaseApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the filename to store student records: ");
        String filename = scanner.nextLine();

        StudentDatabase db = new StudentDatabase(filename);
        int choice;

        do {
            System.out.println("\n1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Update Student");
            System.out.println("5. Search Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Roll No: ");
                    String rollNo = scanner.nextLine();
                    System.out.print("Enter Class: ");
                    String className = scanner.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    db.addStudent(studentId, name, rollNo, className, marks, address);
                    break;
                case 2:
                    db.displayStudents();
                    break;
                case 3:
                    System.out.print("Enter Student ID to delete: ");
                    String deleteId = scanner.nextLine();
                    db.deleteStudent(deleteId);
                    break;
                case 4:
                    System.out.print("Enter Student ID to update: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter new Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new Roll No: ");
                    String newRollNo = scanner.nextLine();
                    System.out.print("Enter new Class: ");
                    String newClassName = scanner.nextLine();
                    System.out.print("Enter new Marks: ");
                    double newMarks = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new Address: ");
                    String newAddress = scanner.nextLine();
                    db.updateStudent(updateId, newName, newRollNo, newClassName, newMarks, newAddress);
                    break;
                case 5:
                    System.out.print("Enter Student ID to search: ");
                    String searchId = scanner.nextLine();
                    db.searchStudent(searchId);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}