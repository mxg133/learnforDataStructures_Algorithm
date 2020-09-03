package _7search.my;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 孟享广
 * @date 2020-09-03 10:19 上午
 * @description
 */
public class _2BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1000, 1234};
        int arr1[] = {1,2,3,4,5,6,7,8,9};
        List<Integer> list = binarySearch1(arr, 0, arr.length - 1, 1000);
        System.out.println(list);
    }

    /**
     *
     * @param arr 数组
     * @param left 左索引
     * @param right 右索引
     * @param finalVal 值
     * @return 否则返回 -1
     */
    public static int binarySearch(int arr[], int left, int right, int finalVal) {

        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (midVal < finalVal) {
            return binarySearch(arr, mid + 1, right, finalVal);
        }else if (finalVal < midVal) {
            return binarySearch(arr, left, mid - 1, finalVal);
        }else {
            return mid;
        }
    }


    public static List<Integer> binarySearch1(int arr[], int left, int right, int finalVal) {
        System.out.println(111);

        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (midVal < finalVal) {
            return binarySearch1(arr, mid + 1, right, finalVal);
        }else if (finalVal < midVal) {
            return binarySearch1(arr, left, mid - 1, finalVal);
        }else {
            ArrayList<Integer> list = new ArrayList<Integer>();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != finalVal) {
                    break;
                }else {
                    list.add(temp);
                    temp--;
                }
            }
            list.add(mid);
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != finalVal) {
                    break;
                }else {
                    list.add(temp);
                    temp++;
                }
            }
            return list;
        }
    }
}




