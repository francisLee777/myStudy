package leetcode_by_category.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lihaoyu
 * @date 2023/1/3 22:34
 */
public class Main863 {

    List<TreeNode> path = new ArrayList<>();
    List<TreeNode> temp = new ArrayList<>();
    List<TreeNode> res = new ArrayList<>();
    List<Integer> last = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k){
        fun(root,target);
        // 添加一个 dummy 节点
        int count = path.size();
        path.add(new TreeNode(-1));
        // 从根节点开始, 到最后一个节点
        for (int i = 0; i < path.size() - 1; i++) {
            TreeNode next = path.get(i+1);
            TreeNode cur = path.get(i);
            if(k+i+1-count == 0) res.add(cur);
            if(cur.left != next) temp(cur.left,k+i-count);
            if(cur.right != next) temp(cur.right,k+i-count);
        }
        for (TreeNode re : res) {
            last.add(re.val);
        }
        return last;
    }

    void temp(TreeNode root, int K){
        if(K < 0 || root == null) return;
        if(K == 0){
            res.add(root);
            return;
        }
        temp(root.left,K-1);
        temp(root.right,K-1);
    }



    // 先找路径
    void fun(TreeNode root, TreeNode target){
        if(root == null) return;
        temp.add(root);
        if(root == target){
            path.addAll(temp);
            return;
        }
        fun(root.left,target);
        fun(root.right,target);
        temp.remove(temp.size()-1);
    }



    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node2.left = node3;
        node3.left = node4;
        node3.right = new TreeNode(22);
        node4.left = node5;
        node5.left = node6;

        Main863 main863 = new Main863();
        System.out.println(main863.distanceK(node1, node4, 2));
    }
}
