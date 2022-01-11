package src.ch6.Bubble;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_23970 {

    public static int BubbleSort(int[] a, int[] b) {
        int bi = 0;

        int len = a.length;
        for(int last=len; last>1; last--) {
            for (int j=1; j<last; j++) {
                if (a[j-1] > a[j]) {
                    //System.out.println("swap!");
                    swap(a, j-1, j);
                }
                //System.out.println("bi: " + bi + ", b[bi]: " + b[bi]);
                //System.out.println("j-1: " + (j-1) + ", a[j-1]: " + a[j-1]);
                while ((bi == j-1) && (b[bi] == a[j-1])) {
                    //System.out.println("bi++");
                    bi++;
                }
                if (((bi+1) == len-1) && (b[++bi] == a[bi]))
                    return 1;
            }
        }
        return 0;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        scan.init();

        int n = scan.nextInt();

        int[] A = new int[n];
        int[] B = new int[n];

        int i;
        for (i=0; i<n; i++) {
            A[i] = scan.nextInt();
        }
        for (i=0; i<n; i++) {
            B[i] = scan.nextInt();
        }

        System.out.println(BubbleSort(A, B));
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
