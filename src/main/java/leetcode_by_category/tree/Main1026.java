package leetcode_by_category.tree;

/**
 * @author lihaoyu
 * @date 2022/12/23 19:25
 */
public class Main1026 {
    int res = 0;

    public int maxAncestorDiff(TreeNode root){
       int max = root.val;
        int min = root.val;
       temp(root,max,min);
       return res;
    }

    void temp(TreeNode root,int max,int min){
        if(root == null) return;
        res = Math.max(res,Math.max(Math.abs(root.val - max),Math.abs(root.val - min)));
        max = Math.max(max,root.val);
        min = Math.min(min,root.val);
        temp(root.left,max,min);
        temp(root.right,max,min);
    }


    public static void main(String[] args) {

    }
}
