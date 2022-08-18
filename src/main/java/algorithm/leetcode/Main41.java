package algorithm.leetcode;

/**
 * 缺失的第一个正整数
 *  如 数组 5, 0, 15, 1 , 4, 2 ,6, -1 中缺失的第一个正整数是 3
 *  重要思想 ： 缺少的正整数一定在  1 - len 中！
 * @author lihaoyu
 * @date 2/27/2020 11:54 AM
 */
public class Main41 {

    public static int firstMissingPositive(int[] nums) {
        // 假设输入nums都是正整数
        int[] res = new int[nums.length];
        for (int num : nums) {
            if(num < res.length && num > 0 ) res[num-1] = 1; // 表示出现过
        }
        for (int i = 0; i < res.length; i++) {
            if(res[i] == 0) return i+1;
        }
        return res.length+1;
    }

    private static void swap(int[] nums, int i , int j ){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int firstMissingPositive2(int[] nums) {
        boolean isLen = false;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <= 0) continue;
            if(nums[i] > nums.length) {
                nums[i] = -1111;
                continue;
            }
            while(nums[i] > 0 && nums[i] <=  nums.length && nums[i] != i){
                if(nums[i] == nums.length) {
                    isLen = true;
                    break;
                }

                swap(nums, nums[i],i);
            }
            if(nums[i] != i)nums[i] = -222;
        }
        int j;
        for (j = 1; j < nums.length; j++) {
            if(nums[j] <= 0) return j;
        }
        return isLen ? nums.length+1 : nums.length;
    }



    // 题目要求原地修改计算，不借助辅助空间。  思路：把自己当 bitmap
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{5, 15, 1, 4, 2, 6}));
        System.out.println(firstMissingPositive2(new int[]{3,2,4,1,9}));
    }
}
