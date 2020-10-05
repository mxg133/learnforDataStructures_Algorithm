package _3dynamic.my;

/**
 * @author 孟享广
 * @date 2020-10-05 10:38 上午
 * @description
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        int val[] = {1500, 3000, 2000};//物品的价值
        int w[] = {1, 4, 3};//物品的重量
        int n = val.length;//物品的个数
        int m = 4;//背包的总重量

        //表示
        int v[][] = new int[n + 1][m + 1];//[][5]
        //记录放入商品的情况
        int path[][] = new int[n + 1][m + 1];

        //将第一列设置为0
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }
        //将第一行设置为0
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }

        //开始动态处理
        for (int i = 1; i < v.length; i++) {//第一行 就不处理了！！！！
            for (int j = 1; j < v[0].length; j++) {//第一列 就不处理了！！！！
                if (j < w[i - 1]) {
                    v[i][j] = v[i - 1][j];
                }else {
                    v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
                    //为了记录存贮情况 不能简单的使用Math.max()
                    if (v[i - 1][j] < (val[i - 1] + v[i - 1][j - w[i - 1]])) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    }else {
                        v[i][j] = v[i - 1][j];
                        path[i][j] = 0;
                    }
                }
            }
        }

        //打印二维数组
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[0].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
        //输出path
        //逆向遍历
        int i = path.length - 1;//行的最大下标
        int j = path[0].length - 1;//列的最大下标
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("第%d个商品->包包····\n", i);
                j -= w[i - 1];
            }
            i--;
        }
    }
}