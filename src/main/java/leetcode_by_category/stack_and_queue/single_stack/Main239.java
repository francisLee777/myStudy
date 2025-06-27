package leetcode_by_category.stack_and_queue.single_stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 手动收藏， 滑动窗口+单调栈
// 239. 滑动窗口最大值
// 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
// 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

public class Main239 {
    public static void main(String[] args) {
        Main239 temp = new Main239();
        System.out.println(Arrays.toString(temp.maxSlidingWindow(new int[]{3, 2, 1, 4}, 2)));
        System.out.println(Arrays.toString(temp.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(temp.maxSlidingWindow(new int[]{1, -1}, 1)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!list.isEmpty() && nums[list.getLast()] < nums[i]) list.pollLast();
            list.addLast(i);
            if (i - list.getFirst() >= k) {
                list.pollFirst();
            }
            if (i >= k - 1)
                res.add(nums[list.getFirst()]);
        }
        int[] a = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            a[i] = res.get(i);
        }
        return a;
    }
}
