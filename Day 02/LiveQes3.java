// Question - https://codeforces.com/problemset/problem/1671/C

import java.util.*;

public class LiveQes3 {

    public static int solve(int budget, int[] shops) {

        int day = 0;
        for(int i = shops.length - 1; i >=0; i--){
            
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int testCases = scn.nextInt();
        for (int i = 0; i < testCases; i++) {
            int n = scn.nextInt();
            int budget = scn.nextInt();
            int[] shops = new int[n];
            for (int j = 0; j < n; j++) {
                shops[i] = scn.nextInt();
            }

            System.out.println(solve(budget, shops));
        }
        scn.close();
    }
}
