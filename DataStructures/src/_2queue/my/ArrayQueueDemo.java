package _2queue.my;

import java.util.Scanner;

/**
 * @author 孟享广
 * @date 2020-08-16 4:13 下午
 * @description
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.println(" 是 " + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.println(" 是 " + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;

            }
        }

        System.out.println("tuichu1!!!!");
    }
}

class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int arr[];

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;//
        rear = -1;//
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (this.isFull()) {
            System.out.println("滚，满了");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    public int getQueue() {
        if (this.isEmpty()) {
            throw new RuntimeException("空空🧴");
        }
        front++;
        return arr[front];
    }

    public void showQueue() {
        if (this.isEmpty())
            System.out.println("空");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] = %d", i, arr[i]);
        }
    }

    //
    public int headQueue() {
        if (this.isEmpty()) {
            System.out.println("空");
            throw new RuntimeException("不能");
        }
        return arr[front + 1];
    }
}
