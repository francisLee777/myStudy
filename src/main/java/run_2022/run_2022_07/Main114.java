package run_2022.run_2022_07;


/**
 * 二叉树转链表，原地法，手动收藏。
 *
 * @author lihaoyu
 * @date 2022/7/13 22:54
 */
public class Main114 {
    private final TreeNode res = new TreeNode(2);
    private final TreeNode temp = res;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        node1.left = node2;
        Main114 main114 = new Main114();
    }


    public void flatten(TreeNode root) {
        if (root == null) return;
        fun(root);
    }

    TreeNode fun(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return root;
        TreeNode left = fun(root.left);
        TreeNode right = fun(root.right);
        if (root.left == null) return root;
        root.right = left;
        root.left = null;
        TreeNode p = left;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }


}
