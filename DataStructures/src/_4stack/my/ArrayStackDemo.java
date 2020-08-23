package _4stack.my;

import java.util.Scanner;

/**
 * @author 孟享广
 * @date 2020-08-23 1:47 下午
 * @description
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("show");
            System.out.println("exit");
            System.out.println("push");//
            System.out.println("pop");
            System.out.println("请输入：");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.print("输入吧 :");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    System.out.println("出站中·········");
                    try {
                        int result = stack.pop();
                        System.out.println("出战的数据是 " + result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序关闭  -。-");
    }
}
class ArrayStack{
    private int maxSize;
    private int stack[];
    private int top = -1;
    private int bottom = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean inFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (inFull()) {
            System.out.println("满了！sb");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("空空如也， 别想取出 sb");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("空 没数据");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(i + " " + stack[top]);
        }
    }
}