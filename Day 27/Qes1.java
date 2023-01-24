// Question -> https://practice.geeksforgeeks.org/problems/rod-cutting0840/1

// my solution
class Solution {
    static int[] dpArr;

    static int recursion(int[] price, int length, int index) {
        if (length <= 0 || index - length == 0) {
            return 0;
        }

        if (dpArr[length] != -1) {
            return dpArr[length];
        }

        int ans1 = 0;
        if (length - index - 1 >= 0) {
            ans1 = price[index] + recursion(price, length - index - 1, index);
        }
        int ans2 = recursion(price, length, index + 1);

        return dpArr[length] = Math.max(ans1, ans2);
    }

    public int cutRod(int price[], int n) {
        dpArr = new int[1001];
        for (int i = 0; i < 1001; i++) {
            dpArr[i] = -1;
        }

        return recursion(price, n, 0);
    }
}

// sumeet sir's solution
class Solution2 {
    public int cutRod(int price[], int n) {
        int[] dpArr = new int[n + 1];
        dpArr[0] = 0;
        dpArr[1] = price[0];

        for (int i = 2; i <= n; i++) {
            int tempAns = price[i - 1];

            int leftIndex = 1;
            int rightIndex = i - 1;
            while (leftIndex <= rightIndex) {
                tempAns = Math.max(tempAns, dpArr[leftIndex] + dpArr[rightIndex]);
                leftIndex++;
                rightIndex--;
            }

            dpArr[i] = tempAns;
        }

        return dpArr[n];
    }
}