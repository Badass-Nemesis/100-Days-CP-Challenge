// Question -> https://leetcode.com/problems/relative-sort-array/description/

public class LiveQes2 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length];
        int[] freqArr = new int[1001];
        for (int i = 0; i < arr1.length; i++) {
            freqArr[arr1[i]]++;
        }

        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (freqArr[arr2[i]] > 0) {
                ans[index] = arr2[i];
                index++;
                freqArr[arr2[i]]--;
            }
        }

        for (int i = 0; i < 1001; i++) {
            while (freqArr[i] > 0) {
                ans[index] = i;
                index++;
                freqArr[i]--;
            }
        }

        return ans;
    }
}
