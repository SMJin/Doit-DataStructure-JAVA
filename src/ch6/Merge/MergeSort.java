package src.ch6.Merge;

public class MergeSort {
    static int[] buff;

    static void __mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int i;
            int center = (left + right)/2;
            int p=0;
            int j=0;
            int k=left;

            __mergeSort(a, left, center);
            if (center+1 < right)__mergeSort(a, center, right);

            for (i=left; i<=center; i++)
                buff[p++] = a[i];

            while (i <= right && j<p)
                a[k++] = (buff[j] <= a[i]) ? buff[j++] : a[i++];

            while (j < p)
                a[k++] = buff[j++];
        }
    }

    static void mergeSort(int[] a, int n) {
        buff = new int[n];

        __mergeSort(a, 0, n-1);

        buff = null;
    }

    static void print(int[] array) {
        for (int i=0; i<array.length; i++)
            System.out.print(array[i]+" ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {22,5,11,32,120,68,70};

        System.out.println("병합 정렬");
        print(a);
        mergeSort(a, a.length);

        System.out.println("오름차순으로 정렬했습니다.");
        print(a);

    }
}
