package src.ch6.Quick;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_24091_center {
    static int count = 0;
    static int k;

    static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int pr = partition(array, start, end);
            if (start < pr)
                quickSort(array, start, pr);
            if (pr+2 < end)
                quickSort(array, pr+1, end);
        }
    }

    static int partition(int[] a, int s, int e) {
        int pivot = a[(s+e)/2];
//        System.out.println("start: " + a[s]);
//        System.out.println("pivot: " + pivot);
//        System.out.println("end: " + a[e]);

        while (s <= e){
            while (a[s] < pivot) s++;
            while (pivot < a[e]) e--;
            if (s <= e)
                swap(a, s++, e--);
        }

        //showArray(a);

        return e;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
        count ++;
        if (count == k) {
            showArray(a);
        }
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
        k = scan.nextInt();
        int[] array = new int[n];

        int i;
        for (i=0; i<n; i++)
            array[i] = scan.nextInt();

        quickSort(array, 0, array.length-1);
        //showArray(array);
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
