// Question -> https://www.codechef.com/submit/ADMINSHOP

import java.util.*;
// import java.lang.*;
// import java.io.*;

public class Qes2 {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        // iska logic yahi h ki pehle dekh lo ki ek aadmi ko n shops visit karne mein kitna time lagega, aur ek sabse chota shop ko pura visit karne mein saare aadmi log ko kitna time lagega. kyunki sabse chota shop agar ek baar full hua, tab tak mein dusra shops mein ghus jayega baaki aadmi log, aur is tarah se 1 hr mein har aadmi koi na koi shop visit kar liya hoga. iss tarah se dekhe to ek aadmi ko hi humlog dekh rahe h ki wo jhund mein wo single aadmi ko kitna time lagta h saare shops ghumne mein. aur max humlog isiliye le rahe h
        Scanner scn = new Scanner(System.in);
        int testCases = scn.nextInt();
        for (int i = 0; i < testCases; i++) {
            int shops = scn.nextInt();
            int admins = scn.nextInt();
            int[] capacityOfShops = new int[shops];
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < shops; j++) {
                capacityOfShops[j] = scn.nextInt();
                if (capacityOfShops[j] < min) {
                    min = capacityOfShops[j];
                }
            }

            int ans = admins / min;
            if (admins % min != 0) {
                ans++;
            }
            System.out.println(Math.max(ans, shops));
        }

        scn.close();
        return;
    }
}
