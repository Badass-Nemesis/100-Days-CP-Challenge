// Question -> https://leetcode.com/problems/domino-and-tromino-tiling/description/

class Solution {
    static int mod = 1000000007;

    static int[] dpArr;

    static int recursion(int n) {
        if (n == 1 || n == 2) {
            return n;
        } else if (n == 3) {
            return 5;
        }

        if (dpArr[n] != -1) {
            return dpArr[n];
        }

        dpArr[n] = ((2 * recursion(n - 1)) % mod + (recursion(n - 3) % mod)) % mod;
        return dpArr[n];
    }

    public int numTilings(int n) {
        dpArr = new int[1001];
        for (int i = 0; i < 1001; i++) {
            dpArr[i] = -1;
        }

        return recursion(n);
    }
}