package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Main532 {
    // 手动收藏 mark
    int findPairs(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer key : map.keySet()) {
            if (k == 0 && map.getOrDefault(key, 0) > 1 || k > 0 && map.getOrDefault(key + k, 0) > 0)
                res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Main532 main532 = new Main532();
        System.out.println(main532.findPairs(new int[] { 1, 2, 4, 4, 3, 3, 0, 9, 2, 3
        }, 3));
    }
}
