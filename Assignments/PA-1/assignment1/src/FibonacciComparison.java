/*
Here's a code skeleton for the Fibonacci comparison program. Complete the missing parts aacording to the instructions provided in PA-1 specs.

(1) Fill in the `TODO` comments with *your* implementation of the respective algorithms, matrix power, matrix multiplication, and the main function to print the execution time for each algorithm.
(2) Make sure you *understand* the algorithms and implement the missing parts on *your own*.
(3) Comment every line of code, clearly describing what is going on, and the rationale for your choices.
(4) Function 'integrityCheck()' is provided.

====================================================================================

     Student's full name: Omar Ahmed

     Student's UCID: 30154382

====================================================================================
*/

// ------------------------------------------------------------------------
import java.util.Arrays;

public class FibonacciComparison
{
    // Global variable for matrix exponentiation
    private static int[][] FM;

    // Algorithm 1: Recursive definition
    public static int fibonacciRecursive(int n)
    {
        //base case that returns zero if n is 0
        if (n==0)
            return 0;
        //base case that returns one if n is 1
        else if (n==1)
            return 1;
        //recursive case which sums the previous 2 numbers in the sequence
        else
            return fibonacciRecursive(n-2) + fibonacciRecursive(n-1);
    }

    // Algorithm 2: Loop-based approach
    public static int fibonacciLoop(int n)
    {
        //base cases
        if (n <= 1) {
            return n;
        }

        // Initialize the first two Fibonacci numbers
        int first = 0; // For F0
        int second = 1; // For F1
        int fibonacci = 0; // This will store the latest Fibonacci number calculated

        // Loop from 2 to n (since we already have the first two Fibonacci numbers)
        for (int i = 2; i <= n; i++) {
            // Compute the next Fibonacci number by adding the previous two
            fibonacci = first + second;
            // Update variables for the next iteration
            // The second becomes the first and the fibonacci becomes the second for the next loop iteration
            first = second;
            second = fibonacci;
        }

        // After looping, fibonacci will hold the nth Fibonacci number
        return fibonacci;
    }

    // Algorithm 3: Matrix exponentiation
    public static int fibonacciMatrix(int n)
    {
        // If n is 0, the Fibonacci number is 0
        if (n == 0) {
            return 0;
        }
        // Initialize FM as the base matrix for the Fibonacci sequence
        FM = new int[][]{{1, 1}, {1, 0}};

        // Call matrixPower to exponentiate the matrix to the (n-1)th power
        matrixPower(n - 1);

        // Return the top left element of the matrix, which is Fn
        return FM[0][0];
    }

    // Matrix exponentiation helper function
    private static void matrixPower(int n) {
        if (n > 1) {
            // Recursively exponentiate the matrix to the power of n/2
            matrixPower(n / 2);

            // Multiply the matrix by itself (squaring it)
            matrixMultiply(FM, FM);

            // If n is odd, multiply by the base matrix once more
            if (n % 2 != 0) {
                int[][] base = {{1, 1}, {1, 0}};
                matrixMultiply(FM, base);
            }
        }
    }

    // Matrix multiplication helper function
    // maybe take matrixMultiply from tutorials
    private static void matrixMultiply(int[][] A, int[][] B) {
        int[][] temp = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                temp[i][j] = 0;
                for (int k = 0; k < 2; k++) {
                    temp[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        // Copy the temporary matrix back to A (which is FM globally)
        for (int i = 0; i < 2; i++) {
            System.arraycopy(temp[i], 0, A[i], 0, 2);
        }
    }

    // Integrity check: Ensure the matrix exponentiation result matches the recursive and loop approaches
    private static boolean integrityCheck()
    {
        for (int i = 0; i <= 31; i++)
        {
            if (fibonacciRecursive(i) != fibonacciMatrix(i) || fibonacciLoop(i) != fibonacciMatrix(i))
            {
                return false;
            }
        }
        return true;
    }

    // Enum to represent the different Fibonacci algorithms
    private enum FibonacciAlgorithm {
        RECURSIVE,
        LOOP,
        MATRIX
    }

    // Measure execution time for each algorithm
    private static long measureTime(int n, FibonacciAlgorithm algorithm)
    {
        long startTime = System.nanoTime(); // Record start time in nanoseconds
                switch (algorithm)
                {
                    case RECURSIVE:
                        fibonacciRecursive(n); // Call recursive method
                        break;
                    case LOOP:
                        fibonacciLoop(n); // Call loop-based method
                        break;
                    case MATRIX:
                        fibonacciMatrix(n); // Call matrix exponentiation method
                        break;
                }
        long elapsedTime = System.nanoTime() - startTime; // Calculate elapsed time

        return elapsedTime;
    }

    public static void main(String[] args)
    {
        // Check integrity
        if (!integrityCheck())
        {
            System.out.println("Integrity check failed. Algorithms do not match for some values of n.");
            return;
        }

        // Print header
        System.out.println("Time (in nanoseconds) to compute Fibonacci numbers:");
        System.out.println();

        // Measure and print execution time for Algorithm 1 (Recursive)
        for (int i = 0; i <= 31; i++)
        {
            long time = measureTime(i, FibonacciAlgorithm.RECURSIVE); // Pass the current index and algorithm type
            System.out.println("Time to compute F" + i + " with alg. 1: " + time);
            //System.out.println(time);
        }
        System.out.println();

        // Measure and print execution time for Algorithm 2 (Loop)
        for (int i = 0; i <= 31; i++) {
            long time = measureTime(i, FibonacciAlgorithm.LOOP); // Pass the current index and algorithm type
            System.out.println(i + " time to compute F" + i + " with alg. 2: " + time);
            //System.out.println(time);
        }

        System.out.println();

        // Measure and print execution time for Algorithm 3 (Matrix)
        for (int i = 0; i <= 31; i++) {
            long time = measureTime(i, FibonacciAlgorithm.MATRIX); // Pass the current index and algorithm type
            System.out.println(i + " time to compute F" + i + " with alg. 3: " + time);
            //System.out.println(time);
        }
    }
}
// ------------------------------------------------------------------------
