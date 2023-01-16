// Question -> https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/

import java.util.*;

class Solution {
    static int[][] dpArr;

    static int recursion(List<List<Integer>> piles, int k, int index) {
        if (k == 0 || index >= piles.size()) {
            return 0;
        }

        if (dpArr[k][index] != -1) {
            return dpArr[k][index];
        }

        int max = 0;
        // not selecting any coin an just going till last pile's index
        max = Math.max(max, recursion(piles, k, index + 1));

        for (int i = 0; i < piles.get(index).size(); i++) {
            if (i + 1 <= k) {
                max = Math.max(max, piles.get(index).get(i) + recursion(piles, k - (i + 1), index + 1));
            } else {
                break;
            }
        }

        return dpArr[k][index] = max;
    }

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        dpArr = new int[1001][2001];
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 2001; j++) {
                dpArr[i][j] = -1;
            }
        }

        // converting normal piles to prefixSum piles
        for (int i = 0; i < piles.size(); i++) {
            for (int j = 1; j < piles.get(i).size(); j++) {
                piles.get(i).set(j, (piles.get(i).get(j) + piles.get(i).get(j - 1)));
            }
        }

        return recursion(piles, k, 0);
    }
}