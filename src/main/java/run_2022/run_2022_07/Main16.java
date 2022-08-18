package run_2022.run_2022_07;

import java.util.Arrays;

/**
 * @author lihaoyu
 * @date 2022/7/9 16:38
 */
public class Main16 {


    public static int threeSumClosest(int[] nums, int target) {
        // -4 -1 1 2    1
        int res = Integer.MIN_VALUE , temp = Integer.MAX_VALUE ;
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length - 1; i++) {
            int tempTarget = target - nums[i];
            int left = i+1 , right = nums.length - 1;
            while(left < right){
                // 绝对值小，记录
                if (Math.abs(tempTarget-nums[left]-nums[right]) < temp){
                    temp = Math.abs(tempTarget-nums[left]-nums[right]);
                    res = nums[i] + nums[left] + nums[right];
                }
                if (nums[left]+nums[right] <= tempTarget){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Main16.threeSumClosest(new int[]{1,2,-1,-4},1);
    }
}
