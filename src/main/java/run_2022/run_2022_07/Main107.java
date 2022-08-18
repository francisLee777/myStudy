package run_2022.run_2022_07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lihaoyu
 * @date 2022/7/13 13:41
 */
public class Main107 {
    public class TreeNode {
      int val;
           TreeNode left;
      TreeNode right;
 }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<List<TreeNode>> tempRes = new ArrayList<>();
        if(root == null) return res;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.addLast(root);
        int level = 0;
        while(!list.isEmpty()){
            int len = list.size();
            if(tempRes.size() <= level) tempRes.add(new ArrayList<>());
            for (int i = 0; i < len; i++) {
                TreeNode node = list.pollFirst();
                if (node.left != null) list.addLast(node.left);
                if (node.right != null) list.addLast(node.right);
                tempRes.get(level).add(node);
            }
            level++;
        }
        for (int i = 0; i < tempRes.size(); i++) {
            res.add(new ArrayList<>());
        }
        for (int i = tempRes.size() - 1; i >= 0; i--) {
            for (TreeNode treeNode : tempRes.get(i)) {
                res.get(tempRes.size() - 1-i).add(treeNode.val);
            }
        }
        return res;
    }



}
