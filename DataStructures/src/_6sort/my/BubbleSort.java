package _6sort.my;

import java.util.Arrays;

/**
 * @author 孟享广
 * @date 2020-08-27 1:28 下午
 * @description
 */
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = new int[]{3, 9, -1, 10, -2};
        int temp = 0;
        boolean flag = false;

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
    //                sort(arr[i], arr[i + 1]);
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            }else {
                flag = false;
            }


        }

        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int x, int y) {
        int temp = x;
        x = y;
        y = temp;
    }
}
