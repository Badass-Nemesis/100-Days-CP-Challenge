// Question - https://leetcode.com/problems/ugly-number/

import java.util.*;

public class Qes1 {
    public static boolean isUgly(int n) {
        // funfact -> n=0 wala case mein TLE ho gaya. big LOL
        // that's why I'm putting this below if block
        if (n == 0) {
            return false;
        }

        while (n % 2 == 0) {
            n = n / 2;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        while (n % 5 == 0) {
            n = n / 5;
        }

        if (n == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(isUgly(n));
        scn.close();
    }
}
