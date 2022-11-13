// Question - https://leetcode.com/problems/number-of-subarrays-with-gcd-equal-to-k/description/

// import java.io.*;
import java.util.*;

public class Qes2 {
    // I forgot how to find GCD. I guess I have to google it or learn it again from
    // pepcoding
    public static int gcdFind(int n, int m) {
        if (m == 0) {
            return n;
        }
        return gcdFind(m, n % m);
    }

    // sir's solution
    public static int solution(int[] nums, int k) {
        int number = 0;
        for (int i = 0; i < nums.length; i++) {
            int gcd = nums[i];
            for (int j = i; j < nums.length; j++) {
                if (gcd < k) {
                    break;
                }

                gcd = gcdFind(nums[j], gcd);

                if (gcd == k) {
                    number++;
                }
            }
        }
        return number;
    }

    // my solution
    public static int solution2(int[] nums, int k) {
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            int gcd = nums[i];
            if (gcd == k) {
                answer++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < k) {
                    break;
                }

                gcd = gcdFind(nums[j], gcd);

                if (gcd == k) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        scn.close();
        System.out.println(solution(nums, k));
    }
}