/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package akena.perfectnumberchecker;

/**
 *
 * @author DELL
 */
import java.util.Scanner;
import java.util.InputMismatchException;

public class PerfectNumberChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        
        // Part (i): Prompt user and validate input with exception handling
        while (true) {
            try {
                System.out.print("Enter a positive integer: ");
                number = scanner.nextInt();
                
                if (number <= 0) {
                    System.out.println("Please enter a positive integer greater than 0.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Clear the invalid input
            }
        }
        
        // Part (ii): Calculate sum of proper divisors
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        
        // Part (iii): Determine and display if the number is perfect
        if (sum == number) {
            System.out.println(number + " is a perfect number.");
        } else {
            System.out.println(number + " is not a perfect number.");
        }
        
        scanner.close();
    }
}