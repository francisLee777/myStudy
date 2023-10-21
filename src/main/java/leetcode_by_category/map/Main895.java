package leetcode_by_category.map;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author lihaoyu
 * @date 2023/3/16 09:33
 */
public class Main895 {


}


class FreqStack {
    // 第一层 key :  频率, 第二层 key 数字， value是 计数器值
    TreeMap<Integer, Map<Integer, List<Integer>>> tree = new TreeMap<>(Comparator.reverseOrder());
    // key是数字， value是频率
    Map<Integer, Integer> map = new HashMap<>();

    int count = 0;

    public FreqStack() {
    }

    public void push(int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
        // oldFrequent 新频率
        Integer newFrequent = map.get(val);
        if (!tree.containsKey(newFrequent)) {
            tree.put(newFrequent, new HashMap<>());
        }
        // 从老频率里面放到新频率里面， 要注意可能之前的频率是0不存在
        Map<Integer, List<Integer>> oldMap = tree.get(newFrequent - 1);
        List<Integer> temp;
        if (oldMap != null) {
            temp = oldMap.get(val);
            temp.add(count++);
            // 放到新的，老的移除
            tree.get(newFrequent).put(val, temp);
            tree.get(newFrequent - 1).remove(val);
        } else {
            temp = new ArrayList<>();
            temp.add(count++);
            tree.get(newFrequent).put(val, temp);
        }


    }

    public int pop() {
        Map.Entry<Integer, Map<Integer, List<Integer>>> entry = tree.firstEntry();
        System.out.println("最大的频率是 " + entry.getKey().toString());
        Map<Integer, List<Integer>> tempMap = entry.getValue();
        int tempCount = -1, tempVal = -1;
        for (Map.Entry<Integer, List<Integer>> integerListEntry : tempMap.entrySet()) {
            List<Integer> list = integerListEntry.getValue();
            if (list.get(list.size() - 1) > tempCount) {
                tempCount = list.get(list.size() - 1);
                tempVal = integerListEntry.getKey();
            }
        }
        List<Integer> remove = tempMap.remove(tempVal);
        remove.remove(remove.size() - 1);

        map.put(tempVal, map.get(tempVal) - 1);
        return tempVal;
    }
}
