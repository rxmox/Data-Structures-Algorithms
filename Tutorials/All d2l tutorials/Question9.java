import java.util.Scanner;

public class Question9 {

    static int howManySteps(int m){
        int steps = 0;

        while(m >= 2){
            m /= 2;
            steps++;
        }

        return steps;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter m: ");
        int m = scanner.nextInt();

        System.out.println(howManySteps(m));

        scanner.close();
    }
}
