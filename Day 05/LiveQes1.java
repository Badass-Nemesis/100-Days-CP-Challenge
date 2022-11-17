// Question -> https://leetcode.com/problems/sort-the-matrix-diagonally/description/

import java.util.*;

public class LiveQes1 {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>(0);
        int count = 0;
        int level = 0;
        int xPointer = 0;
        int yPointer = 0;
        while (count != (matrix.length + matrix[0].length + 2) / 2) {

            if (count % 2 == 0) {
                if (count == 0 || count % 4 == 0) {
                    // right
                    for (int i = 0; i < matrix.length - level; i++) {
                        System.out.print(matrix[xPointer][i]);
                    }
                    count++;
                    xPointer = matrix.length - level;
                }

                else {
                    // left
                    for (int i = matrix.length - 1; i >= 0 + level; i--) {
                        System.out.print(matrix[xPointer][i]);
                    }
                    count++;
                    xPointer = level;
                }

            } else {

                if (count == 1 || count % 2 == 0) {
                    // down
                    for (int i = 0; i < matrix[0].length - level; i++) {
                        System.out.println(matrix[i][yPointer]);
                    }
                    count++;
                    yPointer = matrix[0].length - level;
                }

                else {
                    // up
                    for (int i = matrix[0].length - 1; i >= 0 + level; i--) {
                        System.out.println(matrix[i][yPointer]);
                    }
                    count++;
                    yPointer = level;
                }

            }

            if (count % 2 == 0) {
                level++;
            }

        }

        return list;
    }
}
