public class HelloWorld {

    public static void main(String[] args) {
        // Different Data Types
        byte myByte = 127;
        short myShort = 32000;
        int myInt = 2147483647;
        long myLong = 9223372036854775807L;
        float myFloat = 3.14f;
        double myDouble = 2.71828;
        char myChar = 'A';
        boolean myBoolean = true;
        String myString = "Hello, Java!";

        // Printing Data
        System.out.println("Byte: " + myByte);
        System.out.println("Short: " + myShort);
        System.out.println("Int: " + myInt);
        System.out.println("Long: " + myLong);
        System.out.println("Float: " + myFloat);
        System.out.println("Double: " + myDouble);
        System.out.println("Char: " + myChar);
        System.out.println("Boolean: " + myBoolean);
        System.out.println("String: " + myString);
        System.out.println();


        // For Loop
        System.out.println("Using a For Loop:");

        // Print numbers from 1 to 5
        for (int i = 1; i <= 5; i++) {
            System.out.println("Number: " + i);
        }
        System.out.println();


        // Array
        System.out.println("Using an Array:");

        // Declare and initialize an array of integers
        int[] numbers = {10, 20, 30, 40, 50};

        // Print elements of the array
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Element at index " + i + ": " + numbers[i]);
        }
    }

}
