package _3linkedlist.my;

/**
 * @author 孟享广
 * @date 2020-08-20 2:43 下午
 * @description
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        HeroNode2 heroNode1 = new HeroNode2(1," 宋江","及时雨");
        HeroNode2 heroNode2 = new HeroNode2(2,"卢俊义","玉麒麟");
        HeroNode2 heroNode3 = new HeroNode2(3,"吴用","智多星");
        HeroNode2 heroNode4 = new HeroNode2(4,"林冲","豹子头");
        list.add(heroNode1);
        list.add(heroNode2);
        list.add(heroNode3);
        list.add(heroNode4);

        list.list();
        System.out.println();
        HeroNode2 heroNode5 = new HeroNode2(4,"公孙胜","入云龙");
        list.update(heroNode5);
        list.list();
        System.out.println();
        list.remove(3);
        list.list();
    }
}

class DoubleLinkedList{
    private HeroNode2 head = new HeroNode2(0, "", "");
    public HeroNode2 getHead(){
        return head;
    }
    public void list(){
        if (head.next == null){
            System.out.println(" 空 ");
            return;
        }
        HeroNode2 t = head.next;
        while (true) {
            if (t == null)
                break;
            System.out.println(t);
            t = t.next;
        }
    }
    public void add(HeroNode2 heroNode){
        HeroNode2 t = head;
        while (true){
            if (t.next == null)
                break;
            t = t.next;
        }
        t.next = heroNode;
        heroNode.pre = t;
    }

    public void update(HeroNode2 heroNode){
        if (head.next == null){
            System.out.println(" 空 ");
            return;
        }
        HeroNode2 t = head;
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

        if (head.name == null){
            System.out.println( " sb 空空如也 没法删除!!! ");
            return;
        }

        HeroNode2 t = head.next;
        boolean flag = false;
        while (true) {
            if (t == null) {
                break;
            }
            if (t.no == no){
                flag = true;
                break;
            }
            t = t.next;
        }
        if (flag){
            t.pre.next = t.next;
            if (t.next != null) {
                t.next.pre = t.pre;//
            }
        }else {
            System.out.println("没找到 你输入的 根本就没有 还删除个jb。sb");
        }
    }
}

class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickname) {
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
