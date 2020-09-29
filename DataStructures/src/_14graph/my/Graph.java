package _14graph.my;

import java.util.ArrayList;

/**
 * @author 孟享广
 * @date 2020-09-29 11:41 上午
 * @description
 */
public class Graph {
    public static void main(String[] args) {
        int n = 5;//结点的个数
        String Vertexs[] = {
                "A", "B", "C", "D", "E",
        };

        Graph graph = new Graph(n);
        for (String value: Vertexs) {
            graph.insertVertex(value);
        }

        //添加边
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        graph.show();

        System.out.println("深度");
        graph.dfs();
    }

    private ArrayList<String> vertexList;//存贮 顶点的集合
    private int edges[][];//存贮 图的对应的邻结矩阵
    private int numOfEdges;//存贮 表示边的个数
    private boolean isVisited[];

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    //插入结点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    //添加边
    /**
     * @param v1 表示 点的下标 即使第几个顶点 "A"-"B"
     * @param v2 表示 另一个点的下标 即使第几个顶点 "A"-"B"
     * @param weight 权值 1 有关系 0 无关系
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    //返回结点个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //返回边的个数
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //返回结点i下标的数据0-"A"
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //返回v1 v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //显示图对应的矩阵
    public void show() {
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[0].length; j++) {
                System.out.print(edges[i][j] + " ");
            }
            System.out.println();
        }
    }

    //得到第一个邻接结点的下标
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    //根据前一个邻接结点的下标来获取下一个邻接结点
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    //深度优先算法
    public void dfs(boolean isVisited[], int i) {
        System.out.print(getValueByIndex(i) + "->");
        //将该结点设置为已访问
        isVisited[i] = true;
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            w = getNextNeighbor(i, w);
        }
    }

    //对dfs重载
    public void dfs() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

}
