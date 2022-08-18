package run_2022.run_2022_07;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lihaoyu
 * @date 2022/7/23 16:40
 */
public class Main128 {

    public static int longestConsecutive(int[] nums) {
     int res = 0 ;
     if (nums == null || nums.length == 0 ) return 0;
        Set<Integer> set = new HashSet<>();
        Set<Integer> flag = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            if(flag.contains(nums[i])) continue;
            if (set.contains(nums[i])){
                int tempCount1 = 0,tempCount2 = 0 ;
                while(set.contains(nums[i] + tempCount1)){
                    tempCount1++;
                    flag.add(nums[i] + tempCount1);
                }
                while(set.contains(nums[i] - tempCount2)){
                    tempCount2++;
                    flag.add(nums[i] - tempCount2);
                }
                res = Math.max(res,tempCount1 + tempCount2 -1);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(Main128.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println(-1 %10);
    }
}
