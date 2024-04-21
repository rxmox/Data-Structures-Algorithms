public class MatrixExample {

    // Helper method to print a matrix
    static void printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Matrix Addition
    static int[][] addMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }

        return result;
    }

    // Matrix Subtraction
    static int[][] subtractMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }

        return result;
    }

    // Scalar Multiplication
    static int[][] scalarMultiplyMatrix(int[][] A, int scalar) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] * scalar;
            }
        }

        return result;
    }

    // Matrix Multiplication
    static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int colsB = B[0].length;
        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrixA = {{1, 1}, {1, 0}};
        int[][] matrixB = {{1, 1}, {1, 0}};

        System.out.println("Matrix A:");
        printMatrix(matrixA);
        System.out.println();

        System.out.println("Matrix B:");
        printMatrix(matrixB);
        System.out.println();

        System.out.println("Matrix Addition (A + B):");
        int[][] resultAddition = addMatrices(matrixA, matrixB);
        printMatrix(resultAddition);
        System.out.println();

        System.out.println("Matrix Subtraction (A - B):");
        int[][] resultSubtraction = subtractMatrices(matrixA, matrixB);
        printMatrix(resultSubtraction);
        System.out.println();

        int scalar = 2;
        System.out.println("Scalar Multiplication (A * " + scalar + "):");
        int[][] resultScalarMultiplication = scalarMultiplyMatrix(matrixA, scalar);
        printMatrix(resultScalarMultiplication);
        System.out.println();

        System.out.println("Matrix Multiplication (A * B):");
        int[][] resultMultiplication = multiplyMatrices(matrixA, matrixB);
        printMatrix(resultMultiplication);
        System.out.println();
    }

}
