package _4kmp.my;

import java.util.Arrays;

/**
 * @author 孟享广
 * @date 2020-10-05 2:39 下午
 * @description
 */
public class KMPAlgorithm {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
//        String str2 = "ABCDABD";
        String str2 = "BBC";

        int next[] = kmpNext("AAAB");
        System.out.println(Arrays.toString(next));

        int index = kmpSearch(str1, str2, next);
        System.out.println(index);
    }

    /**
     *
     * @param str1 源串
     * @param str2 子串
     * @param next 子串的 部分匹配表
     * @return
     */
    public static int kmpSearch(String str1, String str2, int next[]) {
        for (int i = 0, j = 0; i < str1.length(); i++) {
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    //获取一个字符串的 部分匹配值
    public static int[] kmpNext(String dest) {
        int next[] = new int[dest.length()];
        next[0] = 0;//固定值 A
        for (int i = 1, j = 0; i < dest.length(); i++) {//扫描dest
            //当不相等的时候
            while (j > 0 &&  dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }

            //相等的时候
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}