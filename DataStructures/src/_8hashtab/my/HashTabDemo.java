package _8hashtab.my;

import java.util.Scanner;

/**
 * @author 孟享广
 * @date 2020-09-04 10:57 上午
 * @description
 */
public class HashTabDemo {
    public static void main(String[] args) {
        hashTab hashTab = new hashTab(7);
//        EmplinkList emplinkList = new EmplinkList();
        Emp emp1 = new Emp(1, "傻逼1");
        Emp emp2 = new Emp(2, "傻逼2");
        Emp emp8 = new Emp(8, "傻逼8");
//        emplinkList.add(emp1);
//        emplinkList.add(emp2);
//        emplinkList.list();
        hashTab.add(emp1);
        hashTab.add(emp2);
        hashTab.add(emp8);
        hashTab.list();
        hashTab.findEmpbyId(8);



    }
}
class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class EmplinkList {
    private Emp head = null;

    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (true) {
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }
    public void list(int no) {
        if (head == null) {
            System.out.println(no +" 是空的 你遍历啥啊？？？ ");
            return;
        }
        System.out.println(no +" 恭喜你，当前链表不为空！ 遍历结果如下：");
        Emp curEmp = head;
        while (curEmp != null) {
            System.out.println(curEmp);
            curEmp = curEmp.next;
        }
    }
    public Emp findEmpById(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        Emp curEmp = head;
        while (curEmp != null) {
            if (curEmp.id == id) {
                System.out.println("找到了！！");
//                System.out.println(curEmp);
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}

class hashTab {
    private EmplinkList emplinkListArray[];
    private int size;
    public hashTab(int size) {
        this.size = size;
        emplinkListArray = new EmplinkList[size];
        for (int i = 0; i < size; i++) {
            emplinkListArray[i] = new EmplinkList();
        }
    }
    public void add(Emp emp) {
        int empLinkedListNO = hashFun(emp.id);
        emplinkListArray[empLinkedListNO].add(emp);
    }
    public void list() {
        for (int i = 0; i < size; i++) {
            emplinkListArray[i].list(i);
        }
    }

    public int hashFun(int id) {
        return id % size;
    }
    public void findEmpbyId(int id) {
        int empLinkedNo = hashFun(id);
        Emp emp = emplinkListArray[empLinkedNo].findEmpById(id);
        if (emp != null) {
            System.out.println(id + "条链表找到了！ 如下：");
            System.out.println(emp);
        }else {
            System.out.println("🈚️");
        }
    }
}