package _7search.my;

/**
 * @author 孟享广
 * @date 2020-09-03 10:08 上午
 * @description
 */
public class _1SeqSearch {
    public static void main(String[] args) {
        int arr[] = { 1, 9, 11, -1, 34, 89 };
        int num = 11;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                System.out.println("下标为：" + i);
            }
        }
        System.out.println("");
    }
}
