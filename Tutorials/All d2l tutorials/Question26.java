import java.util.Scanner;

public class Question26 {

    static boolean isSorted(int[] numbers, int start, int end){
        if(start > end){
            return true;
        }
        if(numbers[start - 1] <= numbers[start]){
            return isSorted(numbers, start + 1, end);
        }else{
            return false;
        }
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

        System.out.println(isSorted(numbers, 1, n-1));

        scanner.close();
    }
}
