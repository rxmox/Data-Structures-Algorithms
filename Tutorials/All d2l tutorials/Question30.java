import java.util.Scanner;

public class Question30 {

    static int countCombinations(int[] coins, int m, int k){
        if(m == 0){
            return 1;
        }
        if(m < 0){
            return 0;
        }
        if(k >= coins.length){
            return 0;
        }
        int result = 0;
        for(int i = 0; i * coins[k] <= m; i++){
            result += countCombinations(coins, m - (i * coins[k]), k + 1);
        }
        return result;
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

        System.out.println(countCombinations(coins, m, 0));

        scanner.close();
    }
}
