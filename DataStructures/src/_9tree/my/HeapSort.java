package _9tree.my;

import java.util.Arrays;

/**
 * @author 孟享广
 * @date 2020-09-13 10:44 上午
 * @description
 */
public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {4, 6, 8, 5, 9};
        heapSort(arr);

    }
    //堆排序的方法
    public static void heapSort(int arr[]) {
        System.out.println("进入堆排序的方法中······");
        int temp = 0;

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        for (int j = arr.length - 1; j > 0; j--) {
            //每次把 arr[0]这个最大值 交给 arr[j]最后这个位置
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;

            adjustHeap(arr, 0, j);
        }
        System.out.println(Arrays.toString(arr));

    }
    //将数组变换为一个 大顶堆

    /**
     * 功能:
     * @param arr 待调整的数组
     * @param i 表示非叶子结点在数组中的索引
     * @param lenght 对多少个元素进行调整
     */
    public static void adjustHeap(int arr[], int i, int lenght) {
        int temp = arr[i];

        for (int k = (2 * i + 1); k < lenght; k = 2 * k + 1) {
            if (k + 1 < lenght && arr[k] < arr[k + 1]) { //左<右
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];//值转移
                i = k;//下标转移
            }else {
                break;
            }
        }
        arr[i] = temp;
    }
}
