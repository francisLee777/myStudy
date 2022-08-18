package run_2022.run_2022_07;


/**
 * @author lihaoyu
 * @date 2022/7/13 22:54
 */
public class Main114 {
    class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int val) { this.val = val; }
    }

    private TreeNode res = new TreeNode(2), temp = res;

    private void fun(TreeNode root){
        if(root == null)return;
        temp.right = new TreeNode(root.val);
        temp = temp.right;
        fun(root.left);
        fun(root.right);
    }

    public void flatten(TreeNode root) {
        if (root == null) return;
        fun(root);
        root.left = null;
        root.right = res.right.right;
    }

    public static void main(String[] args) {

    }
}
