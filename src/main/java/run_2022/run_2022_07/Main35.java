package run_2022.run_2022_07;

/**
 * @author lihaoyu
 * @date 2022/7/25 22:40
 */
public class Main35 {

    public int searchInsert(int[] nums, int target) {
        int left = 0 , right = nums.length-1,mid;
        while(left <= right){
            mid = (left + right) /2;
            if(nums[mid] ==  target) return mid;
                if(nums[mid] > target) right = mid-1;
                else left = mid+1;
        }
        return right+1;
    }

}
