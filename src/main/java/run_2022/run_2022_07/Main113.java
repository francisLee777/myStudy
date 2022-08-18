package run_2022.run_2022_07;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lihaoyu
 * @date 2022/7/13 13:58
 */
public class Main113 {
    class TreeNode{
        int val;
        TreeNode left,right;
    }

    private List<List<TreeNode>> res = new ArrayList<>();
    private   List<TreeNode> temp = new ArrayList<>();

    public void fun(TreeNode root, int targetSum){
        if (root == null ) return;
        if (root.right == null & root.left == null && targetSum == root.val){
            temp.add(root);
            res.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
            return;
        }
        if (root.right == null & root.left == null){
            return;
        }
        temp.add(root);
        fun(root.left, targetSum - root.val);
        fun(root.right, targetSum - root.val);
        temp.remove(temp.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            fun(root,targetSum);
        List<List<Integer>> list = new ArrayList<>();
        for (List<TreeNode> re : res) {
            List<Integer> temp =  new ArrayList<>();
            list.add(temp);
            for (TreeNode treeNode : re) {
                temp.add(treeNode.val);
            }
        }
        return list;
    }
}
