package Methods;
import java.util.*;

public class MatrixOperations {
    public static int[][] randomMatrix(int r, int c) {
        int[][] mat = new int[r][c];
        Random rand = new Random();
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                mat[i][j] = rand.nextInt(10);
        return mat;
    }

    public static int[][] transpose(int[][] mat) {
        int[][] trans = new int[mat[0].length][mat.length];
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[0].length; j++)
                trans[j][i] = mat[i][j];
        return trans;
    }

    public static int determinant2x2(int[][] mat) {
        return mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];
    }

    public static void displayMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int x : row) System.out.print(x + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] mat = randomMatrix(2, 2);
        displayMatrix(mat);
        int[][] trans = transpose(mat);
        displayMatrix(trans);
        System.out.println("Determinant: " + determinant2x2(mat));
    }
}
