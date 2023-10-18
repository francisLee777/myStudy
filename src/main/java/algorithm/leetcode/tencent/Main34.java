package algorithm.leetcode.tencent;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author lihaoyu
 * @date 2019/12/20 20:44
 */
public class Main34 {


    public static void main(String[] args) {
        Main34 main34 = new Main34();
        int[] ints = main34.searchRange2(new int[]{5, 7, 7, 8, 8, 10}, 8);
        for (int anInt : ints) {
            System.out.print(" " + anInt);
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int index = Arrays.binarySearch(nums, target);
        if (index < 0) return res;
        int left = index, right = index;
        while (left > 0 && nums[left] == nums[left - 1]) left--;
        while (right < nums.length - 1 && nums[right] == nums[right + 1]) right++;
        res[0] = left;
        res[1] = right;
        return res;
    }

    public int[] searchRange2(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        res[0] = funLeft(nums, target);
        res[1] = funRight(nums, target);
        return res;
    }

    // 找最左边等于目标值的
    int funLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] != target) return mid;
                right = mid - 1;
            }
        }
        return -1;
    }

    // 找最右边等于目标值的
    int funRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid + 1] != target) return mid;
                left = mid + 1;
            }
        }
        return -1;
    }
}
