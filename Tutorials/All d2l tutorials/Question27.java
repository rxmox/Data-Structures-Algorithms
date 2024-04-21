import java.util.Scanner;

public class Question27 {

    static int maximum(int[] numbers, int start, int end){
        if(start == end){
            return numbers[start];
        }
        return Math.max(numbers[start], maximum(numbers, start + 1, end));
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

        System.out.println(maximum(numbers, 0, n-1));

        scanner.close();
    }
}
