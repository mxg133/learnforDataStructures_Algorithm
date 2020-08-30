package _6sort.my;

import com.sun.source.tree.IfTree;

import java.util.Arrays;

/**
 * @author 孟享广
 * @date 2020-08-30 11:19 上午
 * @description
 */
public class _5QuickSort {
    public static void main(String[] args) {
        int arr[] = {-9, 78, 0, 23, -567, 0, 70};
        quickSoft(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSoft(int arr[], int left, int right) {
        int l = left;
        int r = right;
        int p = arr[(left + right) / 2];
        int temp = 0;
        while (l < r) {
            while (arr[l] < p) {
                l++;
            }
            while (p < arr[r]) {
                r--;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == p) {
                r--;
            }
            if (arr[r] == p) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            quickSoft(arr, left, r);
        }
        if (l < right) {
            quickSoft(arr, l, right);
        }
    }
}
