// Question - https://codeforces.com/problemset/problem/1671/C

import java.util.*;

public class LiveQes3 {

    public static long solve(long budget, long[] shops, long sum) {
        long ans = 0;
        long day = 0;
        for (int i = shops.length - 1; i >= 0; i--) {
            if (budget < sum) {
                // jabtak mera budget chota aate rahega, tabtak hum last wala element ko day+
                // karke remove karte jayenge i.e. current shop ko directly remove
                sum -= (shops[i] + day);
            } else {
                // day++;
                // ye tempCount bahut important chij h. basically humlog calculate kar rahe h ki
                // AP mein kitna elements h. matlab ki humlog a+(n-1)*d = budget leke bas 'n' ka
                // value nikaal rahe h, taaki ye pata chal jaye ki jitna shops abhi available h,
                // usse hum kitna din tak le sakte h.
                long tempCount = ((budget - sum) / (i + 1)) + 1;
                // System.out.println("t= " + tempCount);
                day += tempCount; // day mein 'n' ko add kar denge, kyunki utna din tak hum wo budget ke hisaab se
                                  // ek specific amount of shops se le sakte h
                ans = ans + tempCount * (i + 1); // ye basically humlog n * number of current shops kar rahe h taaki ans
                                                 // laa sake, jo pucha h qes mein

                // sum mein bas wahi, pehle n * current shops add kar le rahe h, uske baad
                // humlog last wala shop(i.e. high value shop) ko hata de rahe h. because humlog
                // jo logic use kar rahe h, i.e. total sum leke, fir check kar rahe h ki ye
                // specific amount of shops ka sum jo h, wo hum kitna din tak le sakte h......
                // to fir jitna din tak lena tha utna lene ke baad, ab last wala ko remove
                // karenge, tabhi jaake hum current shop count - 1 karke baaki shops/shop count
                // se samaan le payenge
                sum = sum + ((i + 1) * tempCount) - (shops[i] + day);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int testCases = scn.nextInt();
        for (int i = 0; i < testCases; i++) {
            int n = scn.nextInt();
            long budget = scn.nextInt();
            long[] shops = new long[n];
            long sum = 0;
            for (int j = 0; j < n; j++) {
                shops[j] = scn.nextLong();
                sum += shops[j];
            }
            Arrays.sort(shops);

            System.out.println(solve(budget, shops, sum));
        }
        scn.close();
    }
}
