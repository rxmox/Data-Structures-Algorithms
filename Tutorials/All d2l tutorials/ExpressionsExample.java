public class ExpressionsExample {
    public static void main(String[] args) {
        // Arithmetic Expressions
        int resultAddition = 10 + 5; // Addition
        System.out.println("Addition Result: " + resultAddition);
        int resultSubtraction = 15 - 3; // Subtraction
        System.out.println("Subtraction Result: " + resultSubtraction);
        int resultMultiplication = 5 * 4; // Multiplication
        System.out.println("Multiplication Result: " + resultMultiplication);
        int resultDivision = 20 / 2; // Division
        System.out.println("Division Result: " + resultDivision);
        System.out.println();

        // Relational Expressions
        int x = 3;
        int y = 2;
        boolean isEqual = (x == y); // Equality check
        System.out.println("Equality Check Result: " + isEqual);
        System.out.println();

        // Logical Expressions
        boolean a = true;
        boolean b = false;
        boolean isBothTrue = (a && b); // Logical AND
        System.out.println("Logical AND Result: " + isBothTrue);
        System.out.println();

        // Assignment Expressions
        int assignedValue = 42;
        System.out.println("Assignment Result: " + assignedValue);
        System.out.println();

        // Bitwise Expressions
        int bitwiseResult = x & y; // Bitwise AND
        System.out.println("Bitwise AND Result: " + bitwiseResult);
        System.out.println();

        // String Concatenation
        String firstName = "John";
        String lastName = "Doe";
        String fullName = firstName + " " + lastName;
        System.out.println("Full Name: " + fullName);
    }
}
