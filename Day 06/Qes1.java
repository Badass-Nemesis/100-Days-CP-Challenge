// Question -> https://leetcode.com/problems/product-of-array-except-self/description/

// import java.util.*;
// import java.io.*;

public class Qes1 {
    public int[] productExceptSelf(int[] nums) {
        int totalProduct = 1;
        int[] arr = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            totalProduct *= nums[i];
            arr[i] = totalProduct;
            // System.out.println(arr[i]);
        }

        totalProduct = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            arr[i] = totalProduct * arr[i + 1];
            totalProduct *= nums[i];
        }
        arr[nums.length - 1] = totalProduct;

        return arr;
    }
}
