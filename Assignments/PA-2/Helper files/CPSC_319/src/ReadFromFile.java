// Importing necessary classes for file reading and exception handling
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Declaring a public class named ReadFromFile
public class ReadFromFile {

    // The main method, which is the entry point of the program
    public static void main(String[] args) {
        
        // Defining the file path as a string
        String filePath = "input.txt";
        
        // Initializing FileReader and BufferedReader objects to read from the file
        FileReader file_reader = null;
        BufferedReader buffered_reader = null;

        // Try block to handle potential exceptions during file reading
        try {
            // Creating a FileReader object and passing the file path to it
            file_reader = new FileReader(filePath);
            
            // Creating a BufferedReader object and passing the FileReader object to it for efficient reading
            buffered_reader = new BufferedReader(file_reader);

            // Printing a message indicating that the program is about to read content from the file
            System.out.println("Reading content from the file:");

            // Declaring a String variable to store each line read from the file
            String line;
            
            // Infinite loop to read lines from the file until there are no more lines
            while (true) {
                // Reading a line from the file
                line = buffered_reader.readLine();
                
                // Checking if the line is null, which indicates the end of the file
                if (line == null) {
                    // Breaking out of the loop if the end of the file is reached
                    break;
                }
                
                // Printing the current line to the console
                System.out.println(line);
            }

        // Catch block to handle IOException, which may occur during file reading
        } catch (IOException e) {
            // Printing the exception details if an IOException occurs
            e.printStackTrace();

        // Finally block to ensure that the resources (file reader and buffered reader) are properly closed
        } 
        
        
        finally {
            try {
                // Checking if the buffered reader is not null before attempting to close it
                if (buffered_reader != null) {
                    buffered_reader.close();
                }
                
                // Checking if the file reader is not null before attempting to close it
                if (file_reader != null) {
                    file_reader.close();
                }
                
            // Catch block to handle IOException during closing of the readers
            } catch (IOException e) {
                // Printing the exception details if an IOException occurs while closing the readers
                e.printStackTrace();
            }
        }
    }
}