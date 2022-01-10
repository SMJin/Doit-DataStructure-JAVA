package src.ch5.NonRecursion;

import src.ch4.Stack.IntStack;

public class Recur {
    static void recur1(int n) {
        if (n>0) {
            recur1(n - 1);
            System.out.print(n + " ");
            recur1(n - 2);
        }
    }

    static void recur2(int n) {
        while (n > 0) {
            recur2(n - 1);
            System.out.print(n + " ");
            n = n-2;
        }
    }

    static void recur3(int n) {
        IntStack s = new IntStack(n + 1);

        while(true) {
            if (n > 0) {
                s.push(n);
                n --;
                continue;
            }
            if (!s.isEmpty()) {
                n = s.pop();
                System.out.print(n + " ");
                n = n - 2;
                continue;
            }
            break;
        }
    }

    public static void main(String[] args)
    {
        recur1(4);
        System.out.println();
        recur2(4);
        System.out.println();
        recur3(4);
    }
}
