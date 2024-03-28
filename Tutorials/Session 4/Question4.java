import java.util.Scanner;

public class Question4 {

    static long summation(int n){
        // Why do we need to return a "long"? isn't "int" enough?
        long sum = 0;

        // Can "i" be an "int"?
        for(long i = 1; i <= n; i++){
            sum += (i * i);
        }

        return sum;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter n: ");
        int n = scanner.nextInt();

        System.out.println(summation(n));

        scanner.close();
    }
}
