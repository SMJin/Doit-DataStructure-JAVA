package src.ch6.Quick;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_24090 {
    static int count = 0;

    static void quickSort(int[] a, int pl, int pr, int k) {
        if (pl < pr) {
            int q = partition(a, pl, pr, k);
            quickSort(a, pl, q-1, k);
            quickSort(a, q+1, pr, k);
        }
    }

    static int partition(int[] a, int pl, int pr, int k) {
        int pivot = a[pr];
        //System.out.println("pivot 값은 " + pivot + "입니다.");
        int i = pl - 1;
        for (int j=pl; j<pr; j++) {
            if (a[j] <= pivot) {
                swap(a, ++i, j, k);
            }
        }

        //System.out.println("i+1: " + (i+1) + ", pr: " + pr);
        if (i+1 != pr) {
            swap(a, i+1, pr, k);
        }
        return i+1;
    }

    static void swap(int[] a, int i, int j, int k) {
        //System.out.println("swap a[" + i + "]:" + a[i] + ", a[" + j + "]:" + a[j]);
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
        count++;
        if (count == k) {
            if (a[i] < a[j])
                System.out.println(a[i] + " " + a[j]);
            else
                System.out.println(a[j] + " " + a[i]);
        }
        //showArray(a);
    }

    public static void showArray(int[] array) {
        for(int i=0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        scan.init();

        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] array = new int[n];

        int i;
        for (i=0; i<n; i++)
            array[i] = scan.nextInt();

        //showArray(array);
        quickSort(array, 0, array.length-1, k);
        //showArray(array);

        if (count < k) {
            System.out.println("-1");
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
