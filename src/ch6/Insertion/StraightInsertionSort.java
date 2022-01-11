package src.ch6.Insertion;

public class StraightInsertionSort {

    public static void insertionSort(int[] array) {
        int i, j, len = array.length;
        for (i=1; i<len; i++) {
            //System.out.println("i: " + i + ", array[i]: " + array[i]);
            int current = array[i];
            //System.out.println("current: " + current);
            for (j=i; j>0 && current<array[j-1]; j--) {
                //System.out.println("j: " + j + ", array[j]: " + array[j]);
                array[j] = array[j-1];
            }
            array[j] = current;
        }
    }

    public static void showArray(int[] array) {
        int i, len = array.length;
        for (i=0; i<len; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {6,4,1,7,3,9,8};
        showArray(array);
        insertionSort(array);
        showArray(array);
    }
}
