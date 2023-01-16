// Question -> https://leetcode.com/problems/get-the-maximum-score/

class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        int firstP = 0;
        int secondP = 0;
        long firstSum = 0;
        long secondSum = 0;
        long totalSum = 0;

        while (firstP != nums1.length && secondP != nums2.length) {
            if (nums1[firstP] == nums2[secondP]) {
                totalSum += Math.max(firstSum, secondSum) + nums1[firstP];
                totalSum = totalSum % 1000000007;
                firstSum = 0;
                secondSum = 0;
                firstP++;
                secondP++;
            } else if (nums1[firstP] < nums2[secondP]) {
                firstSum += nums1[firstP];
                firstP++;
            } else if (nums1[firstP] > nums2[secondP]) {
                secondSum += nums2[secondP];
                secondP++;
            }

        }

        while (firstP != nums1.length) {
            firstSum += nums1[firstP];
            firstP++;
        }

        while (secondP != nums2.length) {
            secondSum += nums2[secondP];
            secondP++;
        }

        totalSum += Math.max(firstSum, secondSum);
        totalSum = totalSum % 1000000007;

        return (int) totalSum;
    }
}