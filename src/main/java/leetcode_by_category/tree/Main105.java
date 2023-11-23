package leetcode_by_category.tree;

// 105. 从前序与中序遍历序列构造二叉树
public class Main105 {
    private TreeNode fun(int[] pre, int[] in, int start_pre, int start_in, int len) {
        if (len <= 0) return null;
        TreeNode root = new TreeNode(pre[start_pre]);
        int index = 0;
        for (int i = start_in; i < start_in + len; i++) {
            if (in[i] == root.val) {
                index = i;
                break;
            }
        }
        int leftLen = index - start_in;
        int rightLen = len - leftLen - 1;
        root.left = fun(pre, in, start_pre + 1, start_in, leftLen);
        root.right = fun(pre, in, start_pre + leftLen + 1, index + 1, rightLen);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return fun(preorder, inorder, 0, 0, inorder.length);
    }
}
