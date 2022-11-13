// Question - https://leetcode.com/problems/ugly-number-ii/

import java.util.*;

public class LiveQes1 {

    public static int nthUglyNumber(int n) {
        int twoPointer = 0;
        int threePointer = 0;
        int fivePointer = 0;

        int[] arr = new int[n];
        arr[0] = 1; // since 1 is the first ugly number

        for (int i = 1; i < n; i++) {
            int twoFactor = 2 * arr[twoPointer];
            int threeFactor = 3 * arr[threePointer];
            int fiveFactor = 5 * arr[fivePointer];

            arr[i] = Math.min(threeFactor, Math.min(fiveFactor, twoFactor));
            // ye min humlog isiliye le rahe h because ye ek tarah se ascending order mein
            // array bharega, jisse pointer ko easy rahega multiply kar kar ke aage badhne
            // mein

            if (twoFactor == arr[i]) {
                twoPointer++;
            }
            if (threeFactor == arr[i]) {
                threePointer++;
            }
            if (fiveFactor == arr[i]) {
                fivePointer++;
            }
        }

        return arr[n - 1];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(nthUglyNumber(n));
        scn.close();
    }
}
