package run_2022.run_2022_07;

/**
 * @author lihaoyu
 * @date 2022/7/16 19:22
 */
public class Main209 {

    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE, left = 0, right = 0,count = 0;
        while(right < nums.length){
            count += nums[right];
            while(count >= target){
                res = Math.min(right - left + 1,res);
                count -= nums[left++];
            }
            right++;
        }
        return res == Integer.MAX_VALUE?0:res;
    }


}
