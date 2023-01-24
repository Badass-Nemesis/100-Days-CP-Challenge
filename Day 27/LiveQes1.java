// Question -> https://leetcode.com/problems/minimum-cost-for-tickets/

class Solution {
    static int[] dpArr;

    static int recursion(int[] days, int[] cost, int currDays, int index) {
        if (currDays > days[days.length - 1]) {
            return 0;
        }

        if (dpArr[currDays] != -1) {
            return dpArr[currDays];
        }

        int ans = Integer.MAX_VALUE;

        if (currDays == days[index]) {
            ans = Math.min(ans, cost[0] + recursion(days, cost, currDays + 1, index + 1));
            ans = Math.min(ans, cost[1] + recursion(days, cost, currDays + 7, index + 1));
            ans = Math.min(ans, cost[2] + recursion(days, cost, currDays + 30, index + 1));
        } else {
            ans = recursion(days, cost, currDays + 1, index);
        }

        return dpArr[currDays] = ans;
    }

    public int mincostTickets(int[] days, int[] costs) {
        dpArr = new int[366];
        for (int i = 0; i < 366; i++) {
            dpArr[i] = -1;
        }

        return recursion(days, costs, days[0], 0);
    }
}