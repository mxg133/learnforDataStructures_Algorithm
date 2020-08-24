package _4stack.my;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 孟享广
 * @date 2020-08-24 10:47 上午
 * @description
 */
public class PolandNotation {
    public static void main(String[] args) {
//     (3+4)*5-6
        String suffixExpression = "3 4 + 5 * 6 - ";
        List<String> list = getList(suffixExpression);
        System.out.println(list);
        int res = calculate(list);
        System.out.println(res);
        String ecpression = "1+((2+3)*4)-5";
        List<String> list1 = toInFixExpressionlist(ecpression);
        System.out.println(list1);
    }
//    public static List<String> parseSuffixExpreesionList(List ls) {
//        Stack<String> s1 = new Stack<>();//符号
////        Stack<String> s2 = new Stack<>();
//        ArrayList<String> s2 = new ArrayList<>();//中间结果
//        for (String item: ls) {
//            if (item.matches("\\d+")) {
//                s2.add(item);
//            }else if (item.equals("(")){
//                s1.push(item);
//            }else if (item.equals(")")) {
//                while (!s1.peek().equals("(")) {
//                    s2.add(s1.pop());
//                }
//                s1.pop();
//            }else {
//                while (s1.size() != 0 &&  Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
//                    s2.add(s1.pop());
//                }
//                s1.push(item);
//            }
//        }
//        while (s1.size() != 0) {
//            s2.add(s1.pop());
//        }
//        return s2;
//    }

    public static List<String> toInFixExpressionlist(String s ){
        ArrayList<String> ls = new ArrayList<>();
        int i = 0;
        String str;
        char c;
        do {
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {//非数字
                ls.add("" + c);
                i++;
            }else {
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;//是数字
                    i++;
                }
                ls.add(str);
            }
        }while (i < s.length());
        return ls;
    }

    public static List<String> getList(String suffixExpression){
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele: split) {
            list.add(ele);
        }
        return list;
    }

    public static int calculate(List<String> ls) {
        Stack<String> stack = new Stack<>();
        for(String item: ls) {
            if (item.matches("\\d+")) {
                stack.push(item);
            }else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res;
                if (item.equals("+")) {
                    res = num1 + num2;
                }else if (item.equals("-")) {
                    res = num1 - num2;
                }else if (item.equals("*")) {
                    res = num1 * num2;
                }else if (item.equals("/")) {
                    res = num1 / num2;
                }else {
                    throw new RuntimeException("请输入+-*/！");
                }
                stack.push("" + res);
            }
        }
        String res = stack.pop();
        int parseInt = Integer.parseInt(res);
        return parseInt;
    }
}

class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String key) {
        int result = 0;
        switch (key) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("运算符不对1!!!    ");
                break;
        }
        return result;
    }
}