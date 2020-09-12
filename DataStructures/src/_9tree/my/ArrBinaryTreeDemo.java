package _9tree.my;

/**
 * @author 孟享广
 * @date 2020-09-12 9:19 上午
 * @description
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();
    }
}
class ArrBinaryTree {
    private int arr[];

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder() {
        this.preOrder(0);
    }

    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，，,  不能转换为二叉树的前序遍历·····");
            return;
        }
        System.out.print(arr[index] + " ");
        if ((2 * index + 1) < arr.length) {
            preOrder(2 * index + 1);
        }
        if ((2 * index + 2) < arr.length) {
            preOrder(2 * index + 2);
        }
    }
}
