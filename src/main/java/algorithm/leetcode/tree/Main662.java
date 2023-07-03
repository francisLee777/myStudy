package algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lihaoyu
 * @date 2019/12/5 15:30
 */
public class Main662 {
    public static void main(String[] args) {
        TreeNode node9 = new TreeNode(9);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, null, node9);
        TreeNode node3 = new TreeNode(3, node5, node4);
        TreeNode node1 = new TreeNode(1, node3, node2);
        Main662 main662 = new Main662();
        main662.widthOfBinaryTree(node1);

    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int maxLen = 0, left = 0, curDepth = 0, curLevelNode = 1, nextLevelNode = 0;
        boolean first = true;
        LinkedList<Node> list = new LinkedList<>();
        list.addLast(new Node(root, 0, 0));
        while (!list.isEmpty()) {
            Node curNode = list.pollFirst();
            if (first) {
                // 说明是本层第一个节点
                left = curNode.position;
                first = false;
            }
            if (curNode.treeNode.left != null) {
                list.addLast(new Node(curNode.treeNode.left, curDepth + 1, curNode.position * 2 + 1));
                nextLevelNode++;
            }
            if (curNode.treeNode.right != null) {
                list.addLast(new Node(curNode.treeNode.right, curDepth + 1, curNode.position * 2 + 2));
                nextLevelNode++;
            }
            curLevelNode--;
            if (curLevelNode == 0) {
                first = true;
                // 本层最后一个节点
                curDepth++;
                curLevelNode = nextLevelNode;
                nextLevelNode = 0;
                maxLen = Math.max(maxLen, curNode.position - left + 1);
            }
        }
        return maxLen;
    }

    public int widthOfBinaryTree2(TreeNode root) {
        // 左递归
        List<Integer> left = new ArrayList<>();
        left.add(0);
        List<Integer> right = new ArrayList<>();
        right.add(0);

        return 0;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static class Node {
        TreeNode treeNode;
        int depth;
        int position;

        public Node(TreeNode treeNode, int depth, int position) {
            this.treeNode = treeNode;
            this.depth = depth;
            this.position = position;
        }
    }

}
