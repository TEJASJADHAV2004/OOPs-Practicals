import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private double dailyWithdrawalLimit;
    private double dailyWithdrawnAmount;

    public BankAccount(String accountNumber, String accountHolderName, double dailyWithdrawalLimit) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = 0.0;
        this.dailyWithdrawalLimit = dailyWithdrawalLimit;
        this.dailyWithdrawnAmount = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return;
        }

        if (dailyWithdrawnAmount + amount > dailyWithdrawalLimit) {
            System.out.println("Daily withdrawal limit exceeded.");
            return;
        }

        balance -= amount;
        dailyWithdrawnAmount += amount;
        System.out.println("Withdrawn: $" + amount);
    }

    public double getBalance() {
        return balance;
    }

    public void displayAccountInfo() {
        System.out.println("\nAccount Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Current Balance: $" + balance);
        System.out.println("Daily Withdrawal Limit: $" + dailyWithdrawalLimit);
        System.out.println("Total Withdrawn Today: $" + dailyWithdrawnAmount);
    }

    public void resetDailyWithdrawal() {
        dailyWithdrawnAmount = 0.0; // Call this method at the beginning of a new day
    }
}

public class BankingS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = null;

        while (true) {
            System.out.println("\nBanking System Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account Information");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    String accountNumber = scanner.next();
                    System.out.print("Enter Account Holder Name: ");
                    String accountHolderName = scanner.next();
                    System.out.print("Enter Daily Withdrawal Limit: ");
                    double dailyWithdrawalLimit = scanner.nextDouble();
                    account = new BankAccount(accountNumber, accountHolderName, dailyWithdrawalLimit);
                    System.out.println("Account created successfully!");
                    break;
                case 2:
                    if (account == null) {
                        System.out.println("Please create an account first.");
                    } else {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    }
                    break;
                case 3:
                    if (account == null) {
                        System.out.println("Please create an account first.");
                    } else {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                    }
                    break;
                case 4:
                    if (account == null) {
                        System.out.println("Please create an account first.");
                    } else {
                        System.out.println("Current Balance: $" + account.getBalance());
                    }
                    break;
                case 5:
                    if (account == null) {
                        System.out.println("Please create an account first.");
                    } else {
                        account.displayAccountInfo();
                    }
                    break;
                case 6:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}