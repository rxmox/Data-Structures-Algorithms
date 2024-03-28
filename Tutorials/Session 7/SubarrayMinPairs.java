import java.util.Scanner;

//idk what's going on here

public class SubarrayMinPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading the size of the array
        int n = scanner.nextInt();
        int[] array = new int[n];

        // Reading each element of the array
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // Finding the global minimum in the array
        int globalMin = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (array[i] < globalMin) {
                globalMin = array[i];
            }
        }

        // Counting valid pairs
        long count = 0; // Use long to avoid overflow on large inputs
        long consecutiveMinCount = 0; // Counts consecutive appearances of the global minimum
        for (int i = 0; i < n; i++) {
            if (array[i] == globalMin) {
                consecutiveMinCount++; // Increment for each global minimum found
            } else {
                // Add to count the total pairs for the segment of consecutive minimums
                count += (consecutiveMinCount * (consecutiveMinCount + 1)) / 2;
                consecutiveMinCount = 0; // Reset for the next segment
            }
        }
        // Ensure to add the last segment of consecutive minimums if it ends at the array's end
        count += (consecutiveMinCount * (consecutiveMinCount + 1)) / 2;

        // Printing the result
        System.out.println(count);
    }
}

