// Question -> https://codeforces.com/problemset/problem/1739/B

import java.util.*;

public class Qes2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int test_cases = scn.nextInt();

        for (int i = 0; i < test_cases; i++) {
            int n = scn.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = scn.nextInt();
            }

            // d = |a2 - a1|
            // +-d = a2 - a1
            // isiliye a2 = a1 + d, or a2 = a1 - d
            // d mera arr[] wala array h, aur a1 mera ans[] wala array

            int[] ans = new int[n];
            int d = arr[1];
            ans[0] = arr[0];

            for (int j = 1; j < n; j++) {
                int n1 = ans[j - 1] + d;
                int n2 = ans[j - 1] - d;

                System.out.println(n1 + " " + n2); // debug

                // ye if block isiliye use kar rahe h because jab d=0 hota h tab sirf ek hi chij
                // possible h ki a1 aur a2 mera equal ho. to calculation karne jayenge to alag
                // alag values mil jayega n1 aur n2 mein, isiliye direct idhar hi push kar denge
                if (d == 0) {
                    ans[j] = ans[j - 1];
                } else if (n1 >= 0 && n2 >= 0) {
                    // jab dono bada aur alag ho jayega, iska matlab ek se jyada ans aayega
                    System.out.println(-1);
                    return;
                } else {
                    if (n1 < 0 && n2 > 0) {
                        ans[j] = n2;
                    } else if (n2 < 0 && n1 > 0) {
                        ans[j] = n1;
                    }
                }

                d = arr[j]; // saving the next value in d
            }

            for (int j = 0; j < n; j++) {
                System.out.print(ans[j] + " ");
            }

        }

        scn.close();
    }
}
