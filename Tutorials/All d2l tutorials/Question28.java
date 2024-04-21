import java.util.Scanner;

public class Question28 {

    static boolean check(int[] coins, int m){
        if(m == 0){
            return true;
        }
        if(m < 0){
            return false;
        }
        for(int i = 0; i < coins.length; i++){
            if(check(coins, m - coins[i]) == true){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter n: ");
        int n = scanner.nextInt();
        System.out.println();

        System.out.println("Please enter coins: ");
        int[] coins = new int[n];
        for(int i = 0; i < n; i++){
            coins[i] = scanner.nextInt();
        }
        System.out.println();

        System.out.println("Please enter m: ");
        int m = scanner.nextInt();
        System.out.println();

        System.out.println(check(coins, m));

        scanner.close();
    }
}
