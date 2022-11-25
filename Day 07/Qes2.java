// Question -> https://leetcode.com/problems/isomorphic-strings/description/

import java.util.*;

public class Qes2 {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> hm = new HashMap<>();
        HashSet<Character> usedChar = new HashSet<>();

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char sWalaCh = s.charAt(i);
            char tWalaCh = t.charAt(i);
            if (hm.containsKey(sWalaCh) == false) {
                if (usedChar.contains(tWalaCh) == true) {
                    return false;
                }

                hm.put(sWalaCh, tWalaCh);
                usedChar.add(tWalaCh);
            } else {
                if (hm.get(sWalaCh) != tWalaCh) {
                    return false;
                }
            }
        }

        return true;
    }
}
