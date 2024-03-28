import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DiamondPatternGenerator {

    public static void main(String[] args) {
        // Specify the paths for the input and output files
        String inputFilePath = "input_diamond.txt";
        String outputFilePath = "output_diamond.txt";

        // Read the odd positive integer n from input_diamond.txt
        int n = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFilePath))) {
            String line = bufferedReader.readLine();
            n = Integer.parseInt(line.trim());
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            System.exit(1); // Exit the program in case of an exception
        }

        // Generate and write the diamond pattern with size n to output_diamond.txt
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFilePath))) {
            // Generate the diamond pattern
            for (int i = 1; i <= n; i += 2) {
                int spaces = (n - i) / 2;
                int stars = i;

                // Print spaces
                for (int j = 0; j < spaces; j++) {
                    bufferedWriter.write(" ");
                }

                // Print stars
                for (int j = 0; j < stars; j++) {
                    bufferedWriter.write("*");
                }

                bufferedWriter.newLine();
            }

            for (int i = n - 2; i >= 1; i -= 2) {
                int spaces = (n - i) / 2;
                int stars = i;

                // Print spaces
                for (int j = 0; j < spaces; j++) {
                    bufferedWriter.write(" ");
                }

                // Print stars
                for (int j = 0; j < stars; j++) {
                    bufferedWriter.write("*");
                }

                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}