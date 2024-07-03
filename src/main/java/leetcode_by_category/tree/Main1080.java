package leetcode_by_category.tree;

/**
 * 1080. 根到叶路径上的不足节点
 *
 * @author lihaoyu
 * @date 2023/11/21 19:00
 */
public class Main1080 {
    int limit;
    int cur = 0;

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        this.limit = limit;
        return fun(root);
    }


    TreeNode fun(TreeNode root) {
        if (root == null) return null;
        cur += root.val;
        fun(root.left);
        fun(root.right);


        cur -= root.val;

        return null;
    }
}