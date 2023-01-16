// Question -> https://leetcode.com/problems/house-robber/description/

class Solution {
    static int[] dpArr;

    static int recursion(int[] nums, int index) {
        if (index < 0 || index >= nums.length) {
            return 0;
        }

        if (dpArr[index] != -1) {
            return dpArr[index];
        }

        int ans1 = nums[index] + recursion(nums, index + 2);
        int ans2 = recursion(nums, index + 1);

        return dpArr[index] = Math.max(ans1, ans2);
    }

    public int rob(int[] nums) {
        dpArr = new int[101];
        for (int i = 0; i < 101; i++) {
            dpArr[i] = -1;
        }

        return recursion(nums, 0);
    }
}