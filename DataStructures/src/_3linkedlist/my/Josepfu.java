package _3linkedlist.my;

/**
 * @author 孟享广
 * @date 2020-08-21 11:13 上午
 * @description
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        list.addBoy(5);

        list.list();


        list.countBoy(1,2,5);

    }
}
class CircleSingleLinkedList{
    private Boy first =  null;

    public void addBoy(int nums){
        if (nums < 1){
            System.out.println("nums < 1 是不可以的哦！！sb");
            return;
        }

        Boy cur = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                cur = first;
            }
            cur.setNext(boy);
            boy.setNext(first);
            cur = boy;
        }
    }

    public void list(){
        if (first == null) {
            System.out.println("first.getNext() == null 空的list，sb");
            return;
        }

        Boy cur = first;
        while (true){
            System.out.println(cur.getNo());
            if (cur.getNext() == first)
                break;
            cur = cur.getNext();
        }
    }

    public void countBoy(int startNo, int countnum, int nums){
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("first == null || startNo < 1 || startNo > nums" +
                    "参数输入有问题！sb");
            return;
        }

        Boy helper = first;

        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }

        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        while (true) {
            if (helper == first) {
                System.out.println("只有一个人！");
                break;
            }
            for (int i = 0; i < countnum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println(first.getNo() + " 出");
            first = first.getNext();
            helper.setNext(first);
        }

        System.out.println("最后的孩纸是 "+ first.getNo());

    }
}
class Boy{
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
