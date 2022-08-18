package run_2022.run_2022_07;


import java.util.ArrayList;
import java.util.List;

/**
 * @author lihaoyu
 * @date 2022/7/13 22:26
 */
public class Main99 {

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

    public void recoverTree(TreeNode root) {
fun(root);
        TreeNode first = null, second = null;
        for (int i = 0; i < list.size()-1; i++) {
            if( list.get(i).val > list.get(i+1).val && first == null){
                first = list.get(i);
            }
            if(  list.get(i).val > list.get(i+1).val){
                second = list.get(i+1);
            }
        }
        int temp = 0 ;
        temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
