package algorithm.leetcode.tree;

import java.util.LinkedList;

/**
 * 116. 填充每个节点的下一个右侧节点指针    原地算法，手动收藏
 *
 * @author lihaoyu
 * @date 2019/12/5 16:00
 */
public class Main116 {


    public static void main(String[] args) {

    }

    public Node connect2(Node root) {
        if (root == null) return null;
        LinkedList<Node> list = new LinkedList<>();
        list.addLast(root);
        int curDepth = 0, curLevelNode = 1, nextLevelNode = 0;
        Node right = null;
        while (!list.isEmpty()) {
            Node node = list.pollFirst();
            node.next = right;
            right = node;
            if (node.right != null) {
                list.addLast(node.right);
                nextLevelNode++;
            }
            if (node.left != null) {
                list.addLast(node.left);
                nextLevelNode++;
            }
            curLevelNode--;
            if (curLevelNode == 0) {
                curDepth++;
                curLevelNode = nextLevelNode;
                nextLevelNode = 0;
                right = null;
            }
        }

        return root;
    }

    public Node connect(Node root) {
        if (root == null || root.left == null) return root;
        root.left.next = root.right;
        if (root.next != null) root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
        return root;
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

}
