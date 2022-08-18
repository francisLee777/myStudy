package run_2022.run_2022_08;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lihaoyu
 * @date 2022/8/16 23:09
 */
public class Main95 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
    }

    private List<TreeNode> fun(int start, int end){
        List<TreeNode> list = new ArrayList<>();
        if(start > end) {
            list.add(null);
            return list;
        }
        for(int i = start; i <=  end; i++){
            List<TreeNode> left = fun(start, i-1);
            List<TreeNode> right = fun(i+1, end);

            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    list.add(root);
                }
            }
        }

return list;
    }

    public List<TreeNode> generateTrees(int n) {
        return fun(1,n);
    }
}
