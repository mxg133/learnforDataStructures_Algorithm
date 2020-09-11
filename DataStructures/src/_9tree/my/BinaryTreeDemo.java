package _9tree.my;

/**
 * @author 孟享广
 * @date 2020-09-11 9:19 上午
 * @description
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        binaryTree.setRoot(root);

//        System.out.println("前序遍历····");
//        binaryTree.preOeder();
//        System.out.println("中序遍历····");
//        binaryTree.infixOrder();
//        System.out.println("后序遍历····");
//        binaryTree.postOrder();

//        System.out.println("前序查找········");
//        HeroNode resNode = binaryTree.preOrderSearch(5);
//        if (resNode != null) {
//            System.out.println("找到了！");
//            System.out.println(resNode);
//        }else {
//            System.out.println("没有找到！");
//        }
//        System.out.println("中序查找········");
//        HeroNode resNode2 = binaryTree.infixOrderSearch(5);
//        if (resNode2 != null) {
//            System.out.println("找到了！");
//            System.out.println(resNode2);
//        }else {
//            System.out.println("没有找到！");
//        }
//        System.out.println("后序查找········");
//        HeroNode resNode3 = binaryTree.postOrserSearch(5);
//        if (resNode3 != null) {
//            System.out.println("找到了！");
//            System.out.println(resNode3);
//        }else {
//            System.out.println("没有找到！");
//        }

        //删除结点的练习
        System.out.println("删除前：");
        binaryTree.preOeder();
        binaryTree.delNode(3);
        System.out.println("删除后：");
        binaryTree.preOeder();

    }
}
class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
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
}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

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