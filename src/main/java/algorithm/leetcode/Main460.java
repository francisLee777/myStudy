package algorithm.leetcode;

/**
 * 实现 LFUCache 类：
 *
 * LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象
 * int get(int key) - 如果键存在于缓存中，则获取键的值，否则返回 -1。
 * void put(int key, int value) - 如果键已存在，则变更其值；如果键不存在，请插入键值对。
 * 当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效。
 * 在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最久未使用 的键。
 * 注意「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。
 * 你是否可以在 O(1) 时间复杂度内执行两项操作？
 * @author lihaoyu
 * @date 2020/12/6 11:53 下午
 */
public class Main460 {

    private static class LFUCache{
        int capacity;


        public LFUCache(int capacity) {
        this.capacity = capacity;
        }

        public int get(int key) {

            return 0;
        }


        public void put(int key, int value) {

        }


    }

    


}
