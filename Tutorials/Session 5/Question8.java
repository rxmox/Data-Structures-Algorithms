import java.util.Scanner;

public class Question8 {

    static boolean checkArray(int[] a){
        if(a.length <= 1){
            return false;
        }

        for(int i = 0; i < a.length; i++){
            if(a[i] % 2 == 0){
                return true;
            }
        }

        return false;
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

        System.out.println(checkArray(a));

        scanner.close();
    }
}
