package leetcode_by_category.tree;

// 1022. 从根到叶的二进制数之和
public class Main1022 {
    StringBuilder sb = new StringBuilder();
    int res = 0;

    public int sumRootToLeaf(TreeNode root) {
        fun(root);
        return res;
    }

    void fun(TreeNode root) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            res += Integer.parseInt(sb.toString(), 2);
        }
        fun(root.left);
        fun(root.right);
        sb.deleteCharAt(sb.length() - 1);
    }


}
