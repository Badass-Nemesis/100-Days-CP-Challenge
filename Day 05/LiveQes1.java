// Question -> https://leetcode.com/problems/sort-the-matrix-diagonally/description/

import java.util.*;

public class LiveQes1 {

    // arun bhaiya's code
    public int[][] diagonalSort(int[][] A) {
        int m = A.length, n = A[0].length;
        HashMap<Integer, PriorityQueue<Integer>> d = new HashMap<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                d.putIfAbsent(i - j, new PriorityQueue<>());
                d.get(i - j).add(A[i][j]);
            }
        }
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                A[i][j] = d.get(i - j).poll();
        return A;
    }

    // my code........ AM I THAT DUMB?!
    public int[][] diagonalSort2(int[][] mat) {
        ArrayList<PriorityQueue<Integer>> arr = new ArrayList<>();
        int row = mat.length - 1;
        int column = mat[0].length - 1;
        int arrWalaCount = 0;

        // reading & putting, gap 0 se pehle ruk jayega
        for (int gap = row; gap > 0; gap--) {
            PriorityQueue<Integer> tempPQ = new PriorityQueue<>();
            arr.add(tempPQ);
            for (int i = gap, j = 0; i <= row && j <= column; i++, j++) {
                int temp = mat[i][j];
                arr.get(arrWalaCount).add(temp);
            }
            arrWalaCount++;
        }

        // reading & putting, gap 0 ke baad tak jayega
        for (int gap = 0; gap <= column; gap++) {
            PriorityQueue<Integer> tempPQ = new PriorityQueue<>();
            arr.add(tempPQ);
            for (int i = 0, j = gap; i <= row && j <= column; i++, j++) {
                int temp = mat[i][j];
                arr.get(arrWalaCount).add(temp);
            }
            arrWalaCount++;
        }

        arrWalaCount = 0; // updating the count for next process

        // removing & updating, gap 0 se pehle ruk jayega
        for (int gap = row; gap > 0; gap--) {
            for (int i = gap, j = 0; i <= row && j <= column; i++, j++) {
                int temp = arr.get(arrWalaCount).remove();
                mat[i][j] = temp;
            }
            arrWalaCount++;
        }

        // removing & updating, gap 0 ke baad tak jayega
        for (int gap = 0; gap <= column; gap++) {
            for (int i = 0, j = gap; i <= row && j <= column; i++, j++) {
                int temp = arr.get(arrWalaCount).remove();
                mat[i][j] = temp;
            }
            arrWalaCount++;
        }

        return mat;
    }

}
