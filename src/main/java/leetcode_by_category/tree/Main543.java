package leetcode_by_category.tree;

/*
二叉树 任意两点之间的距离   玛德这个题是 easy ???
 */
public class Main543 {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        fun(root);
        return max - 1;
    }

    int fun(TreeNode root) {
        if (root == null) return 0;
        int left = fun(root.right);
        int right = fun(root.left);
        max = Math.max(max, 1 + left + right);
        return 1 + Math.max(left, right);
    }

}
