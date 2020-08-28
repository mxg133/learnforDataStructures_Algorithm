package _6sort.my;

import java.util.Arrays;

/**
 * @author 孟享广
 * @date 2020-08-28 11:31 上午
 * @description
 */
public class _4ShellSort {
    public static void main(String[] args) {
        int arr[] = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//        int temp;

        for (int gap = arr.length / 2; gap > 0 ;gap /= 2) {
            for (int i = gap; i <arr.length; i++) {
                int index = i;
                int val = arr[index];
                if (val < arr[index - gap]) {
                    while ((index - gap) >= 0 && arr[index - gap] > val) {
                        arr[index] = arr[index - gap];
                        index -= gap;
                    }
                    arr[index] = val;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
//        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
//
//            for (int i = gap; i < arr.length; i++) {
//
//                for (int j = i - gap; j >= 0; j -= gap) {
//
//                    if (arr[j] > arr[j + gap]) {
//                        temp =  arr[j];
//                        arr[j] = arr[j + gap];
//                        arr[j + gap] = temp;
//                    }
//                }
//            }
//        }

    }
}
