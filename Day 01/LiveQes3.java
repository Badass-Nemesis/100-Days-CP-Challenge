// Question - https://www.codechef.com/problems/GRID
/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class LiveQes3 {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Scanner scn = new Scanner(System.in);
        int testCases = scn.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = scn.nextInt();
            char[][] arr = new char[n][n];
            for (int i = 0; i < n; i++) {
                String temp = scn.next();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = temp.charAt(j);
                }
            }

            // for(int i = 0; i<n; i++){
            // for(int j = 0; j<n; j++){
            // System.out.print(arr[i][j]);
            // }
            // System.out.println();
            // }

            boolean[] checking_i = new boolean[n];
            boolean[] checking_j = new boolean[n];
            Arrays.fill(checking_i, true);
            Arrays.fill(checking_j, true);

            int ans = 0;
            for (int i = n - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if(arr[i][j]=='#'){
                        checking_i[i] = false;
                        checking_j[j] = false;
                    } else if(checking_i[i] == true && checking_j[j] == true){
                        ans++;
                    }
                }
            }

            System.out.println(ans);
        }
    }
}
