// Question -> https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/

import java.util.*;

class Solution {
    public boolean isSubsequence(String s1, String s2) {
        if (s2.length() > s1.length()) {
            return false;
        }

        int s1P = 0;
        int s2P = 0;
        while (s1P < s1.length() && s2P < s2.length()) {
            if (s1.charAt(s1P) == s2.charAt(s2P)) {
                s2P++;
            }
            s1P++;
        }

        if (s2P == s2.length()) {
            return true;
        } else {
            return false;
        }
    }

    public String findLongestWord(String s, List<String> dictionary) {
        String tempRes = "";

        // here we are sorting the string array dictionary in descending order. first,
        // if the length of the strings are equal, then we need to put the last string
        // in dictionary in first place. otherwise, we can just simple sort the strings
        // length wise, because we need the max length string first to get the ans.

        // dictionary.sort((String a, String b) -> a.length() == b.length() ?
        // a.compareTo(b) : b.length() - a.length());

        for (String str : dictionary) {
            if (isSubsequence(s, str) == true) {
                // writing same logic as above custom sorting. just checking length, and
                // checking str is smaller than tempRes in dictionary formatting
                if (str.length() > tempRes.length()
                        || (str.length() == tempRes.length() && str.compareTo(tempRes) < 1)) {
                    tempRes = str;
                }
            }
        }
        return tempRes;
    }
}