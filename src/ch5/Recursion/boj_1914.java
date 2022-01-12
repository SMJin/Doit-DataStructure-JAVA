package src.ch5.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class boj_1914 {

    public static void hanoi(int n, int from, int to) {
        if (n>1)
            hanoi(n-1, from, 6-from-to);
        System.out.println(from + " " + to);
        if (n>1)
            hanoi(n-1, 6-from-to, to);
    }

    public static void main(String[] args) {
        scan.init();

        int n = scan.nextInt();
        BigInteger bi = new BigInteger("2");
        bi = bi.pow(n).subtract(BigInteger.ONE);
        System.out.println(bi);

        if (n<=20) {
            hanoi(n, 1, 3);
        }

    }

    static class scan {
        private static BufferedReader br;
        private static StringTokenizer st;

        static void init() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        static String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                }
            }
            return st.nextToken();
        }

        static int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
