import java.util.Scanner;

public class Question12 {

    static void reverseArray(int[] a){
        int start = 0;
        int end = a.length - 1;

        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter n: ");
        int n = scanner.nextInt();

        int[] a = new int[n];

        System.out.println("Please enter n numbers: ");
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }

        reverseArray(a);

        System.out.println("");
        for(int i = 0; i < n; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println("");

        scanner.close();
    }
}
