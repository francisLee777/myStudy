package leetcode_by_category.tree;

// 530. 二叉搜索树的最小绝对差
public class Main530 {

    int res = Integer.MAX_VALUE;
    int pre = 10000000; // 注意溢出

    public int getMinimumDifference(TreeNode root) {
        fun(root);
        return res;
    }

    void fun(TreeNode root) {
        if (root == null) return;
        fun(root.left);
        res = Math.min(res, Math.abs(root.val - pre));
        pre = root.val;
        fun(root.right);
    }

}
