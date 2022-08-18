package run_2022.run_2022_08;

import java.util.Arrays;
import java.util.Random;

/**
 * @author lihaoyu
 * @date 2022/8/14 13:51
 */
public class Main384 {
    int[] nums;
    public Main384(int[] nums) {
this.nums = nums;
    }

    public int[] reset() {
        return nums;
    }
     void swap(int[] a , int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
     }

    public int[] shuffle() {
        Random random = new Random();
        int[] ints = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < ints.length; i++) {
            swap(ints,i,random.nextInt(i+1));
        }
        return ints;
    }
}

