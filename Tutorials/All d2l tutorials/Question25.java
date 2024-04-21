import java.util.Scanner;

public class Question25 {

    static int sum(int n){
        if(n == 0){
            return 0;
        }
        return (n % 10) + sum(n / 10);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter n: ");
        int n = scanner.nextInt();
        System.out.println();

        System.out.println(sum(n));

        scanner.close();
    }
}
