package leetcode_by_category.double_pointer_and_slice_window;

import algorithm.temp.Main;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author lihaoyu
 * @date 2022/12/7 22:32
 */
public class Main992 {

    public int fun(int[] nums, int k){
        // 双指针和滑动窗口
        int left = 0, right = 0,  res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while(right < nums.length){
//            right ++;
            // 入 map

            // 向右扩展
            while(right < nums.length && map.size() <= k){
                map.put(nums[right],map.getOrDefault(nums[right],0)+1);
                if(map.size() == k) {
                    res += (right - left - k + 2);
                }
                if(map.size() > k) {
                    map.put(nums[right],map.getOrDefault(nums[right],0)-1);
                    if(map.get(nums[right]) == 0) map.remove(nums[right]);
                    break;
                }
                right++;
            }
            // 左边收
            while(left <= right && map.size() == k){
                map.put(nums[left],map.get(nums[left]) - 1);
                if(map.get(nums[left]) == 0) map.remove(nums[left]);
                left++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Main992 main992 = new Main992();
        System.out.println(main992.fun(new int[]{1,2,2,3,1,1},2));
        TreeSet<Integer> set = new TreeSet<>();
    }
}
