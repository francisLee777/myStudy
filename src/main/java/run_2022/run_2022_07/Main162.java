package run_2022.run_2022_07;

/**
 * @author lihaoyu
 * @date 2022/7/24 16:27
 */
public class Main162 {


    public static int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        int[] a = new int[nums.length],b =  new int[nums.length];
        a[0] = nums[0];
        if(nums[0] > nums[1]) return 0;
        if(nums[nums.length-1] > nums[nums.length-2]) return nums.length-1;
        b[nums.length-1] = nums[nums.length-1];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > a[i-1]) a[i] = nums[i];
            else a[i] = a[i-1];
        }
        for (int i = nums.length-2; i > 0; i--) {
            if(nums[i] > b[i+1]) b[i] = nums[i];
            else b[i] = b[i+1];
        }
        for (int i = 1; i < nums.length-1; i++) {
                if(nums[i] == a[i] && nums[i] == b[i]) return i;
        }
        return -1;
    }


    public static void main(String[] args) {

    }
}
