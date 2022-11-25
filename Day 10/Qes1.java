// Question -> https://leetcode.com/problems/array-partition/description/

import java.util.*;

public class Qes1 {
    public int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }
}
