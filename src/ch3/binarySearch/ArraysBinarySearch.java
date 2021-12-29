package src.ch3.binarySearch;

import java.util.Arrays;

public class ArraysBinarySearch {
    public static void main(String[] args)
    {
        int[] array = {15, 27, 39, 77, 92, 108, 121};
        int key = 17;
        System.out.println("찾을 key 값은 " + key + " 입니다.");

        int idx = Arrays.binarySearch(array, key);

        if (idx < 0)
            System.out.println("그 값의 요소가 없습니다."
                    +" 삽입을 하시려면 " + ((-idx) - 1) + "번째가 적절한 것 같습니다.");
        else
            System.out.println(key + "은(는) x[" + idx + "]에 있습니다.");
    }
}
