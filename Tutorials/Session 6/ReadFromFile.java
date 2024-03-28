import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {

    public static void main(String[] args) {
        String filePath = "input.txt";
        FileReader file_reader = null;
        BufferedReader buffered_reader = null;

        //if try doesn't work, catch will handle the exception
        try {
            file_reader = new FileReader(filePath);
            buffered_reader = new BufferedReader(file_reader);

            System.out.println("Reading content from the file:");

            String line;
            while(true){
                line = buffered_reader.readLine();
                if(line == null){
                    break;
                }
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if (buffered_reader != null) {
                    buffered_reader.close();
                }
                if (file_reader != null) {
                    file_reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
