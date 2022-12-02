package leetcode_by_category.double_pointer_and_slice_window;

import java.util.HashMap;
import java.util.Map;

public class Main457 {

    public boolean circularArrayLoop(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        if (nums.length <= 1)
            return false;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur++;
            if (map.containsKey(i)) {
                map.put(i, cur);
                continue;
            }
            int index = i, prev = i;
            while (true) {
                if (map.getOrDefault(index, -1).equals(cur))
                    if (prev != index)
                        return true;
                    else {
                        break;
                    }
                map.put(index, cur);
                int temp = index + nums[index] < 0 ? nums.length - ((-index - nums[index]) % nums.length)
                        : (index + nums[index]) % nums.length;
                if (nums[index] * nums[temp] < 0) {
                    map.put(temp, cur);
                    break;
                }
                prev = index;
                index = temp;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Main457 main457 = new Main457();
        // System.out.println(main457.circularArrayLoop(new int[] { -1, -2, -3, -4, -5
        // }));
        // System.out.println(main457.circularArrayLoop(new int[] { 2, -1, 1, 2, 2 }));
        System.out.println(main457.circularArrayLoop(new int[] { 1, -1, 5, 1, 4 }));

    }
}
