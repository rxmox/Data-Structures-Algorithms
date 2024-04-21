import java.util.Scanner;

public class Question22 {

    static String reverse(String s){
        int n = s.length();
        if(n <= 1){
            return s;
        }
        String t = Character.toString(s.charAt(n-1)) + reverse(s.substring(1, n-1)) + Character.toString(s.charAt(0));
        return t;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter s: ");
        String s = scanner.next();
        System.out.println();

        System.out.println(reverse(s));

        scanner.close();
    }
}
