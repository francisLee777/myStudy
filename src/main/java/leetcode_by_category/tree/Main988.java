package leetcode_by_category.tree;

public class Main988 {
    StringBuilder res = new StringBuilder();

    public String smallestFromLeaf(TreeNode root) {
        if (root == null)
            return "";
        fun(root, new StringBuilder());
        StringBuilder res2 = new StringBuilder();
        for (int i = res.length() - 1; i >= 0; i--) {
            res2.append(res.charAt(i));
        }
        return res2.toString();
    }

    boolean compare(StringBuilder res, StringBuilder temp) {
        for (int i = 1; i <= res.length() && i <= temp.length(); i++) {
            if (res.charAt(res.length() - i) == temp.charAt(temp.length() - i))
                continue;
            return res.charAt(res.length() - i) > temp.charAt(temp.length() - i);
        }
        return res.length() > temp.length();
    }

    // 后续遍历
    void fun(TreeNode root, StringBuilder sb) {

        if (root.left == null && root.right == null) {
            sb.append((char) ('a' + root.val));
            if (res.length() == 0 || compare(res, sb)) {
                res = new StringBuilder(sb);
            }
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        sb.append((char) ('a' + root.val));
        if (root.left != null)
            fun(root.left, sb);
        if (root.right != null)
            fun(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {

        Main988 main988 = new Main988();
        TreeNode root = new TreeNode(25);
        TreeNode root2 = new TreeNode(1);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(1);
        TreeNode root5 = new TreeNode(3);
        TreeNode root6 = new TreeNode(0);
        TreeNode root7 = new TreeNode(2);
        // root.right = root3;
        root.left = root2;
        root.right = root3;
        root2.left = root4;
        root2.right = root5;
        root3.left = root6;
        root3.right = root7;
        main988.smallestFromLeaf(root);
    }
}
