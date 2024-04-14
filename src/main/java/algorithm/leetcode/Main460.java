package algorithm.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 实现 LFUCache 类：
 * <p>
 * LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象
 * int get(int key) - 如果键存在于缓存中，则获取键的值，否则返回 -1。
 * void put(int key, int value) - 如果键已存在，则变更其值；如果键不存在，请插入键值对。
 * 当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效。
 * 在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最久未使用 的键。
 * 注意「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。
 * 你是否可以在 O(1) 时间复杂度内执行两项操作？
 *
 * @author lihaoyu
 * @date 2020/12/6 11:53 下午
 */
public class Main460 {

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));

    }

    private static class Node {
        int key;
        int value;
        int frequent;

        Node(int key, int value, int frequent) {
            this.key = key;
            this.frequent = frequent;
            this.value = value;
        }
    }

    private static class LFUCache {
        int capacity;
        int minFrequency;
        // key 是数据key， value是数据详细信息
        Map<Integer, Node> map = new HashMap<>(16);
        // key 是频率， value 是对应的节点列表
        Map<Integer, LinkedList<Node>> frequencyMap = new HashMap<>(16);

        public LFUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            // 增加频率
            Node resNode = map.get(key);
            LinkedList<Node> list = frequencyMap.get(resNode.frequent);
            // 先移出来
            list.remove(resNode);
            resNode.frequent++;
            // 放到频率+1的列表中
            if (!frequencyMap.containsKey(resNode.frequent)) {
                frequencyMap.put(resNode.frequent, new LinkedList<>());
            }
            frequencyMap.get(resNode.frequent).addLast(resNode);
            if (frequencyMap.get(minFrequency).isEmpty()) minFrequency++;
            return resNode.value;
        }


        public void put(int key, int value) {
            if (capacity <= 0) return;
            // 存在，直接返回
            if (get(key) != -1) {
                map.get(key).value = value;
                return;
            }
            // 不存在，新增，看容量
            if (map.size() >= capacity) {
                // 容量不够，要先删除，找频率最低的
                LinkedList<Node> list = frequencyMap.get(minFrequency);
                Node remove = list.pollFirst();
                map.remove(remove.key);
            }
            // 新增
            Node node = new Node(key, value, 1);
            map.put(key, node);
            frequencyMap.get(1).addLast(node);
            minFrequency = 1;
        }
    }

}
