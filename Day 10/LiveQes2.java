// Question -> https://codeforces.com/contest/1759/problem/E

import java.util.*;
import java.io.*;

public class LiveQes2 {

    /*
     * #include <bits/stdc++.h>
     * using namespace std;
     * int solve(int n,long long int power,int arr[],int g,int b,int i){
     * int index = i;
     * while(index<n && power>arr[index]){
     * power+=arr[index]/2;
     * index++;
     * }
     * if(i==n){
     * return n;
     * }
     * 
     * if(g==0 && b==0){
     * return index;
     * }
     * int ans = 0;
     * if(g>=1){
     * ans = solve(n,power*2,arr,g-1,b,index);
     * }
     * int ans1 = 0;
     * if(b>=1){
     * ans1 = solve(n,power*3,arr,g,b-1,index);
     * }
     * return max(ans,ans1);
     * 
     * }
     * int main(){
     * int t;
     * cin>>t;
     * 
     * while(t--){
     * 
     * int n;
     * cin>>n;
     * long long int power;
     * cin>>power;
     * int arr[n];
     * for(int i=0;i<n;i++){
     * cin>>arr[i];
     * }
     * sort(arr,arr+n);
     * int ans =solve(n,power,arr,2,1,0);
     * cout<<ans<<endl;
     * }
     * }
     */

    public static int solve2(int n, long power, long[] arr, int green, int blue, int i) throws IOException {
        // System.out.println("i = " + i); // debug
        int index = i;
        while (index < n && power > arr[index]) {
            power += (arr[index] / 2);
            index++;
        }

        if (i == n) {
            return n;
        }

        if (green == 0 && blue == 0) {
            // System.out.println("index " + index); // debug
            return index;
        }

        int ans = 0;
        // System.out.println("green pre " + green); // debug
        if (green > 0) {
            ans = solve2(n, power * 2, arr, green - 1, blue, index);
            // System.out.println("ans  = " + ans); // debug
        }
        // System.out.println("green post " + green); // debug

        int ans1 = 0;
        // System.out.println("blue pre " + blue); // debug
        if (blue > 0) {
            ans1 = solve2(n, power * 3, arr, green, blue - 1, index);
            // System.out.println("ans1 = " + ans1); // debug
        }
        // System.out.println("blue post " + blue); // debug

        return Math.max(ans1, ans);
    }

    public static void solve(int n, long power, long[] arr, ArrayList<ArrayList<Integer>> serum)
            throws IOException {
        int ans = 0; // for max consume count

        for (int i = 0; i < 3; i++) {
            int index = 0;
            int count = 0; // for temporary consume count
            long tempPower = power;
            for (int j = 0; j < n; j++) {
                if (tempPower > arr[j]) {
                    tempPower = tempPower + (arr[j] / 2);
                    count++;
                } else {
                    if (index == 3) {
                        break;
                    }
                    tempPower = tempPower * serum.get(i).get(index);
                    // System.out.println(i + " " + serum.get(i).get(index) + " " + index);
                    j--;
                    index++;
                }
            }
            // System.out.println(count);
            ans = Math.max(count, ans);
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        in = new Reader();
        out = new PrintWriter(new OutputStreamWriter(System.out));

        int t = in.nextInt();
        ArrayList<ArrayList<Integer>> serum = new ArrayList<>();
        ArrayList<Integer> serum1 = new ArrayList<>(); // 3 2 2
        serum1.add(2);
        serum1.add(2);
        serum1.add(3);
        serum.add(serum1);
        ArrayList<Integer> serum2 = new ArrayList<>(); // 2 3 2
        serum2.add(2);
        serum2.add(3);
        serum2.add(2);
        serum.add(serum2);
        ArrayList<Integer> serum3 = new ArrayList<>(); // 2 2 3
        serum3.add(3);
        serum3.add(2);
        serum3.add(2);
        serum.add(serum3);

        // int temp = 0;
        // for (int i = 0; i < serum.get(temp).size(); i++) {
        // System.out.println(serum.get(temp).get(i));
        // }
        for (int i = 0; i < t; i++) {
            int astro = in.nextInt();
            long power = in.nextLong();
            long[] arr = new long[astro];
            for (int j = 0; j < astro; j++) {
                arr[j] = in.nextLong();
            }
            Arrays.sort(arr);
            // int green = 2;
            // int blue = 1;
            // int ans = solve(astro, power, arr, green, blue, 0);
            // System.out.println(ans);
            solve(astro, power, arr, serum);
        }

        out.flush();
        in.close();
        out.close();
    }

    private static int gcd(int a, int b) {

        // old snippet code
        /*
         * if (a == 0 || b == 0)
         * return 0;
         * while (b != 0) {
         * int tmp;
         * tmp = a % b;
         * a = b;
         * b = tmp;
         * }
         * return a;
         */

        // the code that I understood
        /*
         * if (b == 0) {
         * return a;
         * }
         * if (b > a) {
         * return gcd(b-a, a);
         * } else {
         * return gcd(a-b, b);
         * }
         */

        // the code that I use
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);

    }

    static final long mod = 1000000007;

    static long pow_mod(long a, long b) {
        long result = 1;
        while (b != 0) {
            if ((b & 1) != 0)
                result = (result * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return result;
    }

    private static int nCrModp(int n, int r, int p) {
        if (r > n - r) {
            r = n - r;
        }

        long[] C = new long[r + 1];
        Arrays.fill(C, 0);

        C[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = Math.min(i, r); j > 0; j--) {
                C[j] = (C[j] + C[j - 1]) % p;
            }
        }

        return (int) C[r];
    }

    private static long multiplied_mod(long... longs) {
        long ans = 1;
        for (long now : longs) {
            ans = (ans * now) % mod;
        }
        return ans;
    }

    @SuppressWarnings("FieldCanBeLocal")
    private static Reader in;
    private static PrintWriter out;

    private static int[] read_int_array(int len) throws IOException {
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = in.nextInt();
        }
        return a;
    }

    private static long[] read_long_array(int len) throws IOException {
        long[] a = new long[len];
        for (int i = 0; i < len; i++) {
            a[i] = in.nextLong();
        }
        return a;
    }

    private static void print_array(int[] array) {
        for (int now : array) {
            out.print(now);
            out.print(' ');
        }
        out.println();
    }

    private static void print_array(long[] array) {
        for (long now : array) {
            out.print(now);
            out.print(' ');
        }
        out.println();
    }

    static class Reader {
        private static final int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            final byte[] buf = new byte[1024]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    break;
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextSign() throws IOException {
            byte c = read();
            while ('+' != c && '-' != c) {
                c = read();
            }
            return '+' == c ? 0 : 1;
        }

        private static boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        public int skip() throws IOException {
            int b;
            // noinspection ALL
            while ((b = read()) != -1 && isSpaceChar(b)) {
                ;
            }
            return b;
        }

        public char nc() throws IOException {
            return (char) skip();
        }

        public String next() throws IOException {
            int b = skip();
            final StringBuilder sb = new StringBuilder();
            while (!isSpaceChar(b)) { // when nextLine, (isSpaceChar(b) && b != ' ')
                sb.appendCodePoint(b);
                b = read();
            }
            return sb.toString();
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            final boolean neg = c == '-';
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg) {
                return -ret;
            }
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            final boolean neg = c == '-';
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) {
                return -ret;
            }
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            final boolean neg = c == '-';
            if (neg) {
                c = read();
            }

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg) {
                return -ret;
            }
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            din.close();
        }

    }
}