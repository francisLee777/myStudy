package leetcode_by_category.tree;

public class Main108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return fun(nums, 0, nums.length - 1);
    }


    TreeNode fun(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(nums[start + (end - start) / 2]);
        root.left = fun(nums, start, start + (end - start) / 2 - 1);
        root.right = fun(nums, start + (end - start) / 2 + 1, end);
        return root;
    }
}
