package run_2022.run_2022_10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lihaoyu
 * @date 2022/10/5 17:01
 */
public class Main199 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    public List<Integer> rightSideView(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if(root == null) return res;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.addLast(root);
        while(!list.isEmpty()){
            int size = list.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = list.pollFirst();
                if(i == 0 ) res.add(node.val);
                if(node.right != null) list.addLast(node.right);
                if(node.left != null) list.addLast(node.left);
            }
        }
        return res;
    }
}
