package algorithm.leetcode;

/**
 * mark 手动收藏
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 输入: [1,3,4,2,2]
 * 输出: 2
 *
 * 输入: [2,2,2,3]
 * 输出: 2
 *
 * 注意要求空间复杂度为O(1) 所以用二分法
 *
 * @author lihaoyu
 * @date 2020/5/30 2:01 下午
 */
public class Main287 {


    public static int findDuplicate(int[] nums) {
        int start = 1, end = nums.length - 1;
        while(start < end){
            int mid = (start + end) >> 1;
            int count = 0;
            for (int num : nums) count += num <= mid ? 1 : 0;
            if(count > mid) end = mid;
            else start = mid + 1;
        }
        return start;
    }

    // 错误的方法
    public static int findDuplicate2(int[] nums) {
        int count = 0;
        for (int num : nums) {
            count += num;
        }
        return count - (nums.length - 1) * nums.length / 2;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate2(new int[]{1,3,4,2,2}));

    }
}
