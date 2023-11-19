package leetcode_by_category.prefix_sum;

import java.util.Random;

/**
 * 给你一个 下标从 0 开始 的正整数数组 w ，其中 w[i] 代表第 i 个下标的权重。
 * 请你实现一个函数 pickIndex ，它可以 随机地 从范围 [0, w.length - 1] 内（含 0 和 w.length - 1）选出并返回一个下标。选取下标 i 的 概率 为 w[i] / sum(w) 。
 * 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 + 3) = 0.75（即，75%）。
 */
public class Main528 {

    // 前缀和
    int[] sum;
    Random random = new Random();

    public Main528(int[] w) {
        sum = new int[w.length];
        sum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            sum[i] = sum[i - 1] + w[i];
        }
    }


    //  [1,3,5]   [1,4,9]
    public static void main(String[] args) {
        Main528 main528 = new Main528(new int[]{1, 3, 5});
        System.out.println(main528.func(main528.sum, 9));
    }

    public int pickIndex() {
        int target = 1 + random.nextInt(sum[sum.length - 1]);
        // 找一下在数组中的位置，二分，找第一个大于等于target的下标
        return func(sum, target);
    }

    int func(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid;
        while (start != end) {
            mid = start + (end - start) / 2;
            if (target > nums[mid]) {
                start = mid + 1;
            }
            if (target <= nums[mid]) {
                end = mid;
            }
        }
        return start;
    }
}
