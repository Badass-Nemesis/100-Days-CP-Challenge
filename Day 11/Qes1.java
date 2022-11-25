// Question -> https://www.codechef.com/problems/RANKLIST

import java.util.*;
import java.lang.*;
import java.io.*;

class Qes1 {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Scanner scn = new Scanner(System.in);
        int testCases = scn.nextInt();
        for (int i = 0; i < testCases; i++) {
            int ranks = scn.nextInt();
            int sum = scn.nextInt();
            int target = (ranks * (ranks + 1)) / 2;
            int ans = 0;
            for (int j = ranks; j > 0; j--) {
                if (target <= sum) {
                    break;
                }
                target -= j;
                sum--;
                ans++;
            }

            System.out.println(ans);
        }

        scn.close();
        return;
    }
}
