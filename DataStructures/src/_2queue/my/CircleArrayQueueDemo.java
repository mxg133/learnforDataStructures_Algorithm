package _2queue.my;

import java.util.Scanner;

/**
 * @author 孟享广
 * @date 2020-08-17 10:35 上午
 * @description
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
//        ArrayQueue arrayQueue = new ArrayQueue(3);
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(4);

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
                    circleArrayQueue.showQueue();
                    break;
                case 'a':
                    int value = scanner.nextInt();
                    circleArrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = circleArrayQueue.getQueue();
                        System.out.println(" 是 " + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = circleArrayQueue.headQueue();
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



class CircleArrayQueue{
    private int maxSize;
    private int front;
    private int rear;
    private int arr[];

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;//
        rear = 0;//
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (this.isFull()) {
            System.out.println("滚，满了");
            return;
        }
        arr[rear] = n;
        rear  = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (this.isEmpty()) {
            throw new RuntimeException("空空🧴");
        }
        int t = arr[front];
        front = (front + 1) % maxSize;
        return t;

    }

    public void showQueue() {
        if (this.isEmpty())
            System.out.println("空");
        for (int i = front; i < size(); i++) {
            System.out.printf("[%d] = %d", i % maxSize, arr[i % maxSize]);
        }
    }
    public int size(){
        return ( rear - front + maxSize) % maxSize;
    }

    //
    public int headQueue() {
        if (this.isEmpty()) {
            System.out.println("空");
            throw new RuntimeException("不能");
        }
        return arr[front];
    }
}