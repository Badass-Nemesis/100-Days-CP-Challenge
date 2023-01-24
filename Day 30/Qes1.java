// Question -> https://leetcode.com/problems/remove-invalid-parentheses/

import java.util.*;

class Solution {
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push('(');
            } else if (s.charAt(i) == ')') {
                if (st.size() > 0 && st.peek() == '(') {
                    st.pop();
                } else {
                    return false;
                }
            }
        }

        return st.size() == 0 ? true : false;
    }

    public List<String> removeInvalidParentheses(String s) {
        if (isValid(s) == true) {
            List<String> ans = new ArrayList<>();
            ans.add(s);
            return ans;
        }

        Queue<String> queue = new ArrayDeque<>();
        Set<String> set = new HashSet<>();
        List<String> ans = new ArrayList<>();
        queue.add(s);
        int maxlength = -1;

        while (queue.size() != 0) {
            String temp = queue.remove();
            boolean foundOne = false;

            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) != '(' && temp.charAt(i) != ')') {
                    // do nothing
                } else {
                    String newString = temp.substring(0, i) + temp.substring(i + 1);

                    if (set.contains(newString) == false) {
                        queue.add(newString);
                        set.add(newString);
                        if (isValid(newString) == true) {
                            // foundOne = true;
                            maxlength = Math.max(maxlength, newString.length());
                        }
                    }
                }
            }
        }

        for (String temp : set) {
            if (temp.length() == maxlength && isValid(temp) == true) {
                ans.add(temp);
            }
        }

        return ans;
    }
}