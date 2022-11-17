// Question -> https://codeforces.com/problemset/problem/1668/B

import java.util.*;

public class LiveQes2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int test_cases = scn.nextInt();

        for (int i = 0; i < test_cases; i++) {
            int people = scn.nextInt();
            int chairs = scn.nextInt();

            int[] gaps = new int[people];
            for (int j = 0; j < people; j++) {
                gaps[j] = scn.nextInt();
            }

            Arrays.sort(gaps);

            long ans = 0;
            for (int j = 0; j < people; j++) {
                if (j == 0) {
                    ans++;
                } else if (j == people - 1) {
                    ans += 2 * gaps[j] + 1;
                } else {
                    ans += gaps[j] + 1;
                }
            }

            if (ans > chairs) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }

        }

        scn.close();
    }
}