package _6sort.my;

import java.util.Arrays;

/**
 * @author 孟享广
 * @date 2020-08-27 5:22 下午
 * @description
 */
public class SelectSort {
    public static void main(String[] args) {
        int arr[] = {101, 34, 119, 1};
//        int temp = 0;
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = i; j < arr.length; j++) {
//                if (arr[i] > arr[j]) {
//                    temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[minIndex];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
