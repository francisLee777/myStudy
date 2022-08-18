package run_2022.run_2022_07;

/**
 * @author lihaoyu
 * @date 2022/7/13 22:04
 */
public class Main230 {
    class TreeNode{
        int val;
        TreeNode left,right;
    }

    private int num = 0;

    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        int left = kthSmallest(root.left,k);
        num++;
        if(num == k) return root.val;
        int right =   kthSmallest(root.right,k);
        if (left != 0) return  left;
        return right;
    }
}
