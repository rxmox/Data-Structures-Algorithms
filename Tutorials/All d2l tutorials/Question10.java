import java.util.Scanner;

public class Question10 {

    static int summationOfDigits(int m){
        if(m < 0){
            m *= -1;
        }

        int sum = 0;

        while(m > 0){
            sum += m % 10;
            m /= 10;
        }

        return sum;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter m: ");
        int m = scanner.nextInt();

        System.out.println(summationOfDigits(m));

        scanner.close();
    }
}
