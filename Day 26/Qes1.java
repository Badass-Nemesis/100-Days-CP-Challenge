// Question -> https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/description/

class Solution {
    static int[][] dpArr;

    static int mod = 1000000007;

    static int recursion(int index, int steps, int len) {
        if (index == 0 && steps == 0) {
            return 1;
        }
        if (steps == 0) {
            return 0;
        }
        if (index < 0 || index == len) {
            return 0;
        }

        if (dpArr[steps][index] != -1) {
            return dpArr[steps][index];
        }

        long ans1 = (recursion(index - 1, steps - 1, len)) % mod; // left
        long ans2 = (recursion(index + 1, steps - 1, len)) % mod; // right
        long ans3 = (recursion(index, steps - 1, len)) % mod; // stay

        long ans = (ans1 + ans2 + ans3) % mod;
        return dpArr[steps][index] = (int) ans;
    }

    public int numWays(int steps, int arrLen) {
        arrLen = Math.min(arrLen, steps / 2 + 1);
        dpArr = new int[steps + 1][arrLen];
        for (int i = 0; i < steps + 1; i++) {
            for (int j = 0; j < arrLen; j++) {
                dpArr[i][j] = -1;
            }
        }

        return recursion(0, steps, arrLen);
    }
}

class Solution2 {
    public int numWays(int steps, int arrLen) {
        int mod = 1000000007;
        arrLen = Math.max(arrLen, steps / 2 + 1);

        int[][] dpArr = new int[steps + 1][arrLen + 1];
        dpArr[0][0] = 1;

        for (int i = 0; i <= steps; i++) {
            for (int j = 0; j <= arrLen; j++) {
                dpArr[i][j] = (dpArr[i - 1][j] + dpArr[i - 1][j + 1]) % mod;

                if (j > 0) {
                    dpArr[i][j] += (dpArr[i - 1][j - 1]) % mod;
                }
            }
        }

        return dpArr[steps][0];
    }
}