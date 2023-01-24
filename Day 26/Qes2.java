// Question -> https://leetcode.com/problems/ones-and-zeroes/

class Solution {
    static Integer[][][] dpArr;

    static int countOnes(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    static int countZeroes(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count++;
            }
        }
        return count;
    }

    static int recursion(String[] strs, int index, int remainingOnes, int remainingZeroes) {
        if (index == strs.length) {
            return 0;
        }

        if (dpArr[index][remainingOnes][remainingZeroes] != null) {
            return dpArr[index][remainingOnes][remainingZeroes];
        }

        // not pick
        int notPick = recursion(strs, index + 1, remainingOnes, remainingZeroes);

        int pick = 0;
        if (remainingOnes >= countOnes(strs[index]) && remainingZeroes >= countZeroes(strs[index])) {
            pick = 1 + recursion(strs, index + 1, remainingOnes - countOnes(strs[index]),
                    remainingZeroes - countZeroes(strs[index]));
        }

        dpArr[index][remainingOnes][remainingZeroes] = Math.max(pick, notPick);

        return dpArr[index][remainingOnes][remainingZeroes];
    }

    public int findMaxForm(String[] strs, int m, int n) {
        dpArr = new Integer[601][101][101];
        return recursion(strs, 0, n, m);
    }
}