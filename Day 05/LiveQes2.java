// Question -> https://leetcode.com/problems/spiral-matrix/description/

import java.util.*;

public class LiveQes2 {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int top = 0;
        int down = n - 1;
        int left = 0;
        int right = m - 1;
        int direction = 0;
        // int number = 1;
        System.out.println(right + " " + down);

        // int[][] arr = new int[n][n];
        while (left <= right && top <= down) {
            if (direction == 0) {
                for (int j = left; j <= right; j++) {
                    // System.out.println(top + " " + j); // debug
                    list.add(matrix[top][j]);
                    // number++;
                }
                top++;
                direction++;
            } else if (direction == 1) {
                for (int j = top; j <= down; j++) {
                    list.add(matrix[j][right]);
                    // number++;
                }
                right--;
                direction++;
            } else if (direction == 2) {
                for (int j = right; j >= left; j--) {
                    list.add(matrix[down][j]);
                    // number++;
                }
                down--;
                direction++;
            } else if (direction == 3) {
                for (int j = down; j >= top; j--) {
                    list.add(matrix[j][left]);
                    // number++;
                }
                left++;
                direction = 0;
            }

        }

        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // System.out.print(arr[i][j] + " ");
        // }
        // System.out.println();
        // }
        return list;
    }
}