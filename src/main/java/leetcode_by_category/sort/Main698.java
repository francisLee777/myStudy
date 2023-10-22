package leetcode_by_category.sort;

import java.util.Arrays;

/**
 * @author lihaoyu
 * @date 2022/12/13 10:27
 */
public class Main698 {

    boolean[] visited;

    boolean fun(int[] nums, int k){
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum % k != 0) return false;
        int target = sum / k;
        Arrays.sort(nums);
        visited = new boolean[nums.length];

        return false;
    }

    // 第一个小于等于目标值的下标  visited 不为 true
    int temp(int[] nums,int left, int right, int target){
        while(left != right){
            int mid = right - (right - left) /2;
            if(nums[mid] == target){
                // 两边随便找一个
                while(mid >= 0 && nums[mid] == target){
                    if(!visited[mid]) return mid;
                    mid--;
                }
                while(mid < nums.length && nums[mid] == target){
                    if(!visited[mid]) return mid;
                    mid++;
                }
                // 找不到，返回 -1
                return -1;
            }
            if(nums[mid] > target) right = mid-1;


        }



        return -1;
    }



}
