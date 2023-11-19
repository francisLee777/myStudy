package leetcode_by_category.tree;

public class Main129 {

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = sumNumbers(root.left);
        int right = sumNumbers(root.right);
        int temp1 = 0, temp2 = 0;
        if (root.left != null) temp1 = 0;
        return 0;
    }


    // 返回一个数字是几位数
    int len(int n) {
        int res = 0;
        while (n != 0) {
            n = n / 10;
            res++;
        }
        return res;
    }
}
