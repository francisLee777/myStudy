package leetcode_by_category.tree;

// 129. 求根节点到叶节点数字之和
public class Main129 {

    StringBuilder sb = new StringBuilder();
    int res = 0;

    public int sumNumbers(TreeNode root) {
        fun(root);
        return res;
    }

    void fun(TreeNode root) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            // 结束了
            res += Integer.parseInt(sb.toString());
        }
        fun(root.left);
        fun(root.right);
        sb.deleteCharAt(sb.length() - 1);
    }
}
