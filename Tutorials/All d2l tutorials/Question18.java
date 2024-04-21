import java.util.Scanner;

public class Question18 {

    static void generateNumber(int[] digits, int k){
        int n = digits.length;
        if(k == n){
            for(int i = 0; i < n; i++){
                System.out.print(digits[i]);
            }
            System.out.println();
            return;
        }
        for(int d = 9; d >= 0; d--){
            if(k == 0){
                digits[k] = d;
                generateNumber(digits, k + 1);
                digits[k] = -1;
            }else{
                if(d < digits[k-1]){
                    digits[k] = d;
                    generateNumber(digits, k + 1);
                    digits[k] = -1;
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter n: ");
        int n = scanner.nextInt();
        System.out.println();

        int[] digits = new int[n];
        for(int i = 0; i < n; i++){
            digits[i] = -1;
        }

        generateNumber(digits, 0);

        scanner.close();
    }
}
