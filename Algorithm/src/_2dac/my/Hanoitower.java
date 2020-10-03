package _2dac.my;

/**
 * @author 孟享广
 * @date 2020-10-03 5:45 下午
 * @description
 */
public class Hanoitower {
    public static void main(String[] args) {
        hanoiTower(2, 'a', 'b', 'c');
    }

    /**
     *
     * @param num   num个盘子
     * @param a     a柱
     * @param b     b柱
     * @param c     c柱
     */
    public static void hanoiTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第一个盘子 从" + a + "->" + c);
        }else {
            hanoiTower(num - 1, a, c, b);
            System.out.println("第" + num + "个盘子 从" + a + "->" + c);
            hanoiTower(num - 1, b, a, c);
        }
    }
}
