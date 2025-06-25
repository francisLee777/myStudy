package interview.huawei;

/**
 * 华为 9.17 二面   手动收藏
 * @author lihaoyu
 * @date 2020/9/17 2:56 下午
 */
public class Main21 {

    // 没有出现过的最小的正整数   4 -2 -3 1
    private static int fun(int[] nums) throws Exception {
        if (nums == null || nums.length == 0) throw new Exception("为空");
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) nums[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < nums.length; i++){
            if (nums[i] >= len) continue;
            int tempIndex = Math.abs(nums[i]) - 1;
            // 将本下标变成负数，说明不是未出现过的最小正整数
            nums[tempIndex] = -nums[tempIndex];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) return i+1;
        }
        return len+1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(fun(new int[]{-1,0,1,-4}));
    }
}
