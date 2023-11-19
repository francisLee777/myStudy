package leetcode_by_category.tree;

// 二叉树是否对称 2023年11月19日17:45:38
public class Main101 {


    public boolean isSymmetric(TreeNode root) {
        return fun(root, root);
    }

    // 递归写法，可以用迭代，中序遍历，判断对称
    boolean fun(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null && root2 != null || root1 != null && root2 == null) return false;
        if (root1.val != root2.val) return false;
        return fun(root1.left, root2.right) && fun(root1.right, root2.left);
    }

}
