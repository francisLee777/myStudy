package leetcode_by_category.binary_search;

public class Main410 {

    // 手动收藏
    // 给定一个非负整数数组 nums 和一个整数 k ，你需要将这个数组分成 k 个非空的连续子数组。
    // 设计一个算法使得这 k 个子数组各自和的最大值最小。

    public int splitArray(int[] nums, int k) {
        int min = 0, max = 0, left = 0, right = 0, mid = 0;
        for (int weight : nums) {
            min = Math.min(min, weight);
            max = Math.max(max, weight);
        }
        left = min;
        right = max * (nums.length / k + 1);
        while (left != right) {
            mid = left + (right - left) / 2;
            if (great(nums, mid, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // target 大了还是小了, 等于的话返回大了
    boolean great(int[] weights, int target, int count) {
        int tempCount = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > target) return false;
            tempCount += weights[i];
            if (i != weights.length - 1 && tempCount + weights[i + 1] > target) {
                count--;
                tempCount = 0;
                continue;
            }
            if (i == weights.length - 1) {
                count--;
            }

        }
        return count >= 0;
    }

}
