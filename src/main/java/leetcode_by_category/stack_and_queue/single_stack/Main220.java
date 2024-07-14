package leetcode_by_category.stack_and_queue.single_stack;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums 和两个整数 indexDiff 和 valueDiff 。
 * 找出满足下述条件的下标对 (i, j)：
 * i != j,
 * abs(i - j) <= indexDiff
 * abs(nums[i] - nums[j]) <= valueDiff
 * 如果存在，返回 true ；否则，返回 false
 *
 * @author lihaoyu
 * @date 2022/11/24 16:29
 */
public class Main220 {

    public static void main(String[] args) {
        Main220 main220 = new Main220();
        System.out.println(main220.containsNearbyAlmostDuplicate(new int[]{1, 2, 1, 1}, 1, 0));
    }

    boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (nums.length <= indexDiff) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i + 1] - nums[i] <= valueDiff) return true;
            }
            return false;
        }
        int[] temp = new int[indexDiff + 1];
        if (indexDiff + 1 >= 0) System.arraycopy(nums, 0, temp, 0, indexDiff + 1);
        Arrays.sort(temp);
        for (int i = 0; i < temp.length - 1; i++) {
            if (temp[i + 1] - temp[i] <= valueDiff) return true;
        }
        int left = 0, deleteIndex, add;
        while (left + indexDiff + 1 < nums.length) {
            deleteIndex = Arrays.binarySearch(temp, nums[left]);
            add = nums[left + indexDiff + 1];
            if (temp(temp, add, deleteIndex, valueDiff)) return true;
            left++;
        }
        return false;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    boolean temp(int[] nums, int add, int deleteIndex, int k) {
        nums[deleteIndex] = add;
        for (int i = deleteIndex; i < nums.length - 1 && nums[i] > nums[i + 1]; i++) {
            if (nums[i + 1] - add <= k) return true;
            swap(nums, i, i + 1);
        }
        for (int i = deleteIndex; i > 0 && nums[i] < nums[i - 1]; i--) {
            if (add - nums[i - 1] <= k) return true;
            swap(nums, i, i - 1);
        }
        return false;
    }
}
