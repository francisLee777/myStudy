package leetcode_by_category.double_pointer_and_slice_window;

import java.util.Arrays;

/**
 * 题目 #
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note: You are not suppose to use the library’s sort function for this problem.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * <p>
 * Follow up:
 * <p>
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0’s, 1’s, and 2’s, then overwrite array with total number of 0’s, then 1’s and followed by 2’s.
 * Could you come up with a one-pass algorithm using only constant space?
 *
 * @author lihaoyu
 * @date 2022/11/2 20:31
 */
public class Main75 {


    public static void main(String[] args) {
        Main75 main75 = new Main75();
        int[] ints = {0, 2, 2, 0, 2, 1};
        main75.sortColors(ints);
        System.out.println(Arrays.toString(ints));
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] nums) {
        // 先找一下左右不为0和2的第一个元素
        int count0 = 0, count2 = 0, len = nums.length, start = 0, end = len - 1;
        while (start <= end && nums[start] == 0) {
            start++;
            count0++;
        }
        while (start <= end && nums[end] == 2) {
            end--;
            count2++;
        }
        // 处理中间的
        int i = start;
        while (i <= end) {
            //
            if (nums[i] == 0) {
                if (nums[start] == 0) {
                    start++;
                    continue;
                }
                swap(nums, start, i);
                start++;
                if (nums[i] != 2) {
                    i++;
                }
                continue;
            }
            if (nums[i] == 2) {
                if (nums[end] == 2) {
                    end--;
                    continue;
                }
                swap(nums, end, i);
                end--;
                if (nums[i] != 0) {
                    i++;
                }

                continue;
            }
            i++;
        }
    }

}
