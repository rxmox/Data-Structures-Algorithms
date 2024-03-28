import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SampleQuestion1 {

    public static void main(String[] args) {
        String inputFilePath = "input_diamond.txt";
        String outputFilePath = "output_diamond.txt";
        FileReader file_reader = null;
        BufferedReader buffered_reader = null;
        FileWriter file_writer = null;
        BufferedWriter buffered_writer = null;

        try {
            file_reader = new FileReader(inputFilePath);
            buffered_reader = new BufferedReader(file_reader);
            int n = Integer.parseInt(buffered_reader.readLine());

            file_writer = new FileWriter(outputFilePath);
            buffered_writer = new BufferedWriter(file_writer);

            int spaces = n / 2;
            int stars = 1;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= spaces; j++) {
                    buffered_writer.write(" ");
                }

                for (int j = 1; j <= stars; j++) {
                    buffered_writer.write("*");
                }

                buffered_writer.newLine();

                if (i < n / 2 + 1) {
                    spaces--;
                    stars += 2;
                } else {
                    spaces++;
                    stars -= 2;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (buffered_reader != null) {
                    buffered_reader.close();
                }
                if (file_reader != null) {
                    file_reader.close();
                }
                if (buffered_writer != null) {
                    buffered_writer.close();
                }
                if (file_writer != null) {
                    file_writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
