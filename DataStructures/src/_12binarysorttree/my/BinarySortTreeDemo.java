package _12binarysorttree.my;

/**
 * @author 孟享广
 * @date 2020-09-26 9:05 上午
 * @description
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 0};
        binarySortTree binarySortTree = new binarySortTree();

        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }

        binarySortTree.infixorder();
        System.out.println("情况一：删除叶子结点");
        binarySortTree.delNode(7);
        binarySortTree.infixorder();
    }
}

class binarySortTree {
    private Node root;

    public void add(Node node) {
        if (root == null) {
            root = node;
        }else {
            root.add(node);
        }
    }

    public void infixorder() {
        if (root == null) {
            System.out.println("空的；无法遍历·····");
        }else {
            root.infixorder();
        }
    }

    public Node search(int value) {
        if (root == null) {
            return null;
        }else {
            return root.search(value);
        }
    }

    public Node searchParent(int value) {
        if (root == null) {
            return null;
        }else {
            return root.searchParent(value);
        }
    }

    //
    public int delRightTreeMin(Node node) {
        Node target = node;
        while (target.left != null) {
            target = target.left;
        }
        delNode(target.value);
        return target.value;
    }


    //删除结点
    public void delNode(int value) {
        if (root == null) {
            return;
        }else {
            Node targetNode = search(value);
            if (targetNode == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            Node parent = searchParent(value);
            //情况一：叶子结点
            if (targetNode.left == null && targetNode.right == null) {
                if (parent.left != null && parent.left.value == value) {
                    parent.left = null;
                }else if (parent.right != null && parent.right.value == value) {
                    parent.right = null;
                }
            }else if (targetNode.left != null && targetNode.right != null) {
                //情况三：含有左右子树
                int minValue = delRightTreeMin(targetNode.right);
                targetNode.value = minValue;
            }else {
                //情况二：只有一颗子树
                //只有左子结点
                if (targetNode.left != null) {
                    if (parent.left.value == value) {
                        parent.left = targetNode.left;
                    } else {
                        parent.right = targetNode.left;
                    }
                }else {
                    //只有右子结点
                    if (parent.left.value == value) {
                        parent.left = targetNode.right;
                    }else {
                        parent.right = targetNode.right;
                    }
                }
            }

        }

    }

}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return value + "";
    }

    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            }else {
                this.left.add(node);
            }
        }
        if (this.value < node.value) {
            if (this.right == null) {
                this.right = node;
            }else {
                this.right.add(node);
            }
        }
    }

    public void infixorder() {
        if (this.left != null) {
            this.left.infixorder();
        }

        System.out.println(this);

        if (this.right != null) {
            this.right.infixorder();
        }
    }

    //查找要删除的结点
    public Node search(int value) {
        if (this.value == value) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {// (this.value <= value)
            if (this.right == null){
                return null;
            }
            return this.right.search(value);
        }
    }

    //找要删除的父结点
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {
            return this;
        }else {
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            }else if (this.value <= this.value && this.right != null) {
                return this.right.searchParent(value);
            }else {
                return null;
            }
        }
    }

}
