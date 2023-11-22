package run_2022.run_2022_07;


/**
 * 二叉树转链表，原地法，手动收藏。
 *
 * @author lihaoyu
 * @date 2022/7/13 22:54
 */
public class Main114 {
    private final TreeNode res = new TreeNode(2);
    private TreeNode temp = res;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        node1.left = node2;
        Main114 main114 = new Main114();
        main114.flatten2(root);
        System.out.println(root);
    }

    private void fun(TreeNode root) {
        if (root == null) return;
        temp.right = new TreeNode(root.val);
        temp = temp.right;
        fun(root.left);
        fun(root.right);
    }

    public void flatten(TreeNode root) {
        if (root == null) return;
        fun(root);
        root.left = null;
        root.right = res.right.right;
    }

    public void flatten2(TreeNode root) {
        if (root == null) return;
        fun2(root);
    }

    TreeNode fun2(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return root;
        if (root.left == null) return fun2(root.right);
        TreeNode tempLeft = root.left;
        TreeNode tempRight = root.right;
        root.left = null;
        root.right = null;
        TreeNode left = fun2(tempLeft);
        TreeNode right = fun2(tempRight);
        root.right = tempLeft;
        left.right = tempRight;
        if (right == null) return left;
        return right;
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }


}
