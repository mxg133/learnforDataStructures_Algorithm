package _6prim.my;

import java.util.Arrays;

/**
 * @author 孟享广
 * @date 2020-10-06 2:24 下午
 * @description
 */
public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        int weight[][] = {
            {10000,     5,          7,      10000,  10000,  10000,  2},//A
            {5,         10000,      10000,  9,      10000,  10000,  3},//B
            {7,         10000,      10000,  10000,  8,      10000,  10000},//C
            {10000,     9,          10000,  10000,  10000,  4,      10000},//D
            {10000,     10000,      8,      10000,  10000,      5,  4},//E
            {10000,     10000,      10000,  4,      5,      10000,  6},//F
            {2,         3,          10000,  10000,  4,      6,      10000}//G
        };

        MGraph graph = new MGraph(verxs);
        MinTree minTree = new MinTree();

        minTree.creatGraph(graph, verxs, data, weight);

//        minTree.showGraph(graph);

        minTree.prim(graph, 0);
    }
}

//创建最小生成树 存贮村庄的图
class MinTree {
    //创建图的邻接矩阵
    public void creatGraph(MGraph graph, int verxs, char data[], int weight[][]) {
        int ii, j1;
        for (int i = 0; i < verxs; i++) {
            graph.data[i] = data[i];
            for (int j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    public void showGraph(MGraph graph) {
        for (int link[]: graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    //编写算法，得到最小生成树
    public void prim(MGraph graph, int v) {
        //标记结点是否被访问过，默认为 0
        int[] visited = new int[graph.verxs];
        visited[v] = 1;//因为第一个肯定是默认已经访问了！！！！

        //记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;

        int minWeight = 10000;

        for (int k = 1; k < graph.verxs; k++) {


            for (int i = 0; i < graph.verxs; i++) {//被访问
                for (int j = 0; j < graph.verxs; j++) {//未被访问

                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            System.out.println(graph.data[h1] + " " + graph.data[h2] + " " + minWeight);
            visited[h2] = 1;
            minWeight = 10000;

        }
    }
}

class MGraph {
    int verxs;//存贮图的结点个数
    char data[];//存贮结点的数据
    int weight[][];//存贮边，即 邻接矩阵

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}