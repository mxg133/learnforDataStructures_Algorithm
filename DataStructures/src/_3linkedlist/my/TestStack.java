package _3linkedlist.my;

import java.util.Stack;

/**
 * @author 孟享广
 * @date 2020-08-20 1:35 下午
 * @description
 */
public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.add("jack");
        stack.add("tom");
        stack.add("smith");

        while (stack.size() > 0) {
            System.out.println(
                    stack.pop()
            );
        }
    }
}
