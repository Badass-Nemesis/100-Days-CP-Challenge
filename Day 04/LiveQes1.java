// Question -> https://codeforces.com/problemset/problem/1659/A

import java.util.*;

public class LiveQes1 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int test_cases = scn.nextInt();

        for (int i = 0; i < test_cases; i++) {
            int n = scn.nextInt();
            int r = scn.nextInt();
            int b = scn.nextInt();

            int numberOfConssecutiveR = r / (b + 1);
            int numberOfRemainingR = r % (b + 1);
            // System.out.println(numberOfConssecutiveR + " " + numberOfRemainingR); // debug

            String consecutiveR = "";
            for (int k = 0; k < numberOfConssecutiveR; k++) {
                consecutiveR += "R";
            }

            /*
             * WARNING!! dumb codes in this (slash star) comment section
             * 
             * String remainingR = "";
             * for (int k = 0; k < numberOfRemainingR; k++) {
             * remainingR += "R";
             * }
             * 
             * String ans = "";
             * // gaps = b+1 or n-b
             * for (int j = 0; j < b; j++) {
             * ans = consecutiveR + "B" + ans;
             * }
             * 
             * System.out.println(ans + remainingR);
             * 
             */

            String ans = "";
            for (int j = 0; j < b; j++) {
                ans += consecutiveR;
                if (numberOfRemainingR > 0) {
                    ans += "R";
                    numberOfRemainingR--;
                }
                ans += "B";
            }

            System.out.println(ans + consecutiveR);

        }

        scn.close();
    }
}
