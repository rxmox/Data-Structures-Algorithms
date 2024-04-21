import java.util.Scanner;

public class Question15 {

    static int coverGrid(int n){
        if(n < 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        return coverGrid(n-2) + coverGrid(n-3);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter n: ");
        int n = scanner.nextInt();

        System.out.println(coverGrid(n));

        scanner.close();
    }
}
