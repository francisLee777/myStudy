package leetcode_by_category.double_pointer_and_slice_window;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 多维拉链法  多路归并
 *
 * @author lihaoyu
 * @date 2022/11/15 11:56
 */
public class Main719 {
    // 超时了
    // 假设 k 有效
    static int fun(int[] nums, int k) {
        Arrays.sort(nums);
        // 第一个数放 差值abs   第二个数放 本index 第三个数放作差 index
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            if (o1[1] != o2[1]) return o1[1] - o2[1];
            return o1[2] - o2[2];
        });
        // 初始化填充
        for (int i = 1; i < nums.length; i++) {
            queue.add(new int[]{nums[i] - nums[i - 1], i - 1, i});
        }
        int res = -1;
        while (k != 0) {
            int[] poll = queue.poll();
            res = poll[0];
            if (poll[2] + 1 < nums.length) {
                queue.add(new int[]{nums[poll[2] + 1] - nums[poll[1]], poll[1], poll[2] + 1});
            }
            k--;
        }
        return res;
    }


    public static void main(String[] args) {

        System.out.println(fun(new int[]{38, 33, 57, 65, 13, 2, 86, 75, 4, 56}, 26));
        System.out.println(fun(new int[]{1, 1, 2}, 2));
    }


}

