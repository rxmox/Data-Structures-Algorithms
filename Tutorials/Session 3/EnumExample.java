// Enum Declaration
enum Weekday {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
}

// Enum with fields and methods
enum Direction {
    NORTH("↑"), SOUTH("↓"), EAST("→"), WEST("←");

    String symbol;

    Direction(String symbol) {
        this.symbol = symbol;
    }

    String getSymbol() {
        return this.symbol;
    }
}

public class EnumExample {
    public static void main(String[] args) {
        // Enum Constants
        Weekday today = Weekday.WEDNESDAY;
        System.out.println("Today is: " + today);
        System.out.println();

        // Ordinal and compareTo Methods
        System.out.println("Ordinal of " + today + ": " + today.ordinal());
        System.out.println("Comparison with " + Weekday.MONDAY + ": " + today.compareTo(Weekday.MONDAY));
        System.out.println("Comparison with " + Weekday.WEDNESDAY + ": " + today.compareTo(Weekday.WEDNESDAY));
        System.out.println("Comparison with " + Weekday.FRIDAY + ": " + today.compareTo(Weekday.FRIDAY));
        System.out.println();

        // Enum Constructors and Methods
        Direction currentDirection = Direction.NORTH;
        System.out.println("Current Direction: " + currentDirection + " " + currentDirection.getSymbol());
    }
}
