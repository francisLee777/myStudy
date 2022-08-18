package run_2022.run_2022_07;

/**
 * @author lihaoyu
 * @date 2022/7/20 22:49
 */
public class Main238 {


    public int[] productExceptSelf(int[] nums) {
        int []temp1 = new int[nums.length];
        int []temp2 = new int[nums.length];
        int []res = new int[nums.length];
        if(nums.length == 0 ) return res;
            temp1[0] = temp2[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
           temp1[i] = temp1[i-1] * nums[i-1];
        }
        for (int length = nums.length-2; length >= 0; length--) {
            temp2[length] = temp2[length+1] * nums[length+1];
        }
        res[0] = temp2[0];
        res[nums.length - 1] = temp1[nums.length - 1];
        for (int i = 1; i < nums.length-1; i++) {
            res[i] = temp1[i] * temp2[i];
        }
return res;
    }



    public static void main(String[] args) {

    }
}
