package leetcode_by_category.tree;

/**
 * 100. 相同的树
 *
 * @author lihaoyu
 * @date 2023/11/21 17:58
 */
public class Main100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p != null && q == null || p == null && q != null || q.val != p.val) return false;
        boolean left = isSameTree(p.left, q.left);
        if (!left) return false;
        return isSameTree(p.right, q.right);
    }
}