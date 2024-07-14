package leetcode_by_category.double_pointer_and_slice_window;

import java.util.Arrays;

/**
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
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
        //
        int zero = 0;
        int two = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) continue;
            // 遇到了0或者2
            if (nums[i] == 0) {
                // 从左边找第一个不为0的
                for (; zero < i; zero++) {
                    if (nums[zero] != 0) break;
                }
                // 不为0，这里一定要注意， 如果是 zero != i 则会导致无限循环
                if (zero < i) {
                    swap(nums, i, zero);
                    i--;
                    continue;
                }
            }
            if (nums[i] == 2) {
                // 从右边找第一个不为2的
                for (; two > i; two--) {
                    if (nums[two] != 2) break;
                }
                // 不为2
                if (two > i) {
                    swap(nums, i, two);
                    i--;
                    continue;
                }
            }
        }
    }
}
