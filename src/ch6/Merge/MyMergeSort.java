package src.ch6.Merge;

public class MyMergeSort {

    static void mergeSort(int[] a, int start, int end) {
        int center = (start+end)/2;

        if (a[start] > a[end]) swap(a, start, end);

        if (start < center) mergeSort(a, start, center);
        if (center+1 < end) mergeSort(a, center, end);
    }

    static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
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
        mergeSort(a, 0, a.length-1);

        System.out.println("오름차순으로 정렬했습니다.");
        print(a);

    }
}
