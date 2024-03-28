public class ControlFlowExample {

    public static void main(String[] args) {
        // If-Else Statement
        int num = 3;
        if (num > 0) {
            System.out.println("Number is positive.");
        } else if (num < 0) {
            System.out.println("Number is negative.");
        } else {
            System.out.println("Number is zero.");
        }
        System.out.println();

        // Switch-Case Statement
        int dayNumber = 3;
        switch (dayNumber) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid day number");
        }
        System.out.println();

        // For Loop
        int n = 5;
        System.out.println("For Loop:");
        for (int i = 1; i <= n; i++) {
            if (i == 2){
                continue;
            }
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();

        // While Loop
        int m = 4;
        System.out.println("While Loop:");
        while (m > 0) {
            System.out.print(m + " ");
            m--;
        }
        System.out.println();
        System.out.println();

        // Do-While Loop
        int x = 19;
        System.out.println("Do-While Loop:");
        do {
            if (x == 4){
                break;
            }
            System.out.print(x + " ");
            x /= 2;
        } while (x > 0);
        System.out.println();
        System.out.println();

        // Try-Catch-Finally Statement
        try {
            int divisor = 1;
            int result = 10 / divisor;
            System.out.println("Result of 10 / " + divisor + " = " + result);
        } catch (Exception e) {
            System.err.println("Error: Cannot divide by zero.");
        } finally {
            System.out.println("Finally block executed regardless of exception.");
        }
    }
}
