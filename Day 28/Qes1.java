// Question -> https://leetcode.com/problems/wildcard-matching/

import java.util.*;

class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dpArr = new boolean[s.length() + 1][p.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            Arrays.fill(dpArr[i], false);
        }
        dpArr[0][0] = true;

        // basically marking all the places true, if we get string like this -> s= 'ab'
        // p= '******a'. then for the case (previous to a in s), we need to mark all of
        // the continuous star indexes as true.
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) != '*') {
                break;
            }
            dpArr[0][i] = true;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    dpArr[i][j] = dpArr[i - 1][j] || dpArr[i][j - 1] || dpArr[i - 1][j - 1];
                } else if (s.charAt(i - 1) != p.charAt(j - 1) && p.charAt(j - 1) != '?') {
                    dpArr[i][j] = false;
                } else {
                    dpArr[i][j] = dpArr[i - 1][j - 1];
                }
            }
        }

        return dpArr[s.length()][p.length()];
    }
}