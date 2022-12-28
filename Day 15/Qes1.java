// Question -> https://www.spoj.com/problems/HS08PAUL/

import java.io.*;
import java.util.*;

public class Qes1 {

    static boolean[] isPrime;

    public static void sieve(int n) {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i] == true) {
                for (int j = i + i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Set<Integer> ans = new HashSet<>();
        isPrime = new boolean[100000007];
        sieve(100000007); // tried with 10000000 (i.e. n's max limit), still TLE
        for (int i = 1; i * i < 10000000; i++) {
            for (int j = 1; j * j * j * j < 10000000; j++) {
                if (isPrime[i * i + j * j * j * j]) {
                    ans.add(i * i + j * j * j * j);
                }
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for (Integer val : ans) {
            arr.add(val);
        }
        Collections.sort(arr);

        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t-- > 0) {
            int n = scn.nextInt();
            if (n == 1) {
                System.out.println(0);
            } else {
                int count = 0;
                for (Integer val : arr) {
                    if (val > n) {
                        break;
                    } else {
                        // System.out.println("val = " + val + " count = " + count); // debug
                        count++;
                    }
                }

                System.out.println(count);
            }
        }
        scn.close();
    }
}
