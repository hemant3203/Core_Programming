package Methods;

import java.util.Random;
import java.util.Scanner;

public class matrix {

    public static int[][] createMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] mat = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                mat[i][j] = rand.nextInt(10); // 0 to 9
        return mat;
    }

    public static int[][] addMatrices(int[][] A, int[][] B) {
        int[][] result = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                result[i][j] = A[i][j] + B[i][j];
        return result;
    }

    public static int[][] subtractMatrices(int[][] A, int[][] B) {
        int[][] result = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                result[i][j] = A[i][j] - B[i][j];
        return result;
    }

    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rows = A.length, cols = B[0].length, common = A[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                for (int k = 0; k < common; k++)
                    result[i][j] += A[i][k] * B[k][j];
        return result;
    }

    public static void displayMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // First matrix input
        System.out.print("Enter rows and columns of Matrix A: ");
        int rowsA = sc.nextInt(), colsA = sc.nextInt();
        int[][] A = createMatrix(rowsA, colsA);

        // Second matrix input
        System.out.print("Enter rows and columns of Matrix B: ");
        int rowsB = sc.nextInt(), colsB = sc.nextInt();
        int[][] B = createMatrix(rowsB, colsB);

        System.out.println("Matrix A:");
        displayMatrix(A);

        System.out.println("Matrix B:");
        displayMatrix(B);

        if (rowsA == rowsB && colsA == colsB) {
            System.out.println("Addition:");
            displayMatrix(addMatrices(A, B));

            System.out.println("Subtraction:");
            displayMatrix(subtractMatrices(A, B));
        } else {
            System.out.println("Addition and Subtraction not possible due to dimension mismatch.");
        }

        if (colsA == rowsB) {
            System.out.println("Multiplication:");
            displayMatrix(multiplyMatrices(A, B));
        } else {
            System.out.println("Multiplication not possible due to dimension mismatch.");
        }

        sc.close();
    }
}
