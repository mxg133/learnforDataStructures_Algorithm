package _3linkedlist.my;

import java.util.Stack;

/**
 * @author 孟享广
 * @date 2020-08-17 12:12 下午
 * @description
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1," 宋江","及时雨");
        HeroNode heroNode2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode heroNode3 = new HeroNode(3,"无用","智多星");
        HeroNode heroNode4 = new HeroNode(4,"林冲","豹子头");

        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addByOrder(heroNode1);
        linkedList.addByOrder(heroNode4);
        linkedList.addByOrder(heroNode2);
        linkedList.addByOrder(heroNode3);

        HeroNode heroNode22 = new HeroNode(2,"小卢","小尾巴~");
        linkedList.update(heroNode22);
        linkedList.list();
        System.out.println();
//        linkedList.remove(3);
        System.out.println(grtLenth(linkedList.getHead()));
//        linkedList.list();
        System.out.println(findLastIndexNode(linkedList.getHead(), 2));

        reversrtList(linkedList.getHead());
        linkedList.list();


        System.out.println(" 、逆序打印");
        reversePrint(linkedList.getHead());
    }

    public static void reversePrint(HeroNode head){
        if (head.next == null){
            System.out.println("空 不能打印 反 ");
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        while (stack.size() > 0) {
            System.out.println(
                    stack.pop()
            );
        }
    }


    public static int grtLenth(HeroNode head){
        if (head.next == null){
            return 0;
        }
        int lenth = 0;
        HeroNode cur = head.next;
        while (cur != null) {
            lenth++;
            cur = cur.next;
        }
        return lenth;
    }

    public static HeroNode findLastIndexNode(HeroNode head, int index){
        if (head.next == null){
            return null;
        }
        int size = grtLenth(head);
        if (index <= 0 || index > size){
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public static void reversrtList(HeroNode head){
        if (head.next == null || head.next.next == null){
            return;
        }
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }

}

class SingleLinkedList{
    private HeroNode head =  new HeroNode(0,"","");

    public  HeroNode getHead() {
        return head;
    }

    public void add(HeroNode heroNode){
        HeroNode t = head;
        while (true){
            if (t.next == null)
                break;
            t = t.next;
        }
        t.next = heroNode;
    }

    public void addByOrder(HeroNode heroNode){
        HeroNode t = head;
        boolean flag = false;
        while (true) {
            if (t.next == null)
                break;

            if (heroNode.no > t.next.no) {
                break;
            }else if (t.next.no == heroNode.no) {
                flag = true;
                break;
            }
            t = t.next;
        }
        if (flag){
            System.out.println(" 英雄的编号 " + heroNode.no + "已经存在");
        }else {
            heroNode.next = t.next;
            t.next = heroNode;
        }
    }

    public void update(HeroNode heroNode){
        if (head.next == null){
            System.out.println(" 空 ");
            return;
        }
        HeroNode t = head;
        boolean flag = false;
        while (true){
            if (t == null) {
                break;
            }
            if (t.no == heroNode.no){
                flag = true;
                break;
            }
            t = t.next;
        }
        if (flag){
            t.name = head.name;
            t.nickname = heroNode.nickname;
        }else {
            System.out.println(" 没有找到想要修改的对象 " + heroNode.no);
        }
    }

    public void remove(int no){
        HeroNode t = head;
        boolean flag = false;
        while (true) {
            if (t.next == null) {
                break;
            }
            if (t.no == no){
                flag = true;
                break;
            }
            t = t.next;
        }
        if (flag){
            t.next = t.next.next;
        }else {
            System.out.println("没找到 你输入的 根本就没有 sb");
        }
    }

    public void list(){
        if (head.next == null){
            System.out.println(" 空 ");
            return;
        }
        HeroNode t = head.next;
        while (true) {
            if (t == null)
                break;
            System.out.println(t);
            t = t.next;
        }

    }

}

class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}