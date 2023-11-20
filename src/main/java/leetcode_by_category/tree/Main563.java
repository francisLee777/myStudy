package leetcode_by_category.tree;

// 563. 二叉树的坡度
public class Main563 {
    int res = 0;

    public int findTilt(TreeNode root) {
        fun(root);
        return res;
    }

    int fun(TreeNode root) {
        if (root == null) return 0;
        int left = fun(root.left);
        int right = fun(root.right);
        res += Math.abs(left - right);
        return root.val + left + right;
    }


}
