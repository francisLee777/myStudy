package run_2022.run_2022_08;

import java.util.Arrays;

/**
 * @author lihaoyu
 * @date 2022/8/13 21:13
 */
public class Main334 {

// 1 2 2 1
    public boolean increasingTriplet(int[] nums) {
   int[] n1 =   new int[nums.length];
   int[] n2 =   new int[nums.length];
   n1[0] = nums[0];
        Arrays.fill(n2, Integer.MAX_VALUE);
        for (int i = 1; i < nums.length; i++) {
            // 最小的一位数
            n1[i] = Math.min(n1[i-1],nums[i]);
            // 大于最小的数，是递增的第二或第三
            if(nums[i] > n1[i]){
                if(nums[i] <= n2[i-1]) n2[i] = nums[i];
                else return true;
            }else{
                n2[i] = n2[i-1];
            }
        }
        return false;
    }

}
