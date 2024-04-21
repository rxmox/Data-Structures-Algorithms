import java.util.Scanner;

public class Question16 {

    static int coverGrid(int n){
        if(n < 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        return coverGrid(n-1) + (2 * coverGrid(n-2));
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter n: ");
        int n = scanner.nextInt();

        System.out.println(coverGrid(n));

        scanner.close();
    }
}
