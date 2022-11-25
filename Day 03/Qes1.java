// Question -> https://codeforces.com/contest/1598/problem/C

import java.util.*;
// import java.lang.*;
import java.io.*;

public class Qes1 {

    // public static void solve(int m, int sum, int[] arr, HashMap<Integer, Integer>
    // hm) {
    // int pairs = 0;
    // double sumTwo = (sum * 2.0) / m*1.0;
    // // System.out.println(sumTwo + " " + m);
    // if ((int) sumTwo != sumTwo) {
    // System.out.println(0);
    // return;
    // }

    // int need = (sum * 2) / m;

    // Set<Integer> keys = hm.keySet();
    // for (Integer key : keys) {
    // int frequency = hm.get(key);
    // if (hm.containsKey(need - key)) {
    // if (key == (need - key) && hm.get(key) > 2) {
    // pairs = frequency * (frequency - 1); // nC2 * 2
    // } else if (key != (need - key)) {
    // pairs += frequency * hm.get(need - key);
    // }
    // }
    // }

    // System.out.println(pairs / 2);
    // return;
    // }

    // public static void main(String[] args) {
    // Scanner scn = new Scanner(System.in);
    // int n = scn.nextInt();

    // for (int i = 0; i < n; i++) {
    // int m = scn.nextInt();
    // int[] arr = new int[m];
    // HashMap<Integer, Integer> hm = new HashMap<>();
    // int sum = 0;
    // for (int j = 0; j < m; j++) {
    // arr[j] = scn.nextInt();
    // sum += arr[j];
    // if (hm.containsKey(arr[j])) {
    // int frequency = hm.get(arr[j]) + 1;
    // hm.put(arr[j], frequency);
    // } else {
    // hm.put(arr[j], 1);
    // }
    // }

    // solve(m, sum, arr, hm);
    // }
    // scn.close();
    // }
    // }

    public static void solve() throws IOException {
        int n = in.nextInt();
        double[] arr = new double[n];

        long sum = 0;
        HashMap<Double, Long> fmap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
            sum += arr[i];
            if (fmap.containsKey(arr[i])) {
                fmap.put(arr[i], fmap.get(arr[i]) + 1);
            } else {
                fmap.put(arr[i], (long) 1);
            }
        }

        double sum_2_elements = ((2.0 * sum) / (n * 1.0));
        if ((int) sum_2_elements != sum_2_elements) {
            System.out.println(0);
            return;
        }
        long ans = 0;
        for (double val : fmap.keySet()) {
            double curr = val;
            double other = (double) sum_2_elements - val;

            if (curr == other) {
                ans += (fmap.get(val) * (fmap.get(val) - 1)) / 2;
                // fmap.remove(val);
                fmap.put(val, (long) 0);
            } else if (curr < other && fmap.containsKey(other)) {
                ans += fmap.get(val) * fmap.get(other);
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        in = new Reader();
        out = new PrintWriter(new OutputStreamWriter(System.out));

        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }

        out.flush();
        in.close();
        out.close();
    }

    private static int gcd(int a, int b) {
        if (a == 0 || b == 0)
            return 0;
        while (b != 0) {
            int tmp;
            tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
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