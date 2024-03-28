import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class PrimeFactorGrouping {
	public static void main(String[] args) {
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";
        
        FileReader file_reader = null;
        BufferedReader buffered_reader = null;
        FileWriter file_writer = null;
        BufferedWriter buffered_writer = null;

        int max_prime = 1000 + 10;

        LinkedList<Integer>[] my_linkedlist = new LinkedList[max_prime];

        for (int i = 0; i < max_prime; i++) {
            my_linkedlist[i] = new LinkedList<Integer>();
        }

        try {
            file_reader = new FileReader(inputFilePath);
            buffered_reader = new BufferedReader(file_reader);

            while(true){
                String line = buffered_reader.readLine();
                if(line == null){
                    break;
                }
                int n = Integer.parseInt(line);
                
                
                for(int i = 2; i <= n; i++){
                    if(n % i == 0){
                        my_linkedlist[i].add(n);
                        break;
                    }
                }
            }

            file_writer = new FileWriter(outputFilePath);
            buffered_writer = new BufferedWriter(file_writer);

            for (int i = 0; i < max_prime; i++) {
                if(my_linkedlist[i].size() > 0){
                    while(my_linkedlist[i].size() > 0){
                        buffered_writer.write(my_linkedlist[i].pollFirst() + " ");
                    }
                    buffered_writer.newLine();
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
