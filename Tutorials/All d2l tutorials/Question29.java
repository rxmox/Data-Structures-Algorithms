import java.util.Scanner;

public class Question29 {

    static boolean getCombination(int[] coins, int[] cnt, int m){
        if(m == 0){
            for(int i = 0; i < coins.length; i++){
                if(cnt[i] != 0){
                    System.out.print(cnt[i] + "x" + coins[i] + " ");
                }
            }
            System.out.println();
            return true;
        }
        if(m < 0){
            return false;
        }
        for(int i = 0; i < coins.length; i++){
            cnt[i] += 1;
            boolean result = getCombination(coins, cnt, m - coins[i]);
            cnt[i] -= 1;
            if(result == true){
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
        int[] cnt = new int[n];
        for(int i = 0; i < n; i++){
            coins[i] = scanner.nextInt();
            cnt[i] = 0;
        }
        System.out.println();

        System.out.println("Please enter m: ");
        int m = scanner.nextInt();
        System.out.println();

        if(getCombination(coins, cnt, m) == false){
            System.out.println("Not Possible");
        }

        scanner.close();
    }
}
