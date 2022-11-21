// Question 2 -> https://leetcode.com/problems/range-sum-query-2d-immutable/description/

import java.util.*;
// import java.io.*;

public class Qes2 {

    private static int[][] newMatrix;

    public void NumMatrix(int[][] matrix) {
        Scanner scn = new Scanner(System.in);
        newMatrix = new int[202][202];
        int row = matrix.length;
        int column = matrix[0].length;

        // PADDING
        for (int i = 0; i < row; i++) {
            newMatrix[i][0] = 0;
        }
        for (int i = 0; i < column; i++) {
            newMatrix[0][i] = 0;
        }

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                newMatrix[i][j] = newMatrix[i - 1][j] + newMatrix[i][j - 1] - newMatrix[i - 1][j - 1]
                        + matrix[i - 1][j - 1]; // ye matrix[i-1][j-1] isiliye kar rahe h because padding ki wajah se ek
                                                // index aage chala gaya h newMatrix. to original value ko add karne ke
                                                // liye ek minus karna hoga humlog ko orignial matrix se
            }
        }
        scn.close();
    }

    public int sumRegion(int r1, int c1, int r2, int c2) {
        return newMatrix[r2 + 1][c2 + 1] - newMatrix[r2 + 1][c1] - newMatrix[r1][c2 + 1] + newMatrix[r1][c1];
        // this is basically mat[r2][c2] - mat[r2-1][c2] - mat[r2][c1-1] +
        // mat[r1-1][c1-1]
        // it got turned into the above mentioned return because of padding
    }
}
