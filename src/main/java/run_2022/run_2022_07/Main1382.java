package run_2022.run_2022_07;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lihaoyu
 * @date 2022/7/13 22:12
 */
public class Main1382 {


    class TreeNode{
        int val;
        TreeNode left,right;
    }

    private List<TreeNode> list = new ArrayList<>();

    private void fun(TreeNode root){
        if (root == null) return;
        fun(root.left);
        list.add(root);
        fun(root.right);
    }

    private TreeNode fun2(int start, int end){
        if (start > end) return null;
        TreeNode root = list.get((start + end) /2 );
        root.left = fun2(start,(start + end) /2 -1 );
        root.right = fun2((start + end) /2+1,end);
        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        if (root == null) return null;
        fun(root);
    return fun2(0,list.size()-1);
    }

}
