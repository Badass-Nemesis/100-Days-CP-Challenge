import java.util.*;
import java.io.*;

class Solution {
    public static int flipBits(int[] arr, int n) {
        // Write your code here
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                arr[i] = ++count;
            } else {
                count = 0;
            }
        }

        count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] >= 1) {
                arr[i] = Math.max(arr[i], ++count);
            } else {
                count = 0;
            }
        }

        int ans = -1;
        for (int i = 0; i < n; i++) {
            int tempCount = 0;
            int temp = 0;
            if (arr[i] == 0) {
                if (i == 0) {
                    tempCount = 0;
                } else {
                    tempCount += arr[i - 1];
                }
                while (i < n && arr[i] == 0) {
                    temp++;
                    i++;
                }

                if (i == n) {
                    return tempCount + temp;
                } else {
                    tempCount += (temp + arr[i]);
                }
            }

            ans = Math.max(ans, tempCount);
        }

        return ans;
    }
}
