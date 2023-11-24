package leetcode_by_category.tree;

/**
 * 124. 二叉树中的最大路径和,  注意初始值
 *
 * @author lihaoyu
 * @date 2023/11/21 17:26
 */
public class Main124 {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        fun(root);
        return res;
    }

    int fun(TreeNode root) {
        if (root == null) return 0;
        int left = fun(root.left);
        int right = fun(root.right);
        left = Math.max(left, 0);
        right = Math.max(right, 0);
        res = Math.max(res, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}