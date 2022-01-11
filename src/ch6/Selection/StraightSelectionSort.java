package src.ch6.Selection;

public class StraightSelectionSort {

    public static void selectionSort(int[] array) {
        int len = array.length;

        for (int i=0; i<len; i++) {
            int minIdx = i;
            for (int j=i; j<len; j++) {
                if (array[minIdx] > array[j]) {
                    minIdx = j;
                }
            }
            swap(array, minIdx, i);
        }
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
        int[] array = {6,4,8,3,1,9,7};
        showArray(array);
        selectionSort(array);
        showArray(array);
    }
}
