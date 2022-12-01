// Question -> https://leetcode.com/problems/find-pivot-index/

import java.util.*;
import java.io.*;

public class LiveQes2 {
    public int pivotIndex(int[] nums) {
        // prefix sum approach
        int[] prefixSum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prefixSum[i] = nums[i];
            } else {
                prefixSum[i] = prefixSum[i - 1] + nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (prefixSum[nums.length - 1] - nums[i] == 0) {
                    return 0;
                }
            } else if (i == nums.length - 1) {
                if (prefixSum[i - 1] == 0) {
                    return i;
                }
            } else {
                if (prefixSum[i - 1] == (prefixSum[nums.length - 1] - prefixSum[i])) {
                    return i;
                }
            }
        }

        return -1;
    }

    // my approach
    public int pivotIndex2(int[] nums) {
        int totalSum = 0;
        int leftPointerSum = 0;
        for (int val : nums) {
            totalSum += val;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                leftPointerSum += nums[i - 1];
            }
            if ((leftPointerSum * 2) + nums[i] == totalSum) {
                return i;
            }
        }

        return -1;
    }
}
