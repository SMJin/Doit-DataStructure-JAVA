package src.ch6.Quick;

public class QuickSort {

    public static void quickSort(int[] a) {
        int len = a.length;
        int pivot = a[len/2];
        int pl = 0, pr = len-1;

        do {
            while (a[pl] < pivot) pl++;
            while (a[pr] > pivot) pr--;
            System.out.println("(pl) a[" + pl + "]: " + a[pl] +
                    ", (pr) a[" + pr + "]: " + a[pr]);
            if (pl <= pr) {
                swap(a, pl++, pr--);
            }
        } while (pl <= pr);
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
        showArray(a);
    }

    public static void showArray(int[] array) {
        for(int i=0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void showArray2(int[] array) {
        int i, len = array.length, pivot = len/2;
        System.out.print("pivot 이하의 그룹: ");
        for(i=0; i<pivot; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\npivot 값은 " + array[pivot] + "입니다.");
        System.out.print("pivot 이상의 그룹: ");
        for(i=pivot+1; i<len; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int[] array1 = {5,7,1,4,6,2,3,9,8};
        showArray(array1);
        quickSort(array1);
        showArray2(array1);

        System.out.println();
        int[] array2 = {1,8,7,4,5,2,6,3,9};
        showArray(array2);
        quickSort(array2);
        showArray2(array2);
    }
}
