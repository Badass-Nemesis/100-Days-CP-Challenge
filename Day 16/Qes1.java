// Question -> https://leetcode.com/problems/permutation-in-string/description/

import java.util.*;

class Solution {
    public String convertAndSort(String s) {
        char[] temp = s.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        s1 = convertAndSort(s1);

        String temp = "";
        int index = 0;
        while (index < s1.length()) {
            temp += s2.charAt(index);
            index++;
        }

        temp = convertAndSort(temp);

        for (int i = index; i < s2.length(); i++) {
            if (s1.equals(temp)) {
                return true;
            }

            temp = s2.substring(i - s1.length() + 1, i + 1);
            temp = convertAndSort(temp);
        }

        if (s1.equals(temp)) {
            return true;
        } else {
            return false;
        }
    }
}