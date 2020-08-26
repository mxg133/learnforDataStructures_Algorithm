package _5recursion.my;

/**
 * @author 孟享广
 * @date 2020-08-26 4:47 下午
 * @description
 */
public class Queue8 {
    int max = 8;
    int array[] = new int[max];
    static int conut = 0;
    static int judgeConut = 0;


    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println(conut);
        System.out.println(judgeConut);
    }

    private void check(int n) {
        if (n == max) {
//            System.out.println("n = 8,请退出程序");
            print();
            conut++;
            return;
        }
        for (int i = 0; i < max; i++) {
            //
            judgeConut++;
            array[n] = i;
            if (judge(n)) {
                check(n+1);
            }
            //冲突
            array[n] = i+1;
        }
    }
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;//不冲突
    }
    //
    private void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + 1 + "\t");
        }
        System.out.println();
    }
}
