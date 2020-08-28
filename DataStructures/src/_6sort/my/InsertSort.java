package _6sort.my;

import java.util.Arrays;

/**
 * @author 孟享广
 * @date 2020-08-28 10:28 上午
 * @description
 */
public class InsertSort {
    public static void main(String[] args) {
        int arr[] = {101, 34, 119, 1, -1, 89};

        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];//已经记录
            insertIndex = i-1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;


        }
            System.out.println(Arrays.toString(arr));
    }
}
