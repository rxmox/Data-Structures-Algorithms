import java.util.Scanner;

public class Question24 {

    static int sum(int[] numbers, int start, int end){
        if(start > end){
            return 0;
        }
        int cnt = 0;
        if(numbers[start] % 2 == 1){
            cnt += numbers[start];
        }
        cnt += sum(numbers, start + 1, end);
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

        System.out.println(sum(numbers, 0, n-1));

        scanner.close();
    }
}
