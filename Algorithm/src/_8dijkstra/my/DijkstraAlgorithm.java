package _8dijkstra.my;

import java.util.Arrays;

/**
 * @author 孟享广
 * @date 2020-10-07 3:34 下午
 * @description
 */
public class DijkstraAlgorithm {
    public static void main(String[] args) {
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        final int N = 65535;
        int matrix[][] = {
                {N, 5, 7, N, N, N, 2},
                {5, N, N, 9, N, N, 3},
                {7, N, N, N, 8, N, N},
                {N, 9, N, N, N, 4, N},
                {N, N, 8, N, N, 5, 4},
                {N, N, N, 4, 5, N, 6},
                {2, 3, N, N, 4, 6, N}
        };

        Graph graph = new Graph(vertex, matrix);
        graph.showGraph();
    }
}

class VisitedVertex {
    //记录各个结点是否访问过，1/0 会动态更新 010101101001
    public int already_arr[];
    //i 的 i-1  0123456789
    public int pre_visited[];
    //记录出发结点到其他结点的距离，G的最近结点的距离 让入dis中 65535,65535,65535,65535,65535,65535,0
    public int dis[];

    /**
     *
     * @param lenght 结点的个数
     * @param index 首结点对应的下标
     */
    public VisitedVertex(int lenght, int index) {
        this.already_arr = new int[lenght];
        this.pre_visited = new int[lenght];
        this.dis = new int[lenght];

        Arrays.fill(dis, 65535);
        this.dis[index] = 0;
    }

    //判断index是否被访问过 true
    public boolean in(int index) {
        return already_arr[index] == 1;
    }

    //更新首结点 到 index结点 的距离
    public void updateDis(int index, int len) {
        dis[index] = len;
    }

    /**
     * 更新结点的前序为index结点
     * @param pre
     * @param index
     */
    public void updatePre(int pre, int index) {
        pre_visited[pre] = index;
    }

    /**
     * 返回 首结点 到 index结点的距离
     * @param index
     */
    public int getDis(int index) {
        return dis[index];
    }
}

class Graph {
    private char vertex[];//顶点数组
    private int matrix[][];//邻接矩阵

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    public void showGraph() {
        for (int arr[]: matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public void dsj(int index) {
        VisitedVertex vv = new VisitedVertex(vertex.length, index);
    }
}