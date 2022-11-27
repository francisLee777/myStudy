package leetcode_by_category.basic_tree;

public class Main988 {
    public String smallestFromLeaf(TreeNode root) {
        String temp = fun(root, "");
        StringBuilder sb = new StringBuilder();
        for (int i = temp.length() - 1; i >= 0; i--) {
            sb.append((char) (temp.charAt(i) - '0' + 'a'));
        }
        return sb.toString();
    }

    String fun(TreeNode root, String sb) {
        if (root == null)
            return sb;
        sb += root.val;
        if (root.left == null || root.right == null)
            return sb;
        if (root.left.val < root.right.val)
            return fun(root.left, sb);
        else if (root.left.val > root.right.val)
            return fun(root.right, sb);
        String s1 = fun(root.left, sb);
        String s2 = fun(root.right, sb);
        if (s1.compareTo(s2) < 0)
            return s1;
        else
            return s2;
    }
}
