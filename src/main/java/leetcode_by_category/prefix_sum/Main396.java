package leetcode_by_category.prefix_sum;

/**
 * 旋转函数
 * 输入: nums = [4,3,2,6]
 *
 * 输出: 26
 *
 * 解释:
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 * 所以 F(0), F(1), F(2), F(3) 中的最大值是 F(3) = 26 。
 * @author lihaoyu
 * @date 2023/2/7 12:40
 */
public class Main396 {

    static int fun(int[] nums){
        // 计算第一个
        int res = 0,tempRes = 0,count = 0;
        for (int i = 0; i < nums.length; i++) {
            res += i * nums[i];
            count += nums[i];
        }
        tempRes = res;
        //
        for (int i = nums.length-1; i >=1; i--) {
            tempRes = tempRes + count - nums.length * nums[i];
            res = Math.max(res,tempRes);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Main396.fun(new int[]{4, 3, 2, 6}));
    }
}
