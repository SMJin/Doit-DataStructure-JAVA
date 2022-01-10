package src.ch6.Bubble;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_23968 {
    public static void main(String[] args) {
        scan.init();

        int n = scan.nextInt();
        int k = scan.nextInt();

        int[] array = new int[n];
        for (int i=0; i<n; i++)
        {
            array[i] = scan.nextInt();
        }

        bubbleSort(array, k);
    }

    public static int[] bubbleSort(int[] array, int k)
    {
        int result = 0;

        int len = array.length;
        for(int i=len; i>1; i--) {
            //System.out.println("i: " + i);
            for(int j=1; j<i; j++) {
                //System.out.println("j: " + j);
                if (array[j] < array[j-1]) {
                    swap(array, j-1, j);
                    result ++;
                    //System.out.println("Result: " + result);
                }

                if (result == k) {
                    System.out.println(array[j-1] + " " + array[j]);
                    break;
                }
            }
            if (result == k)
                break;
        }

        if (result < k)
            System.out.println("-1");

        return array;
    }

    private static void swap(int[] array, int i, int j) {
        //System.out.println("[" + i + "]" + array[i] + "와 " + "[" + j + "]" + array[j] + "를 swap 합니다.");

        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
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
