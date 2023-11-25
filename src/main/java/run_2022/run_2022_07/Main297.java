package run_2022.run_2022_07;


import java.util.Stack;

/**
 * 297. 二叉树的序列化与反序列化
 *
 * @author lihaoyu
 * @date 2022/7/29 10:22
 */
public class Main297 {

    StringBuilder sb = new StringBuilder();
    Stack<String> stack = new Stack<>();

    public static void main(String[] args) {

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        fun(root);
        sb.deleteCharAt(0);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        for (int i = split.length - 1; i >= 0; i--) {
            stack.push(split[i]);
        }
        return fun2();
    }

    void fun(TreeNode root) {
        if (root == null) {
            sb.append(",X");
            return;
        }
        sb.append(",").append(root.val);
        fun(root.left);
        fun(root.right);
    }

    TreeNode fun2() {
        if (stack.isEmpty()) return null;
        String a = stack.pop();
        if ("X".equals(a)) return null;
        TreeNode node = new TreeNode(Integer.parseInt(a));
        node.left = fun2();
        node.right = fun2();
        return node;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
