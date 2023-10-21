package leetcode_by_category.tree;

/**
 * @author lihaoyu
 * @date 2023/1/2 14:51
 */
public class Main968 {

    int res = 0;


    public int minCameraCover(TreeNode root) {
        if(root == null) return res;
        if(root.left == null && root.right == null) return 1;
        int[] fun = fun(root);
        if (fun[1] == 0) res++;
        return res;
    }


    // 第一个元素是有没有被标记, 第二个元素是有没有被覆盖
    int[] fun(TreeNode root){
        if(root == null) return new int[]{0,0};

        int[] left = fun(root.left);
        int[] right = fun(root.right);
        // 叶子节点不标记
        if(root.left == null && root.right == null){
            return new int[]{0,0};
        }
        if(temp(root)){
            res++;
            return new int[]{1,1};
        }
        // 左右子树都没被覆盖
        if(root.left != null && left[1] == 0 || root.right != null && right[1] == 0){
            res++;
            return new int[]{1,1};
        }
        // 左右子树有被标记的
        if(root.left != null && left[0] == 1 || root.right != null && right[0] == 1){
            return new int[]{0,1};
        }
        return new int[]{0,0};
    }

    //
    boolean temp(TreeNode root){
        // 左右子树[如有]是不是有叶子节点
        if(root == null) return false;
        if(root.left != null && root.left.left == null && root.left.right == null)return true;
        if(root.right != null && root.right.left == null && root.right.right == null)return true;
        return false;
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
        node4.left = node5;
        node5.left = node6;
        Main968 main968 = new Main968();
        main968.fun(node1);
        System.out.println(main968.res);
    }
}
