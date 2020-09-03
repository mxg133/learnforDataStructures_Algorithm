package _7search.my;

import java.util.Arrays;

/**
 * @author 孟享广
 * @date 2020-09-03 12:37 下午
 * @description
 */
public class _3InsertValueSearch {
    public static void main(String[] args) {
        int arr[] = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        System.out.println(insertValueSearch(arr, 0, arr.length - 1, 30));

    }

    public static int insertValueSearch(int arr[], int left, int right, int findVal) {
        System.out.println(111);
        if (left > right || findVal < arr[0] || arr[arr.length - 1] < findVal) {
            return -1;
        }
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        if (arr[mid] < findVal) {
            return insertValueSearch(arr, mid + 1, right, findVal);
        }else if (findVal < arr[mid]) {
            return insertValueSearch(arr, left, mid - 1, findVal);
        }else {
            return mid;
        }
    }
}
