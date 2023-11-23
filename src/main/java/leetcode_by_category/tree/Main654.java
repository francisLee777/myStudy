package leetcode_by_category.tree;

// 654. 最大二叉树
public class Main654 {


    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return fun(nums, 0, nums.length - 1);
    }

    TreeNode fun(int[] nums, int start, int end) {
        if (start > end) return null;
        int tempMax = nums[start], tempIndex = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > tempMax) {
                tempMax = nums[i];
                tempIndex = i;
            }
        }
        TreeNode root = new TreeNode(tempMax);
        root.left = fun(nums, start, tempIndex - 1);
        root.right = fun(nums, tempIndex + 1, end);
        return root;
    }
}
