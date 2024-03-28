import java.util.Scanner;

public class Question7 {

    static boolean checkFormula(int a, int b, int c){
        if(a + b == c){
            return true;
        }

        if(a - b == c){
            return true;
        }

        if(a * b == c){
            return true;
        }

        return false;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a: ");
        int a = scanner.nextInt();

        System.out.println("Please enter b: ");
        int b = scanner.nextInt();

        System.out.println("Please enter c: ");
        int c = scanner.nextInt();

        System.out.println(checkFormula(a, b, c));

        scanner.close();
    }
}
