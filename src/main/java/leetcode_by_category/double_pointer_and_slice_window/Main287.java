package leetcode_by_category.double_pointer_and_slice_window;

/**
 * mark 手动收藏
 * 给定一个包含n + 1 个整数的数组nums，其数字都在 1 到 n之间（包括 1 和 n），
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

    // 快慢指针做法，数组元素看成链表节点，重复节点说明是带环链表，可快慢指针。

    public static int findDuplicate(int[] nums) {
        int start = 1, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) >> 1;
            int count = 0;
            for (int num : nums)
                count += num <= mid ? 1 : 0;
            if (count > mid)
                end = mid;
            else
                start = mid + 1;
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


    // 换位置的方法，可行
    public static int findDuplicate3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 == i)
                continue;
                while(nums[i] - 1 != i){
                    if( nums[i] == nums[nums[i]-1]){
                        return nums[i];
                    }
                    swap(nums,i,nums[i]-1);
                }
        }
        return 0;
    }

    static void swap(int[] nums, int i ,  int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate3(new int[] { 1, 3, 4, 2, 2 }));
        System.out.println(findDuplicate3(new int[] { 3,2,1,2 }));
    }
}
