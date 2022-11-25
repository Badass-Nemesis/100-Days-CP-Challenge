// Question -> https://leetcode.com/problems/subarray-sums-divisible-by-k/

import java.util.*;

public class Qes1 {
    public int subarraysDivByK(int[] nums, int k) {
        int[] prefixSumThenMod = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prefixSumThenMod[i] = nums[i];
            } else {
                prefixSumThenMod[i] = prefixSumThenMod[i - 1] + nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            // if (prefixSumThenMod[i] < 0) {
            // prefixSumThenMod[i] = prefixSumThenMod[i] % k + k;
            // } else {
            // prefixSumThenMod[i] = prefixSumThenMod[i] % k;
            // }
            prefixSumThenMod[i] = (prefixSumThenMod[i] % k + k) % k;
        }

        // ye h main part/block. isme humlog ye try kar rahe h, ki mod lene ke baad
        // humlog iterate kar rahe h, aur jo mera prefixSumThenMod wala mein aa raha h
        // wo index pe, to humlog check karenge ki wo hashmap mein h ya ni. hm mein jo
        // mila humlog ko, wo ek chij batata h ki agar prefixsum[i] pe jo mera mod aa
        // raha h wo pehle kitni baar aaya h, kyunki jaise karan bhaiya bataye the ki
        // [(SUM-s)%k=0 => SUM%k = s%k] uske hisaab se agar wo index se pehle bhi aaya
        // hua hoga koi same mod wala, to fir humlog subarray count karne ke liye usko
        // count+=hm.getkey kar denge.
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1); // first mein jab kuch ni tha tab wo bhi ek subarray tha jo divisible tha k se
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(prefixSumThenMod[i]) == false) {
                hm.put(prefixSumThenMod[i], 1);
            } else {
                hm.put(prefixSumThenMod[i], hm.get(prefixSumThenMod[i]) + 1);
            }
            count += hm.get(prefixSumThenMod[i]) - 1; // dunno why I did -1, but without it I was getting WA
        }

        return count;
    }
}
