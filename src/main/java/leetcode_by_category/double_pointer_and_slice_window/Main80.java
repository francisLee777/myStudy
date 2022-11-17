package leetcode_by_category.double_pointer_and_slice_window;

/**
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 *
 * Given nums = [1,1,1,2,2,3],
 *
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 * @author lihaoyu
 * @date 2022/11/3 12:52
 */
public class Main80 {

    public static int removeDuplicates(int[] nums) {
        if(nums.length <= 2) return nums.length;
        int left = 0  , right = 0, index = 0;
        while(right < nums.length){
            nums[index++] = nums[left];
            right = left + 1;
            if(right < nums.length && nums[right] != nums[left]){
                left++;
                continue;
            }
            if(right < nums.length && nums[right] == nums[left]){
                nums[index++] = nums[right++];
            }
            while(right < nums.length && nums[right] == nums[left]){
                right++;
            }
            left = right;
        }
        return index;
    }



    public static void main(String[] args) {

    }
}
