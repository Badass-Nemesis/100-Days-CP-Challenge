// Question -> https://leetcode.com/problems/assign-cookies/description/

import java.util.*;

public class Qes2 {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int childrenPointer = g.length - 1;
        int cookiesPointer = s.length - 1;
        int count = 0;
        while (cookiesPointer >= 0 && childrenPointer >= 0) {
            if (g[childrenPointer] <= s[cookiesPointer]) {
                count++;
                cookiesPointer--;
            }
            childrenPointer--;
        }

        return count;
    }
}
