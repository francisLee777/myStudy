package leetcode_by_category.double_pointer_and_slice_window;

import java.util.HashMap;
import java.util.Map;

public class Main1679 {
    int fun(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.getOrDefault(k - num, 0) != 0) {
                map.put(k - num, map.get(k - num) - 1);
                res++;
                continue;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Main1679 main1679 = new Main1679();
        System.out.println(main1679.fun(new int[] { 3, 1, 3, 4, 3 }, 6));
    }
}
