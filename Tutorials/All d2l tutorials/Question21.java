import java.util.Scanner;

public class Question21 {

    static boolean isPalindrome(String s){
        int n = s.length();
        if(n <= 1){
            return true;
        }
        if(s.charAt(n-1) != s.charAt(0)){
            return false;
        }
        return isPalindrome(s.substring(1, n-1));
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter s: ");
        String s = scanner.next();
        System.out.println();

        System.out.println(isPalindrome(s));

        scanner.close();
    }
}
