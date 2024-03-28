import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteToFile {

    public static void main(String[] args) {
        String filePath = "output.txt";
        Scanner scanner = new Scanner(System.in);
        FileWriter file_writer = null;
        BufferedWriter buffered_writer = null;

        try {
            file_writer = new FileWriter(filePath);
            buffered_writer = new BufferedWriter(file_writer);

            System.out.println("Writing content into the file:");

            String line;
            while(true){
                line = scanner.nextLine();
                if(line.equals("end")){
                    break;
                }
                buffered_writer.write(line);
                buffered_writer.newLine();
                buffered_writer.flush();
                
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
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

        scanner.close();
    }
}
