package leetcode_by_category.map;

import java.util.*;

/**
 * 手动收藏
 * 设计一个类似堆栈的数据结构，将元素推入堆栈，并从堆栈中弹出出现频率最高的元素。
 * <p>
 * 实现 FreqStack 类:
 * <p>
 * FreqStack() 构造一个空的堆栈。
 * void push(int val) 将一个整数 val 压入栈顶。
 * int pop() 删除并返回堆栈中出现频率最高的元素。
 * 如果出现频率最高的元素不只一个，则移除并返回最接近栈顶的元素。
 *
 * @author lihaoyu
 * @date 2023/3/16 09:33
 */
public class Main895 {
    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        freqStack.pop();
        freqStack.pop();
        freqStack.pop();
        freqStack.pop();
    }
}


class FreqStack {
    //  key :  频率,  数字集合
    TreeMap<Integer, HashSet<Integer>> tree = new TreeMap<>(Comparator.reverseOrder());
    // key是数字， value是在栈中出现的下标集合。 如果频率一样时，对比最后一个下标
    Map<Integer, List<Integer>> map = new HashMap<>();

    // 全局count，用于比较下标
    int count = 0;

    public FreqStack() {
    }

    public void push(int val) {
        map.putIfAbsent(val, new ArrayList<>());
        map.get(val).add(count++);
        // 如果之前的频率不为0，要从老频率里面移出来
        Integer oldFre = map.get(val).size() - 1;
        Integer newFre = oldFre + 1;
        if (oldFre != 0) {
            tree.get(oldFre).remove(val);
        }
        tree.putIfAbsent(newFre, new HashSet<>());
        tree.get(newFre).add(val);
    }

    public int pop() {
        // 测试保证有数据
        // 先找频率最大的数字有哪些
        Integer oldFre = tree.firstKey();
        Map.Entry<Integer, HashSet<Integer>> oldFreEntry = tree.firstEntry();
        Integer newFre = oldFre - 1;
        // 循环这些数字,通过下标找最新的
        Integer newIndex = -1;
        Integer newNumber = -1;
        Iterator<Integer> iterator = oldFreEntry.getValue().iterator();
        while (iterator.hasNext()) {
            Integer temp = iterator.next();
            List<Integer> indexList = map.get(temp);
            if (newIndex < indexList.get(indexList.size() - 1)) {
                newIndex = indexList.get(indexList.size() - 1);
                newNumber = temp;
            }
        }
        // 得到了频率最大且最新的数及其下标
        // 从老频率中删除
        oldFreEntry.getValue().remove(newNumber);
        if (oldFreEntry.getValue().isEmpty()) {
            tree.pollFirstEntry();
        }
        // 放到新频率里面
        if (newFre != 0) {
            tree.putIfAbsent(newFre, new HashSet<>());
            tree.get(newFre).add(newNumber);
        }
        // 下标要移除
        map.get(newNumber).remove(map.get(newNumber).size() - 1);
        if (map.get(newNumber).isEmpty()) {
            map.remove(newNumber);
        }
        System.out.println("出的数字是 " + newNumber + "老频率为:" + oldFre);
        return newNumber;
    }
}
