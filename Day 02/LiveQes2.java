// Question - https://leetcode.com/problems/excel-sheet-column-number/

import java.util.*;

public class LiveQes2 {

    public static int titleToNumber(String columnTitle) {
        int ans = 0;

        // isme humlog bas yahi kar rahe h ki ones place wala ko (26^0 * char ke hisaab
        // se value), tenth place wala ko (26^1 * char ke hisaab se value)............
        // de ke total fir sum karke nikaal denge. Exact jaise humlog binary to decimal
        // mein karte the
        for (int i = columnTitle.length() - 1, j = 0; i >= 0; i--, j++) {
            char ch = columnTitle.charAt(i);
            ans += (int) (Math.pow(26, j) * (ch - 'A' + 1));
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        System.out.println(titleToNumber(s));
        scn.close();
    }
}
