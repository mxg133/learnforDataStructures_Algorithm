package _1binarysearchnorecursion.my;

/**
 * @author 孟享广
 * @date 2020-10-03 5:00 下午
 * @description
 */
public class BinarySearchNoRecur {
    public static void main(String[] args) {
        int[] arr = {1,3, 8, 10, 11, 67, 100};
        int index = binarySearch(arr, 1);
        System.out.println(index);
    }

    //返回下标
    public static int binarySearch(int arr[], int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            }else if (arr[left] < arr[mid]) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
