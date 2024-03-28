public class WrapperExample {
    public static void main(String[] args) {
        // Autoboxing and Unboxing
        int primitiveInt = 42;
        Integer wrappedInt = primitiveInt; // Autoboxing
        int unwrappedInt = wrappedInt; // Unboxing
        System.out.println("Autoboxing: " + wrappedInt);
        System.out.println("Unboxing: " + unwrappedInt);
        System.out.println();

        // Common Wrapper Methods
        String intString = "123";
        int parsedInt = Integer.parseInt(intString);
        System.out.println("Parsed Integer: " + parsedInt);
        System.out.println();

        // Null Values
        Integer nullableValue = null;
        System.out.println("Nullable Value: " + nullableValue);
        System.out.println();

        // Comparisons and Equality
        Integer a = 5;
        Integer b = 5;
        System.out.println("Are a and b equal? " + a.equals(b));
        System.out.println();

        // Wrapper Constants
        System.out.println("Max Integer Value: " + Integer.MAX_VALUE);
        System.out.println("Min Integer Value: " + Integer.MIN_VALUE);
        System.out.println();
    }
}
