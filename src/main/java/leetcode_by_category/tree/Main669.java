package leetcode_by_category.tree;

/**
 * 669. 修剪二叉搜索树
 *
 * @author lihaoyu
 * @date 2023/11/21 14:38
 */
public class Main669 {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val > high) return trimBST(root.left, low, high);
        if (root.val < low) return trimBST(root.right, low, high);
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
