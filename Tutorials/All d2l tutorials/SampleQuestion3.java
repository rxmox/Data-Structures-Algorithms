import java.util.ArrayList;
import java.util.Scanner;

public class SampleQuestion3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();

        System.out.print("Enter the size of the array (n): ");
        int n = scanner.nextInt();

        System.out.println("Enter the elements of the array:");
        int minOfArray = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            arrayList.add(x);
            minOfArray = Math.min(minOfArray, x);
        }

        int pairsCount = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = i; j < arrayList.size(); j++) {

                int minOfPair = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    minOfPair = Math.min(minOfPair, arrayList.get(k));
                }

                if (minOfPair == minOfArray) {
                    pairsCount++;
                }
            }
        }

        System.out.println("Number of pairs (i, j): " + pairsCount);

        scanner.close();
    }
}
