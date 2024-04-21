import java.util.Scanner;

public class Question2 {

    static boolean isEven(int i){
        // Why we don't need to handle negative numbers separately? (Read about Two's Complement)
        return (i & 1) == 0;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter i: ");
        int i = scanner.nextInt();

        System.out.println(isEven(i));

        scanner.close();
    }
}
