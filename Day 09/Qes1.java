// Question -> https://codeforces.com/problemset/problem/1088/B

import java.util.*;
import java.io.*;

public class Qes1 {

    public static void solve(int n) throws IOException {
        int k = in.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int temp = in.nextInt();
            pq.add(temp);
        }

        int minus = 0;
        while (pq.size() > 0 && pq.peek() <= 0) {
            pq.remove();
        }
        for (int i = 0; i < k; i++) {
            if (pq.size() > 0) {
                // I need to re-understand the logic of this if block.
                int temp = pq.remove();
                System.out.println(temp - minus);
                minus += temp - minus;
                while (pq.size() > 0 && pq.peek() - minus <= 0) {
                    pq.remove();
                }
                // upto this line
            } else {
                System.out.println(0);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        in = new Reader();
        out = new PrintWriter(new OutputStreamWriter(System.out));

        int t = in.nextInt();
        solve(t);
        // for (int i = 0; i < t; i++) {
        // solve();
        // }

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