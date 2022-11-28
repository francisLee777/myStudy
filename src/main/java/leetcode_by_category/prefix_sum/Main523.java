package leetcode_by_category.prefix_sum;

import java.util.HashMap;
import java.util.Map;

/*523. 连续的子数组和
给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：

子数组大小 至少为 2 ，且
子数组元素总和为 k 的倍数。
如果存在，返回 true ；否则，返回 false 。

如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。

 

示例 1：  手动收藏  mark   边界case

输入：nums = [23,2,4,6,7], k = 6
输出：true
解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。 */
public class Main523 {

    // 前缀和，一般搭配map食用 一般要特殊处理第0个数
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2)
            return false;
        // value 存 index
        Map<Integer, Integer> map = new HashMap<>();
        int tempSum = 0;
        map.put(tempSum, -1);
        for (int i = 0; i < nums.length; i++) {
            tempSum += nums[i];
            nums[i] = tempSum;
            if (map.containsKey(nums[i] % k) && i - map.get(nums[i] % k) >= 2) {
                return true;
            }
            if (!map.containsKey(nums[i] % k))
                map.put(nums[i] % k, i);
        }
        return false;
    }

}
