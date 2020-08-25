package _5recursion.my;

/**
 * @author 孟享广
 * @date 2020-08-25 9:58 上午
 * @description
 */
public class RecursionTest {
    public static void main(String[] args) {
        test(4);
        System.out.println();
        System.out.println(factorial(2));
    }

    public static void test(int n) {
        if (n > 2)
            test(n - 1);
        else
            System.out.println(n);
    }

    public static int factorial(int n) {
        if (n == 1)
            return 1;
        else
            return factorial(n - 1) * n;
    }
}
