package src.ch3.binarySearch;

public class BinarySearch {

    static int binSearchX(int[] a, int n, int key)
    {
        int left=0;
        int right = n-1;

        int resultIdx = -1;

        do
        {
            int center = (left + right)/2;
            if (a[center] == key) {
                resultIdx = center;
                break;
            }
            else if (a[center] < key)
                right = center + 1;
            else
                left = center - 1;
        } while (left <= right);

        while((resultIdx>0) && (a[resultIdx-1] == a[resultIdx]))
        {
            resultIdx--;
        }

        return resultIdx;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 7, 7, 7, 8, 8, 9, 9};
        int n = array.length;
        int key = 7;

        System.out.print("array에 저장되어 있는 key값 " + key + "의 첫 인덱스 : ");
        System.out.println(binSearchX(array, n, key));
    }
}
