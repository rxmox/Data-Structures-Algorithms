import java.util.Scanner;

public class Question11 {

    static boolean isPalindrome(int m){
        if(m < 0){
            return false;
        }
        int originalNumber = m;
        int reversedNumber = 0;

        while(m > 0){
            int digit = m % 10;
            reversedNumber = reversedNumber * 10 + digit;
            m /= 10;
        }

        return (originalNumber == reversedNumber);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter m: ");
        int m = scanner.nextInt();

        System.out.println(isPalindrome(m));

        scanner.close();
    }
}
