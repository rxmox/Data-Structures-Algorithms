import java.util.Scanner;

public class Question6 {

    static boolean isPalindrome(String s){
        for(int i = 0; i < ((s.length() + 1) / 2); i += 1){
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter s: ");
        String s = scanner.next();

        System.out.println(isPalindrome(s));

        scanner.close();
    }
}
