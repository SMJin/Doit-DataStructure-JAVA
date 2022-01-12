package src.ch6.Insertion;

public class ShellSort {

    public static void shellSort(int[] array) {
        int len = array.length;
        for (int h=len/2; h>0; h/=2) {
            //System.out.println("-----h: " + h + " -----");
            for (int i=h; i<len; i++) {
                //System.out.println("♡i: " + i);
                int j;
                int tmp = array[i];
                //System.out.println("- tmp: " + tmp);
                for (j=i-h; j >= 0 && array[j] > tmp; j-=h) {
                    //System.out.println("j: " + j + ", array[j]: " + array[j]);
                    array[j+h]= array[j];
                }
                array[j+h] = tmp;
            }
        }
    }

    public static void shellSort2(int[] array) {
        int h, len = array.length;
        for(h=1; h<len/9; h=h*3+1)
            ;

        for ( ; h>0; h/=3) {
            for (int i=h; i<len; i++) {
                int j;
                int tmp = array[i];
                for (j=i-h; j>=0 && array[j] > tmp; j-=h) {
                    array[j+h] = array[j];
                }
                array[j+h] = tmp;
            }
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
        int[] array = {8,1,4,2,7,6,3,5};
        showArray(array);
        shellSort(array);
        showArray(array);

        System.out.println();
        int[] array2 = {8,1,4,2,7,6,3,5};
        showArray(array2);
        shellSort2(array2);
        showArray(array2);
    }
}
