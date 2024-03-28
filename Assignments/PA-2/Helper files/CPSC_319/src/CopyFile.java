import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFile {

    public static void main(String[] args) {
        // Specify the paths for the source and destination files
        String sourceFilePath = "input.txt";
        String destinationFilePath = "destination.txt";

        // Declare FileReader, BufferedReader, FileWriter, and BufferedWriter
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            // Initialize FileReader and BufferedReader for the source file
            fileReader = new FileReader(sourceFilePath);
            bufferedReader = new BufferedReader(fileReader);

            // Initialize FileWriter and BufferedWriter for the destination file
            fileWriter = new FileWriter(destinationFilePath);
            bufferedWriter = new BufferedWriter(fileWriter);

            System.out.println("Copying content from " + sourceFilePath + " to " + destinationFilePath + ":");

            // Read each line from the source file and write it to the destination file
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

            System.out.println("Content copied successfully.");

        } catch (IOException e) {
            // Handle IO exceptions
            e.printStackTrace();

        } finally {
            try {
                // Close resources in the reverse order of initialization
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
