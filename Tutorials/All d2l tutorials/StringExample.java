public class StringExample {
    public static void main(String[] args) {
        // String Declaration
        String greeting = "Hello, Java!";
        System.out.println(greeting);
        System.out.println();

        // Immutability of Strings
        String originalString = "Immutable";
        String modifiedString = originalString.concat(" Example");

        System.out.println("Original String: " + originalString);
        System.out.println("Modified String: " + modifiedString);
        System.out.println();

        // String Concatenation
        String firstName = "John";
        String lastName = "Doe";
        String fullName = firstName + " " + lastName;
        System.out.println("Full Name: " + fullName);
        System.out.println();

        // String Methods
        String text = "Java Programming";
        System.out.println("Length: " + text.length());
        System.out.println("Substring: " + text.substring(6));
        System.out.println("Uppercase: " + text.toUpperCase());
        System.out.println();

        // String Comparison
        String str1 = "Hello";
        String str2 = "hello";
        System.out.println("Are str1 and str2 equal? " + str1.equals(str2));
        System.out.println();

        // Null and Empty Strings
        String nullString = null;
        String emptyString = "";
        System.out.println("Is nullString null? " + (nullString == null));
        System.out.println("Is emptyString empty? " + emptyString.isEmpty());
        System.out.println();
    }
}
