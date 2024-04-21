import java.util.Scanner;

public class Question1 {

    static boolean isMultiple(long n, long m){
        // Why we should handle "m = 0" separately?
        if(m == 0){
            if(n == 0){
                return true;
            }else{
                return false;
            }
        }

        return (n % m) == 0;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter n: ");
        long n = scanner.nextLong();

        System.out.println("Please enter m: ");
        long m = scanner.nextLong();

        System.out.println(isMultiple(n, m));

        scanner.close();
    }
}
