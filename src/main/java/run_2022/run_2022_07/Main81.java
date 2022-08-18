package run_2022.run_2022_07;


import java.util.Arrays;

/**
 * @author lihaoyu
 * @date 2022/7/24 15:44
 */
public class Main81 {

    public static boolean   fun(int[] nums, int target){
        if(nums == null || nums.length ==0 ) return  false;
        // 排序螺旋数组     4 5 6 1 2 3 4
        int left = 0 , right = nums.length - 1, mid ;
        while(left < right){
            mid = (left + right) / 2;
                if(nums[mid] > nums[right]) {
                    left = mid+1;
                    if(nums[left] < nums[left-1]) break;
                }
            else if (nums[mid] == nums[right]) {
                left++;
                    if(nums[left] < nums[left-1]) break;
                }
            else right = mid;
        }
        int temp1 = Arrays.binarySearch(nums, 0, left, target);
        int temp2 = Arrays.binarySearch(nums, left, nums.length, target);
        return temp1 >= 0 || temp2 >= 0 ;
    }


    public static void main(String[] args) {
        System.out.println(Main81.fun(new int[]{1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1},13));
    }
}
