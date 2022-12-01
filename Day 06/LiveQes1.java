// Question -> https://leetcode.com/problems/minimum-size-subarray-sum/description/

import java.util.*;
import java.io.*;

public class LiveQes1 {
    public int minSubArrayLen(int target, int[] nums) {
        // I need to learn sliding window for this, because it's easy
        // Or I can use prefix sum also
        int ans = Integer.MAX_VALUE;
        int leftPointer = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while (sum >= target) {
                ans = Math.min(ans, i + 1 - leftPointer);
                sum -= nums[leftPointer];
                leftPointer++;
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
