// Question -> https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/

class Solution {
    public int longestSubarray(int[] nums) {
        int result = 0;
        int k = 1; // since there is one zero which we need to delete

        for (int i = 0, j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                k--;
            }

            while (k < 0) {
                if (nums[i] == 0) {
                    k++;
                }
                i++;
            }

            result = Math.max(result, j - i);
        }

        return result;
    }
}