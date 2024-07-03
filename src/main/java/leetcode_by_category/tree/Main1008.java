package leetcode_by_category.tree;

/**
 * 1008. 前序遍历构造二叉搜索树
 *
 * @author lihaoyu
 * @date 2023/11/21 18:02
 */
public class Main1008 {
    public static void main(String[] args) {
        Main1008 main1008 = new Main1008();
        main1008.bstFromPreorder(new int[]{4, 2});
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return fun(preorder, 0, preorder.length - 1);
    }

    TreeNode fun(int[] preorder, int start, int end) {
        if (start > end) return null;
        TreeNode root = new TreeNode(preorder[start]);
        // 找一下中间的，第一个大于 preorder[start] 的
        int i = start + 1;
        for (; i < preorder.length && i <= end; i++) {
            if (preorder[i] > preorder[start]) break;
        }
        root.left = fun(preorder, start + 1, i - 1);
        root.right = fun(preorder, i, end);
        return root;
    }
}