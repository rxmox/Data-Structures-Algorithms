import java.util.Scanner;

public class Question13 {

    static int combination(int n, int r){
        if(n < 0){
            return 0;
        }
        if(r == 0){
            return 1;
        }
        return combination(n-1, r-1) + combination(n-1, r);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter n: ");
        int n = scanner.nextInt();

        System.out.println("Please enter r: ");
        int r = scanner.nextInt();

        System.out.println(combination(n, r));

        scanner.close();
    }
}
