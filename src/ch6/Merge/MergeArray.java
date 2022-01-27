package src.ch6.Merge;

import java.util.Scanner;

public class MergeArray {
    static void merge(int[] a, int na, int[] b, int nb, int[] c) {
        int pa=0, pb=0, pc=0;

        while(pa < na && pb < nb) {
            c[pc++] = (a[pa] <= b[pb]) ? a[pa++] : b[pb++];
        }

        while (pa < na) {
            c[pc++] = a[pa++];
        }

        while (pb < nb) {
            c[pc++] = b[pb++];
        }
    }

    static void print(String name, int[] array) {
        System.out.print(name+" = ");
        for (int i=0; i<array.length; i++)
            System.out.print(array[i]+" ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int[] a = {2,4,6,8,11,13};
        int[] b = {1,2,3,4,9,16,21};
        int[] c = new int[13];

        System.out.println("두 배열의 병합");
        merge(a, a.length, b, b.length, c);

        System.out.println("배열 a와 b를 병합하여 배열 c에 저장했습니다.");
        System.out.println("배열 a: "); print("a", a);
        System.out.println("배열 b: "); print("b", b);
        System.out.println("배열 c: "); print("c", c);

    }

}
