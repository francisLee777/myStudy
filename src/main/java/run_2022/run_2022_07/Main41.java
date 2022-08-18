package run_2022.run_2022_07;

/**
 * @author lihaoyu
 * @date 2022/7/10 13:28
 */
public class Main41 {
    private void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < nums.length;i++) {
            while(true){
                if(nums[i] == i + 1 || nums[i] <= 0 || nums[i] >= len || nums[nums[i]-1]== nums[i]) break;
                swap(nums, nums[i]-1, i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i+1) return i+1;
        }
        return nums.length+1;
    }

    public static void main(String[] args) {
        System.out.println(new Main41().firstMissingPositive(new int[]{1,1}));

    }
}
