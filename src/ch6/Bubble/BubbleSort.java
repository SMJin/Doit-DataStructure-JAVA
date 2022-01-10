package src.ch6.Bubble;

public class BubbleSort {
    public void showArray(int[] array)
    {
        int i;
        for (i=0; i< array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void sort1(int[] array)
    {
        int comp = 0;
        int i, j;
        int len = array.length-1;
        for(i=0; i<len; i++) {
            for (j=len-i; j>0; j--) {
                comp++;
                if (array[j] < array[j-1])
                    swap(array, j, j-1);
            }
        }
        System.out.println("총 비교 횟수는 " + comp + "번 입니다.");
    }

    public void sort2(int[] array)
    {
        int comp = 0;
        int exchg = 0;
        int i, j;
        int len = array.length-1;
        for(i=0; i<len; i++) {
            int ex = 0;
            for (j=len-i; j>0; j--) {
                comp++;
                if (array[j] < array[j-1]) {
                    ex++;
                    swap(array, j, j-1);
                }
            }
            exchg += ex;
            if (ex == 0)
                break;
        }
        System.out.println("총 비교 횟수는 " + comp + "번 입니다.");
        System.out.println("총 교환 횟수는 " + exchg + "번 입니다.");
    }

    public void sort3(int[] array)
    {
        int comp = 0;
        int exchg = 0;
        int end = 0;
        int i, j;
        int len = array.length-1;
        for(i=0; i<len; i++) {
            int ex = 0;
            int last = 0;
            for (j=len-i; j>end; j--) {
                comp++;
                if (array[j] < array[j-1]) {
                    ex++;
                    swap(array, j, j-1);
                    last = j;
                }
            }
            end = last;
            exchg += ex;
            if (ex == 0)
                break;
        }
        System.out.println("총 비교 횟수는 " + comp + "번 입니다.");
        System.out.println("총 교환 횟수는 " + exchg + "번 입니다.");
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args)
    {
        int[] array = {6,4,3,7,1,9,8};
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println("-- array1 --");
        bubbleSort.showArray(array);
        bubbleSort.sort1(array);
        bubbleSort.showArray(array);

        System.out.println("\n-- array2 --");
        int[] array2 = {6,4,3,7,1,9,8};
        bubbleSort.showArray(array2);
        bubbleSort.sort2(array2);
        bubbleSort.showArray(array2);

        System.out.println("\n-- array3 --");
        int[] array3 = {6,4,3,7,1,9,8};
        bubbleSort.showArray(array3);
        bubbleSort.sort3(array3);
        bubbleSort.showArray(array3);
    }
}
