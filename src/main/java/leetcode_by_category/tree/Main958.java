package leetcode_by_category.tree;

import java.util.LinkedList;

/**
 * 判断完全二叉树
 * @author lihaoyu
 * @date 2022/12/29 10:30
 */
public class Main958 {


    public boolean isCompleteTree(TreeNode root){
        if(root == null) return true;
        // 层序遍历
        LinkedList<TreeNode> list = new LinkedList<>();
        boolean stop = false;
        list.addLast(root);
        while(!list.isEmpty()){
            int n = list.size();
            for(int i = 0; i < n; i++){
                TreeNode node = list.pollFirst();
                if(node.left != null) {
                    list.addLast(node.left);
                    if(stop) return false;
                } else stop = true;
                if(node.right != null) {
                    list.addLast(node.right);
                    if(stop) return false;
                } else stop = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
