package _7kruskal.my;

import java.util.Arrays;

/**
 * @author 孟享广
 * @date 2020-10-07 8:52 上午
 * @description
 */
public class KruskalCase {
    public static void main(String[] args) {
        char vertexs[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int matrix[][] = {
                    /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
            /*A*/ {   0,  12, INF, INF, INF,  16,  14},
            /*B*/ {  12,   0,  10, INF, INF,   7, INF},
            /*C*/ { INF,  10,   0,   3,   5,   6, INF},
            /*D*/ { INF, INF,   3,   0,   4, INF, INF},
            /*E*/ { INF, INF,   5,   4,   0,   2,   8},
            /*F*/ {  16,   7,   6, INF,   2,   0,   9},
            /*G*/ {  14, INF, INF, INF,   8,   9,   0}
        };

        KruskalCase kruskalCase = new KruskalCase(vertexs, matrix);

        kruskalCase.show();

        Edata[] edgess = kruskalCase.getEdgess();

        System.out.println(Arrays.toString(edgess));

        kruskalCase.sortEdges(edgess);

        System.out.println(Arrays.toString(edgess));

        kruskalCase.kruskal();

    }
    private int edgeNum;//记录 边的个数
    private char vertexs[];//存贮 结点的数组
    private int matrix[][];//邻接矩阵
    //表示 两个结点 不能连通
    private static final int INF = Integer.MAX_VALUE;

    public KruskalCase(char[] vertexs, int[][] matrix) {
        //初始化 结点 的个数
        int vLen = vertexs.length;
        this.vertexs = vertexs;
        this.matrix = matrix;

        //初始化 edgeNum
        for (int i = 0; i < vLen; i++) {
            for (int j = i + 1; j < vLen; j++) {
                if (this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    public void show() {
        System.out.println("进入show()中······");
        System.out.println("正在打印 邻接矩阵······");
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                System.out.printf("%12d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    //排序
    public void sortEdges(Edata edges[]) {
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - 1 - i; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    Edata tmp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = tmp;
                }
            }
        }
    }

    //返回 'A' 的下标  否则返回-1
    public int getPosition(char ch) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == ch) {//找到了
                return i;//
            }
        }
        return -1;//找不到了
    }

    public Edata[] getEdgess() {
        int index = 0;
        Edata edges[] = new Edata[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new Edata(vertexs[i], vertexs[j], matrix[i][j]);
                }

            }
        }
        return edges;
    }

    //获取下标为i的结点的终点  用于后面判断两个结点的终点是否相同
    private int getEnd(int ends[], int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }

    public void kruskal() {
        int index = 0;
        //存贮每个最小生成树的终点
        int ends[] = new int[edgeNum];
        //创建结果数组
        Edata rets[] = new Edata[edgeNum];

        //获取图中所有的边 的集合
        Edata edges[] = getEdgess();
        System.out.println("获取边的集合" +
                Arrays.toString(edges) + " 一共：" + edges.length);

        sortEdges(edges);

        //判断准备加入的边 是否能够成回路
        for (int i = 0; i < edgeNum; i++) {
            //获取第 i 条边的第一个顶点
            int p1 = getPosition(edges[i].start);
            int p2 = getPosition(edges[i].end);

            //获取p1结点 在已有最小生成树中的终点
            int m = getEnd(ends, p1);
            int n = getEnd(ends, p2);

            if (m != n) {
                ends[m] = n;
                rets[index++] = edges[i];
            }

        }

        System.out.println();
        for (int i = 0; i < index; i++) {
            if (i == 0) {
                System.out.println("最小生成树为： ");
            }
            System.out.println(rets[i]);
        }

    }
}

//表示一个边
class Edata {
    char start;//边的起点
    char end;//边的另外一个点
    int weight;//权值

    public Edata(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "边：" +
                "" + start +
                "-" + end +
                "=" + weight;
    }
}