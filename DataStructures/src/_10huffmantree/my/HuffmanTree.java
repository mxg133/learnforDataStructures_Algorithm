package _10huffmantree.my;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Predicate;

/**
 * @author 孟享广
 * @date 2020-09-13 3:30 下午
 * @description
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int arr[] = { 13, 7, 8, 3, 29, 6, 1 };
        Node root = creatHuffmanYree(arr);

        preOrder(root);

    }

    public static void preOrder(Node root) {
        if (root != null) {
            root.preOreder();
        }else {
            System.out.println("空树····");
        }
    }

    public static Node creatHuffmanYree(int arr[]) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        for (int i = 0; i < arr.length; i++) {
            nodes.add(new Node(arr[i]));
        }

        while (nodes.size() > 1) {
            Collections.sort(nodes);
            System.out.println(nodes);

            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            Node parent = new Node(leftNode.value + rightNode.value);

            parent.left = leftNode;
            parent.right = rightNode;

            nodes.remove(leftNode);
            nodes.remove(rightNode);

            nodes.add(parent);
        }

        return nodes.get(0);

//        System.out.println(nodes);
    }
}

class Node implements Comparable<Node>{
    int value;//结点的权值
    Node left;//左 子结点
    Node right;//右 子结点

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + "";
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;//从小到大
    }

    //前序遍历
    public void preOreder() {
        System.out.print(this + " ");

        if (this.left != null) {
            this.left.preOreder();
        }

        if (this.right != null) {
            this.right.preOreder();
        }
    }
}
