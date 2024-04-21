import java.util.Scanner;

public class Question20 {

    static void printSpace(int n){
        if(n == 0){
            return;
        }
        System.out.print(" ");
        printSpace(n-1);
    }

    static void printStar(int n){
        if(n == 0){
            return;
        }
        System.out.print("*");
        printStar(n-1);
    }

    static void generateDiamondRow(int spaces, int stars){
        printSpace(spaces);
        printStar(stars);
        System.out.println();
    }

    static void generateDiamond(int n, int i, int spaces, int stars){
        if(i == n){
            return;
        }
        generateDiamondRow(spaces, stars);
        if(i < n / 2){
            generateDiamond(n, i + 1, spaces - 1, stars + 2);
        }else{
            generateDiamond(n, i + 1, spaces + 1, stars - 2);
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // System.out.println("Please enter n: ");
        // int n = scanner.nextInt();

        // generateDiamond(n, 0, n / 2, 1);

        generateDiamondRow(10, 1);

        scanner.close();
    }
}
