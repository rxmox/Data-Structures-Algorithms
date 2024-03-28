// Importing necessary classes for file writing, exception handling, and user input
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Declaring a public class named WriteToFile
public class WriteToFile {

    // The main method, which is the entry point of the program
    public static void main(String[] args) {
        
        // Defining the file path as a string
        String filePath = "output.txt";
        
        // Creating a Scanner object to read user input from the console
        Scanner scanner = new Scanner(System.in);
        
        // Initializing FileWriter and BufferedWriter objects to write to the file
        FileWriter file_writer = null;
        BufferedWriter buffered_writer = null;

        // Try block to handle potential exceptions during file writing
        try {
            // Creating a FileWriter object and passing the file path to it
            file_writer = new FileWriter(filePath);
            
            // Creating a BufferedWriter object and passing the FileWriter object to it for efficient writing
            buffered_writer = new BufferedWriter(file_writer);

            // Printing a message indicating that the program is about to write content into the file
            System.out.println("Writing content into the file:");

            // Declaring a String variable to store each line entered by the user
            String line;
            
            // Infinite loop to read lines from the user until the user enters "end"
            while (true) {
                // Reading a line entered by the user
                line = scanner.nextLine();
                
               // Checking if the user entered "end," which signals the end of input
                if (line.equals("end")) {
                    // Breaking out of the loop if the user enters "end"
                    break;
                }
                // Writing the line to the file
                buffered_writer.write(line);
                
                // Writing a new line to separate each user input in the file
                buffered_writer.newLine();
                buffered_writer.flush();
                
                
            }

        // Catch block to handle IOException, which may occur during file writing
        } catch (IOException e) {
            // Printing the exception details if an IOException occurs
            e.printStackTrace();

        // Finally block to ensure that the resources (file writer and buffered writer) are properly closed
        } 
        
        finally {
            try {
                // Checking if the buffered writer is not null before attempting to close it
                if (buffered_writer != null) {
                    buffered_writer.close();
                }
                
                // Checking if the file writer is not null before attempting to close it
                if (file_writer != null) {
                    file_writer.close();
                }
                
            // Catch block to handle IOException during closing of the writers
            } catch (IOException e) {
                // Printing the exception details if an IOException occurs while closing the writers
                e.printStackTrace();
            }
        }

        // Closing the scanner to release its resources
        scanner.close();
    }
}
