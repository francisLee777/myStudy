package leetcode_by_category.tree;

// 889. 根据前序和后序遍历构造二叉树  手动收藏
public class Main889 {
    public static void main(String[] args) {
        Main889 main889 = new Main889();
        TreeNode treeNode = main889.constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1});
        System.out.println(treeNode);
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return fun(preorder, postorder, 0, preorder.length - 1, 0);
    }

    TreeNode fun(int[] preorder, int[] postorder, int startPre, int endPre, int startPost) {
        if (startPre > endPre) return null;
        if (startPre == endPre) return new TreeNode(preorder[startPre]);
        TreeNode root = new TreeNode(preorder[startPre]);
        int i = 0;
        for (; i < postorder.length; i++) {
            if (preorder[startPre + 1] == postorder[i]) {
                break;
            }
        }
        int LeftLen = i - startPost + 1;
        root.left = fun(preorder, postorder, startPre + 1, startPre + LeftLen, startPost);
        root.right = fun(preorder, postorder, startPre + 1 + LeftLen, endPre, i + 1);
        return root;
    }

}
