package src.ch6.Quick;

public class QuickSort {

    static void quickSort(int[] a, int pl, int pr) {
        int start = pl, end = pr;
        int pi = (pl+pr)/2;
        int pivot = a[pi];

        showArray(a);
        System.out.println("pivot 값은 " + pivot + "입니다.");
        System.out.println("(pl) a[" + pl + "]: " + a[pl]);
        System.out.println("(pr) a[" + pr + "]: " + a[pr]);

        do {
            while (a[pl] < pivot) pl++;
            while (a[pr] > pivot) pr--;
            //System.out.println("a[" + pl + "]: " + a[pl] + ", a[" + pr + "]: " + a[pr]);
            if (pl <= pr)
                swap(a, pl++, pr--);
            //showArray(a);
        } while(pl <= pr);

        if (start + 1 < pr)
            quickSort(a, start, pr);
        if ((pr+1) + 1 < end)
            quickSort(a, pr+1, end);
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void showArray(int[] array) {
        for(int i=0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {5,7,1,4,6,2,3,9,8};
        quickSort(array, 0, array.length-1);
    }
}
