package leetcode_by_category.map;

import java.util.*;

/**
 * 手动收藏
 * 设计一个类似堆栈的数据结构，将元素推入堆栈，并从堆栈中弹出出现频率最高的元素。
 * 实现 FreqStack 类:
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
    TreeMap<Integer, LinkedHashSet<Integer>> tree = new TreeMap<>(Comparator.reverseOrder());
    // key: 数字，频率
    Map<Integer, Integer> freqMap = new HashMap<>();
    // key是数字， value是在栈中出现的下标集合。 如果频率一样时，对比最后一个下标
    Map<Integer, List<Integer>> map = new HashMap<>();

    // 全局count，用于比较下标
    int count = 0;

    public FreqStack() {
    }

    public void push(int val) {
        // 现在的频率
        Integer newFreq = freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
        Integer oldFreq = newFreq - 1;
        // 从之前的频率里面移出来
        if (oldFreq != 0) {
            LinkedHashSet<Integer> oldSet = tree.get(oldFreq);
            oldSet.remove(val);
            // 移除之后如果容量为0，则删除
            if (oldSet.isEmpty()) tree.remove(oldFreq);
        }
        // 放到新的频率里面
        tree.putIfAbsent(newFreq, new LinkedHashSet<>());
        tree.get(newFreq).add(val);
    }


    public int pop() {

//        System.out.println("出的数字是 " + newNumber + "老频率为:" + oldFre);
//        return newNumber;
        return 0;
    }
}
