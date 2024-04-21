import java.util.Scanner;

public class Question19 {

    static boolean generatePlacement(boolean[][] board, int k){
        int n = board.length;

        for(int i1 = 0; i1 < n; i1++){
            for(int j1 = 0; j1 < n; j1++){
                for(int i2 = 0; i2 < n; i2++){
                    for(int j2 = 0; j2 < n; j2++){
                        if(i1 == i2 && j1 == j2){
                            continue;
                        }
                        if((board[i1][j1] == true) && (board[i2][j2] == true)){
                            if((i1 == i2) || (j1 == j2) || (Math.abs(i1 - i2) == Math.abs(j1 - j2))){
                                return false;
                            }
                        }
                    }
                }
            }
        }

        if(k == n){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(board[i][j] == true){
                        System.out.print("Q");
                    }else{
                        System.out.print("#");
                    }
                }
                System.out.println();
            }
            return true;
        }

        for(int j = 0; j < n; j++){
            board[k][j] = true;
            if(generatePlacement(board, k + 1) == true){
                return true;
            }
            board[k][j] = false;
        }

        return false;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter n: ");
        int n = scanner.nextInt();
        System.out.println();

        boolean[][] board = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = false;
            }
        }

        if(generatePlacement(board, 0) == false){
            System.out.println("NA");
        }

        scanner.close();
    }
}
