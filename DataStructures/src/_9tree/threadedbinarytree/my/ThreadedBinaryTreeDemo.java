package _9tree.threadedbinarytree.my;

/**
 * @author 孟享广
 * @date 2020-09-12 10:47 上午
 * @description
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "");
        HeroNode node3 = new HeroNode(6, "");
        HeroNode node4 = new HeroNode(8, "");
        HeroNode node5 = new HeroNode(10, "");
        HeroNode node6 = new HeroNode(14, "");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        ThreadBinaryTree threadBinaryTree = new ThreadBinaryTree();

        threadBinaryTree.setRoot(root);

        threadBinaryTree.threadedNodes();

//        threadBinaryTree.threadedNodes(node5);
        HeroNode leftNode = node5.getLeft();
        System.out.println(leftNode);
        HeroNode node5Right = node5.getRight();
        System.out.println(node5Right);
    }
}

class ThreadBinaryTree {
    private HeroNode root;
    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void threadedNodes() {
        this.threadedNodes(root);
    }

    public void preOeder() {
        if (this.root != null) {
            this.root.preOrder();
        }else {
            System.out.println("空的！无法遍历！🈳");
        }
    }

    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        }
        System.out.println("空的！无法遍历！🈳");
    }

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        }
        System.out.println("空的！无法遍历！🈳");
    }

    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrdersearch(no);
        }else {
            return null;
        }
    }

    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrdersearch(no);
        }else {
            return null;
        }
    }

    public HeroNode postOrserSearch(int no) {
        if (root != null) {
            return root.postOrdersearch(no);
        }else {
            return null;
        }
    }

    //删除结点
    public void delNode(int no) {
        if (root != null) {
            if (root.getNo() == no) {
                root = null;
            }else {
                root.delNode(no);
            }
//            if (root.getLeft() == null )
        }else {
            System.out.println("🈳️🌲");
//            return;
        }
    }

    public void threadedNodes(HeroNode node) {
        if (node == null) {
            return;
        }

        threadedNodes(node.getLeft());
        if (node.getLeft() == null) {
            node.setLeft(pre);//暂时是null
            node.setLeftType(1);//左指针类型
        }

        threadedNodes(node.getRight());
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
    }
}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;//左结点
    private HeroNode right;//右结点

    private int leftType;
    private int rightType;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                '}';
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

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    public void postOrder() {
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
        System.out.println(this);
    }

    public HeroNode preOrdersearch(int no) {
        System.out.println("进入前序查找····");
        if (this.no == no) {
            return this;
        }
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrdersearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        //
        if (this.right != null) {
            resNode = this.right.preOrdersearch(no);
        }
        return resNode;
    }

    public HeroNode infixOrdersearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrdersearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("进入中序查找····");
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.infixOrdersearch(no);
        }
        return resNode;
    }

    public HeroNode postOrdersearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrdersearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.postOrdersearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("进入后序查找····");
        if (this.no == no) {
            return this;
        }
        return resNode;
    }

    //递归删除结点
    public void delNode(int no) {
        if (this.left !=null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.left.no == no) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.delNode(no);
        }
        if (this.right != null) {
            this.right.delNode(no);
        }
    }

}