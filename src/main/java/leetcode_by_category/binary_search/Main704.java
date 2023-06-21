package leetcode_by_category.binary_search;

/**
 * @author lihaoyu
 * @date 2019/12/21 20:47
 */
public class Main704 {

    public static void main(String[] args) {
        Main704.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        // 分开找
        int left = 0, right = nums.length - 1, mid = 0, tempMid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (nums[mid] != target) {
            return res;
        }
        tempMid = mid;
        // 两边找, 左边第一个等于target的
        left = 0;
        right = tempMid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else {
                // 只剩小于了
                left = mid + 1;
            }
        }
        res[0] = left;
        // 找另外一边
        left = tempMid;
        right = nums.length - 1;
        while (left < right) {
            mid = right - (right - left) / 2;
            if (nums[mid] == target) {
                left = mid;
            } else {
                // 只剩大于了
                right = mid - 1;
            }
        }
        res[1] = left;
        return res;
    }

    // 二分查找，返回下标【预期a是有序的】。 入参有问题返回-2， 没找到返回-1
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -2;
        }
        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

}