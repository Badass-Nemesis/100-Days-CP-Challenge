// Question -> https://codeforces.com/contest/1684/problem/B
// purely observation based qes h ye

import java.util.*;
// import java.io.*;

public class LiveQes1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for (int i = 0; i < n; i++) {
            int a = scn.nextInt(), b = scn.nextInt(), c = scn.nextInt();
            System.out.println((a + b + c) + " " + (b + c) + " " + c);
        }
        scn.close();
    }
}