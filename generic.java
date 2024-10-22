import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class generic {  // Renamed class to follow Java conventions

    // Generic method to count elements based on a property
    public static <T> int countByProperty(Collection<T> collection, Property<T> property) {
        int count = 0;
        for (T element : collection) {
            if (property.test(element)) {
                count++;
            }
        }
        return count;
    }

    // Functional interface for property testing
    public interface Property<T> {
        boolean test(T t);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input range for integers
        System.out.print("Enter how many numbers you want? ");
        int upperLimit = scanner.nextInt();

        // Sample collection of integers
        Collection<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= upperLimit; i++) {
            numbers.add(i);
        }

        // Count even numbers
        int evenCount = countByProperty(numbers, n -> n % 2 == 0);
        System.out.println("Even Numbers Count: " + evenCount);

        // Count odd numbers
        int oddCount = countByProperty(numbers, n -> n % 2 != 0);
        System.out.println("Odd Numbers Count: " + oddCount);

        // Count prime numbers
        int primeCount = countByProperty(numbers, generic::isPrime);
        System.out.println("Prime Numbers Count: " + primeCount);

        // Input for strings
        System.out.print("Enter the number of strings to check for palindromes: ");
        int stringCount = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        Collection<String> strings = new ArrayList<>();
        for (int i = 0; i < stringCount; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            strings.add(scanner.nextLine());
        }

        // Count palindromes
        int palindromeCount = countByProperty(strings, generic::isPalindrome);
        System.out.println("Palindromes Count: " + palindromeCount);

        scanner.close();
    }

    // Method to check if a number is prime
    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;  // Correctly placed return statement
    }

    // Method to check if a string is a palindrome
    private static boolean isPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}