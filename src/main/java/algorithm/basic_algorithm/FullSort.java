package algorithm.basic_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 求 全排列的多种方法 手动收藏
 *
 * @author lihaoyu
 * @date 2019/12/12 14:41
 */
public class FullSort {

    private static final List<String> res = new ArrayList<>();

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 经典简洁方案
    private static void fun(char[] arr, int i) {
        if (i == arr.length) {
            res.add(new String(arr));
            return;
        }
        // 注意是从 i 开始， 否则 3 * 2 * 1 * 0 最后是0了
        for (int j = i; j < arr.length; j++) {
            swap(arr, i, j);
            fun(arr, i + 1);
            swap(arr, i, j);
        }
    }

    // 用 flags 标记来求全排列   注意：这种方法符合字典序
    private static void fun(int[] nums, int j, boolean[] flags, String sb, List<String> res) {
        if (j >= nums.length) {
            res.add(sb);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!flags[i]) {
                flags[i] = true;
                fun(nums, j + 1, flags, sb + nums[i], res);
                flags[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        fun(new char[]{'1', '2', '3'}, 0);
        System.out.println(res);
        System.out.println(new FullSort().permuteUnique(new int[]{1, 1, 2}));
    }

    // 带有重复数字的, 输入的 arr 要求是有序的
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        funUnique(nums, new boolean[nums.length], new ArrayList<>(), res);
        return res;
    }

    void funUnique(int[] nums, boolean[] flags, List<Integer> temp, List<List<Integer>> res) {
        if (temp.size() >= nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 如果数字已使用过或者与前一个相同且前一个未使用，则跳过
            if (flags[i] || i > 0 && nums[i] == nums[i - 1] && !flags[i - 1]) {
                continue;
            }
            flags[i] = true;
            temp.add(nums[i]);
            funUnique(nums, flags, temp, res);
            temp.remove(temp.size() - 1);
            flags[i] = false;
        }
    }
}
