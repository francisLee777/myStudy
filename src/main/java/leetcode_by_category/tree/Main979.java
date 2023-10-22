package leetcode_by_category.tree;

/**
 * @author lihaoyu
 * @date 2022/12/24 17:03
 */
public class Main979 {

    int fun(TreeNode root){
       if(root == null) return 0;
       int left = fun(root.left);
       int right = fun(root.right);
       return left+right+Math.abs(root.val-1);

    }

    public static void main(String[] args) {

    }
}
