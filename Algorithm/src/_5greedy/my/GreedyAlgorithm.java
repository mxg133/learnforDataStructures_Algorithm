package _5greedy.my;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author 孟享广
 * @date 2020-10-06 10:07 上午
 * @description
 */
public class GreedyAlgorithm {
    public static void main(String[] args) {
        //创建广播电台，放入hashmap
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();

        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);

        //存贮所有的地区
        HashSet<String> allAress = new HashSet<>();
        allAress.add("北京");
        allAress.add("上海");
        allAress.add("天津");
        allAress.add("广州");
        allAress.add("深圳");
        allAress.add("成都");
        allAress.add("杭州");
        allAress.add("大连");

        //创建一个ArrayList 存选择电台的集合
        ArrayList<String> selets = new ArrayList<>();

        HashSet<String> tempSet = new HashSet<>();

        //定义maxKey
        String maxKey = null;

        while (allAress.size() != 0) {
            maxKey = null;
            //遍历broadcasts，取出对应的 key
            for (String key: broadcasts.keySet()) {

                tempSet.clear();

                HashSet<String> areas = broadcasts.get(key);

                tempSet.addAll(areas);

                tempSet.retainAll(allAress);//求出 all 和 temp 的交集

                if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())) {
                    maxKey = key;
                }

                if (maxKey != null) {
                    selets.add(maxKey);
                    allAress.removeAll(broadcasts.get(maxKey));
                }
            }
        }
        System.out.println(selets);
    }
}