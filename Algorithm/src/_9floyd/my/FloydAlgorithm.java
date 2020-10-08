package _9floyd.my;

import java.util.Arrays;

/**
 * @author 孟享广
 * @date 2020-10-08 10:15 上午
 * @description
 */
public class FloydAlgorithm {
    public static void main(String[] args) {
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;
        matrix[0] = new int[] {0, 5, 7, N, N, N, 2};
        matrix[1] = new int[] {5, 0, N, 9, N, N, 3};
        matrix[2] = new int[] {7, N, 0, N, 8, N, N};
        matrix[3] = new int[] {N, 9, N, 0, N, 4, N};
        matrix[4] = new int[] {N, N, 8, N, 0, 5, 4};
        matrix[5] = new int[] {N, N, N, 4, 5, 0, 6};
        matrix[6] = new int[] {2, 3, N, N, 4, 6, 0};

        Graph graph = new Graph(vertex.length, vertex, matrix);
        graph.floydAlgorithm();
        graph.shoe();
    }
}

class Graph {
    private char vertex[];
    private int dis[][];//保存 距离
    private int pre[][];//保存 目标结点的前驱结点

    public Graph(int lenth, char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.dis = matrix;
        this.pre = new int[lenth][lenth];
        for (int i = 0; i < lenth; i++) {
            Arrays.fill(pre[i], i);
        }
    }

    public void shoe() {
        for (int i = 0; i < dis.length; i++) {
            for (int j = 0; j < dis[0].length; j++) {
                System.out.print(vertex[pre[i][j]] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < pre.length; i++) {
            for (int j = 0; j < pre[0].length; j++) {
                System.out.print(vertex[i] + "->" + vertex[j] + " = " + dis[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void floydAlgorithm() {
        int len = 0;
        for (int k = 0; k < dis.length; k++) {
            for (int i = 0; i < dis.length; i++) {
                for (int j = 0; j < dis.length; j++) {
                    len = dis[i][k] + dis[k][j];
                    if (len < dis[i][j]) {
                        dis[i][j] = len;
                        pre[i][j] = pre[k][j];
                    }
                }
            }
        }
    }
}
