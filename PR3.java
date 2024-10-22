import java.util.*;

// Base class
class Employee {
    String Emp_name;
    String Emp_id;
    String Address;
    String Mail_id;
    String Mobile_no;
   public Employee(String Emp_name, String Emp_id, String Address, String Mail_id, String Mobile_no) {
        this.Emp_name = Emp_name;
        this.Emp_id = Emp_id;
        this.Address = Address;
        this.Mail_id = Mail_id;
        this.Mobile_no = Mobile_no;
    }
}

// Derived classes
class Staff extends Employee {
    double BP;
    double DA;
    double HRA;
    double PF;
    double Staff_club_fund;

    Staff(String Emp_name, String Emp_id, String Address, String Mail_id, String Mobile_no, double BP) {
        super(Emp_name, Emp_id, Address, Mail_id, Mobile_no);
        this.BP = BP;
        this.DA = 0.97 * BP;
        this.HRA = 0.10 * BP;
        this.PF = 0.12 * BP;
        this.Staff_club_fund = 0.001 * BP;
    }

    void generatePaySlip() {
        double Gross_salary = BP + DA + HRA;
        double Net_salary = Gross_salary - PF - Staff_club_fund;
        System.out.println("Pay Slip:\nName: " + Emp_name + "\nGross Salary: " + Gross_salary + "\nNet Salary: " + Net_salary);
    }
}

class Programmer extends Staff {
    Programmer(String Emp_name, String Emp_id, String Address, String Mail_id, String Mobile_no, double BP) {
        super(Emp_name, Emp_id, Address, Mail_id, Mobile_no, BP);
    }
}

class TeamLead extends Programmer {
    TeamLead(String Emp_name, String Emp_id, String Address, String Mail_id, String Mobile_no, double BP) {
        super(Emp_name, Emp_id, Address, Mail_id, Mobile_no, BP);
    }
}

class AssistantProjectManager extends TeamLead {
    AssistantProjectManager(String Emp_name, String Emp_id, String Address, String Mail_id, String Mobile_no, double BP) {
        super(Emp_name, Emp_id, Address, Mail_id, Mobile_no, BP);
    }
}

class ProjectManager extends AssistantProjectManager {
    ProjectManager(String Emp_name, String Emp_id, String Address, String Mail_id, String Mobile_no, double BP) {
        super(Emp_name, Emp_id, Address, Mail_id, Mobile_no, BP);
    }
}

//main class
public class PR3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Employee Name:");//accept employ name
        String Emp_name = scanner.nextLine();//accept employ name

        System.out.println("Enter Employee ID:");
        String Emp_id = scanner.nextLine();//accept  employ id

        System.out.println("Enter Address:");
        String Address = scanner.nextLine();//accept employ address

        System.out.println("Enter Mail ID:");
        String Mail_id = scanner.nextLine();//accept mail id

        System.out.println("Enter Mobile Number:");
        String Mobile_no = scanner.nextLine();//accept mobile number

        System.out.println("Enter Basic Pay:");
        double BP = scanner.nextDouble();//accept bp 

        Programmer programmer = new Programmer(Emp_name, Emp_id, Address, Mail_id, Mobile_no, BP);
        programmer.generatePaySlip();//call the method gps to count the net_salary and gross salary
        scanner.close();
        
    }
}