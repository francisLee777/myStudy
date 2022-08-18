package run_2022.run_2022_07;

/**
 * @author lihaoyu
 * @date 2022/7/13 22:18
 */
public class Main110 {
    class TreeNode{
        int val;
        TreeNode left,right;
    }


    private int fun(TreeNode root){
        if (root == null) return 0;
        int left = fun( root.left);
        if (left == -1) return -1;
        int right = fun(root.right);
        if (right == -1) return -1;
        return Math.abs(left-right) > 1 ? -1 : Math.max(left,right)+1;
    }

    public boolean isBalanced(TreeNode root) {
        return fun(root) != -1;
    }
}
