// Question - https://codeforces.com/contest/1742/problem/D

import java.util.*;

public class Qes1 {

    public static void solve() {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int m = scn.nextInt();
            hm.put(m, i+1); // iska matlab h ki m value jo h, wo ith index pe stored h
        }

        int ans = -1; 

        

        scn.close();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for (int i = 0; i < n; i++) {
            solve();
        }
        scn.close();
    }
}