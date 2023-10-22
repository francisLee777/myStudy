package leetcode_by_category.tree;

/**
 * 手动收藏  树当成链表进行逆序
 * @author lihaoyu
 * @date 2022/12/30 19:35
 */
public class Main897 {


    public TreeNode increasingBST(TreeNode root) {


return fun(root);
    }

    TreeNode fun(TreeNode root){
        if(root.left == null) return root;
        TreeNode left = fun(root.left);
        root.left = null;
        left.right = root;
        fun(root.right);
        return left;
    }

    public static void main(String[] args) {

    }
}
