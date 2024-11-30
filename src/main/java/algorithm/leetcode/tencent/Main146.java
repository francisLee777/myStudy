package algorithm.leetcode.tencent;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146. LRU缓存机制  手动收藏
 *
 * @author lihaoyu
 * @date 2019/12/18 15:44
 */
public class Main146 {

    int capacity;
    Map<Integer, Node> map;
    Node head;
    Node tail;

    public Main146(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public static void main(String[] args) {
        Main146 cache = new Main146(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));


    }

    // 一个 node 移动到链表head
    private void moveToHead(Node node) {
        // 处理前后节点
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        // 处理 node
        node.prev = head;
        node.next = head.next;
        // 处理 head 和 head.next, 2021.4.6 少了 head.next 的处理，调试了半小时  21:00 - 21:30
        head.next.prev = node;
        head.next = node;

    }

    private void deleteNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        node.prev = null;
        node.next = null;
    }

    private void addNodeToHead(Node node) {
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        moveToHead(map.get(key));
        return map.get(key).value;
    }

    public void put(int key, int value) {
        // 如果已有，刷新，并把节点移到链表头部
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            map.get(key).value = value;
            map.put(key, temp);
            moveToHead(temp);
            return;
        }
        // 如果没有, 看看容量
        if (map.size() == capacity) {
            // 删除最后一个节点
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        // 添加到头部
        Node node = new Node(key, value);
        addNodeToHead(node);
        map.put(key, node);
    }

    private static class LRUCache extends LinkedHashMap {
        int capacity;

        public LRUCache(int capacity) {
            super(2 * capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            if (super.get(key) != null)
                return (Integer) super.get(key);
            return -1;
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > capacity;
        }

    }

    class Node {
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}
