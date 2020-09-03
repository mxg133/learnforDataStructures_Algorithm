package _7search.my;

import java.util.Arrays;

/**
 * @author 孟享广
 * @date 2020-09-03 5:17 下午
 * @description
 */
public class _4FibonacciSearch {
    public static int maxSize = 20;
    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1234};
        System.out.println(Arrays.toString(fib()));

    }

    public static int[] fib(){
        int f[] = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < f.length; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    /**
     *
     * @param arr 数组
     * @param key 值
     * @return
     */
    public static int fibonacciSearch(int arr[], int key) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0;//fib的下标
        int mid = 0;
        int f[] = fib();
        while (f[k] - 1 < high) {
            k++;
        }
        int temp[] = Arrays.copyOf(arr, f[k]);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {
                high = mid - 1;
                k--;
            }
        }
        return mid;
    }

}
