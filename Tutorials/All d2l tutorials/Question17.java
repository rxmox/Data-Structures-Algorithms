import java.util.Scanner;

public class Question17 {

    static void generateSubsets2(int state, int n, int k){
        if(k == n){
            System.out.print("{ ");
            for(int i = 0; i < n; i++){
                if(((1 << i) & state) > 0){
                    System.out.print( (i + 1) + " ");
                }
            }
            System.out.println("}");
            return;
        }

        generateSubsets2(state, n, k + 1);

        generateSubsets2(state | (1 << k), n, k + 1);
    }

    static void generateSubsets(boolean[] numbers, int k){
        int n = numbers.length;

        if(k == n){
            System.out.print("{ ");
            for(int i = 0; i < n; i++){
                if(numbers[i] == true){
                    System.out.print( (i + 1) + " ");
                }
            }
            System.out.println("}");
            return;
        }

        numbers[k] = false;
        generateSubsets(numbers, k + 1);

        numbers[k] = true;
        generateSubsets(numbers, k + 1);

        numbers[k] = false;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter n: ");
        int n = scanner.nextInt();
        System.out.println();

        boolean[] numbers = new boolean[n];
        for(int i = 0; i < n; i++){
            numbers[i] = false;
        }

        // generateSubsets(numbers, 0);

        generateSubsets2(0, n, 0);

        scanner.close();
    }
}
