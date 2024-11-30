package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 手动收藏   时间复杂度 O(n)
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 * @author lihaoyu
 * <p>
 * 输入：nums = [1,2,2,3], k = 3
 * 输出：2
 * @date 2020/5/17 7:08 下午
 */
public class Main560 {

    public static void main(String[] args) {

    }

    public int subarraySum(int[] nums, int k) {
        // 存储 sum 和 对应的次数,  不断去找 map [ sum - k ] 的次数
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, res = 0;
        map.put(0, 1);  // 重要
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) res += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
