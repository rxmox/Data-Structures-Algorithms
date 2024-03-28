// Importing the Scanner class from the java.util package
import java.util.Scanner;

public class InputOutputExample {
    public static void main(String[] args) {
        // Creating a Scanner object named 'scanner' to handle input from the console (System.in)
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter an int value
        System.out.print("Enter int value: ");
        // Read the entered value as an int using the nextInt() method of the Scanner
        int intValue = scanner.nextInt();
        // Display the obtained int value to the console
        System.out.println("Int: " + intValue);
        System.out.println();

        // Prompt the user to enter a double value
        System.out.print("Enter double value: ");
        // Read the entered value as a double using the nextDouble() method of the Scanner
        double doubleValue = scanner.nextDouble();
        // Display the obtained double value to the console
        System.out.println("Double: " + doubleValue);
        System.out.println();

        // Prompt the user to enter a string value
        System.out.print("Enter string value: ");
        // Read the entered value as a string using the next() method of the Scanner (nextLine() read the whole line)
        String stringValue = scanner.next();
        // Display the obtained string value to the console
        System.out.println("String: " + stringValue);
        System.out.println();

        // Closing the Scanner to release system resources
        scanner.close();
    }
}
