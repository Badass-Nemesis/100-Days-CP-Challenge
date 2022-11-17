// Question -> https://codeforces.com/contest/1699/problem/A

import java.util.*;

public class Qes2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        for (int i = 0; i < n; i++) {
            int m = scn.nextInt();
            if (m % 2 == 0) {
                System.out.println(1 + " " + 1 + " " + (1 ^ m / 2)); // sir's code

                // System.out.println(0 + " " + m / 2 + " " + m / 2); // mine + other's code
                // System.out.println(0 + " " + 0 + " " + m / 2); // mine + other's code
            } else {
                System.out.println(-1);
            }
        }
        scn.close();
    }
}
