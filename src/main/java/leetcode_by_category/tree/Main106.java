package leetcode_by_category.tree;

// 106. 从中序与后序遍历序列构造二叉树
public class Main106 {
    private TreeNode fun(int[] in, int[] post, int start_in, int end_post, int len) {
        if (len <= 0) return null;
        TreeNode root = new TreeNode(post[end_post]);
        int index = 0;
        for (int i = start_in; i < start_in + len; i++) {
            if (in[i] == root.val) {
                index = i;
                break;
            }
        }
        int leftLen = index - start_in;
        int rightLen = len - leftLen - 1;
        root.left = fun(in, post, start_in, end_post - 1 - rightLen, leftLen);
        root.right = fun(in, post, index + 1, end_post - 1, rightLen);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return fun(inorder, postorder, 0, postorder.length - 1, inorder.length);
    }
}
