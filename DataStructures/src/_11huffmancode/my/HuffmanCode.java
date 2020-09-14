package _11huffmancode.my;

import java.util.*;

/**
 * @author 孟享广
 * @date 2020-09-14 9:10 上午
 * @description
 */
public class HuffmanCode {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length);//40

        List<Node> nodes = getNodes(contentBytes);
        System.out.println(nodes);

        Node huffmanTreeRoot = creathuffmanTree(nodes);
        huffmanTreeRoot.preOrder();

        getCodes(huffmanTreeRoot);
        System.out.println("生成hufuman编码表");
        System.out.println(huffmanCodes);

        byte[] huffmanCodeBytes = zip(contentBytes, huffmanCodes);
        System.out.println(Arrays.toString(huffmanCodeBytes));
    }

    //编写一个方法，将字符串对应的byte[] ， 通过生成的Huffman编码表 返回一个Huffman编码压缩后的byte[]

    /**
     *
     * @param bytes 原始字符串 对应的 对应的byte[] 就是 contentBytes[]
     * @param huffmanCodes 生成的Huffman编码map
     * @return 返回一个Huffman编码处理后的byte[] 8位一个
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b: bytes) {
            stringBuffer.append(huffmanCodes.get(b));
        }
//        System.out.println(stringBuffer.toString());
        //转为byte[]
        int len;
        if (stringBuffer.length() % 8 == 0) {
            len = stringBuffer.length() / 8;
        }else {
            len = stringBuffer.length() / 8 + 1;
        }

        //存储压缩后的byte数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;
        for (int i = 0; i < stringBuffer.length(); i+=8) {
            String strByte;
            if (i + 8 > stringBuffer.length()) {
                strByte = stringBuffer.substring(i);
            }else {
                strByte = stringBuffer.substring(i, i + 8);
            }
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeBytes;
    }



    private static List<Node> getNodes(byte bytes[]) {
        ArrayList<Node> nodes = new ArrayList<>();

        HashMap<Byte, Integer> counts = new HashMap<Byte, Integer>();
        for (byte b: bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            }else {
                counts.put(b, count + 1);
            }
        }
        //遍历map
        for (Map.Entry<Byte, Integer> entry: counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    private static Node creathuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;

            nodes.remove(leftNode);
            nodes.remove(rightNode);

            nodes.add(parent);
        }
        return nodes.get(0);
    }

    //编码表 97 -> 100
    static Map<Byte, String> huffmanCodes = new HashMap<Byte, String>();
    //存储路径 100
    static StringBuffer stringBuffer = new StringBuffer();

    //为了调用方便 重载一下
    private static Map<Byte, String> getCodes(Node root) {
        if (root == null) {
            return null;
        }
        getCodes(root.left, "0", stringBuffer);
        getCodes(root.right, "1", stringBuffer);
        return huffmanCodes;
    }
    /**
     * 将传入的node结点的所有叶子结点的hufuman编码得到，并放入到huffmanCodes中
     * @param node 传入结点
     * @param code 路径：左 0， 右 1
     * @param stringBuffer 用于拼接路径
     */
    private static void getCodes(Node node, String code, StringBuffer stringBuffer) {
        StringBuffer stringBuffer2 = new StringBuffer(stringBuffer);
        stringBuffer2.append(code);
        if (node != null) {
            if (node.data == null) {
                //非叶子结点
                //向左递归
                getCodes(node.left, "0", stringBuffer2);
                getCodes(node.right, "1", stringBuffer2);
            }else {
                //到 叶子结点
                huffmanCodes.put(node.data, stringBuffer2.toString());
            }
        }
    }

    private static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        }else {
            System.out.println("空");
        }
    }
}

class Node implements Comparable<Node>{
    Byte data;  //l i k
    int weight; //有多少个i l k······
    Node left;
    Node right;
    byte bytes[];

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "data=" + data + " weight=" + weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}