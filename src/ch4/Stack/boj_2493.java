package src.ch4.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_2493 {
    public static void main(String[] args)
    {
        scan.init();
        int size = scan.nextInt();
        Stack<Integer> stk = new Stack<>();
        Stack<Integer> idx = new Stack<>();
        StringBuffer sb = new StringBuffer();

        int i;
        for (i=1; i<=size; i++)
        {
            int current = scan.nextInt();

            while (!stk.isEmpty())
            {
                if (stk.peek() >= current)
                {
                    sb.append(idx.peek() + " ");
                    break;
                }
                stk.pop();
                idx.pop();
            }
            if (stk.isEmpty())
                sb.append("0 ");

            stk.push(current);
            idx.push(i);
        }

        System.out.println(sb.toString());
    }

    //scan을 재정의함.
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
