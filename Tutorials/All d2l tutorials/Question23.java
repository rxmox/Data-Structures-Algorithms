import java.util.Scanner;

public class Question23 {

    static int count(int[] numbers, int start, int end, int m){
        if(start > end){
            return 0;
        }
        int cnt = 0;
        if(numbers[start] == m){
            cnt += 1;
        }
        cnt += count(numbers, start + 1, end, m);
        return cnt;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter n: ");
        int n = scanner.nextInt();
        System.out.println();

        System.out.println("Please enter numbers: ");
        int[] numbers = new int[n];
        for(int i = 0; i < n; i++){
            numbers[i] = scanner.nextInt();
        }
        System.out.println();

        System.out.println("Please enter m: ");
        int m = scanner.nextInt();
        System.out.println();

        System.out.println(count(numbers, 0, n-1, m));

        scanner.close();
    }
}
