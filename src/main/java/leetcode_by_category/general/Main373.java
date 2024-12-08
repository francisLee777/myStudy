package leetcode_by_category.general;

import java.util.*;


// 查找和最小的 K 对数字.定义一对值 (u,v)，其中第一个元素来自nums1有序数组，第二个元素来自 nums2有序数组。请找到和最小的 k 个数对
// 手动收藏，多路归并。要用优先级队列存放，否则直接for循环多路会导致超时
public class Main373 {

    public static void main(String[] args) {
        System.out.println(kSmallestPairs(new int[]{1, 3}, new int[]{2, 5}, 3));
    }

    static public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 以 nums1 竖向拉链
        List<List<Integer>> res = new ArrayList<>();
        // 数组为三元组
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0] + o[1]));
        for (int i = 0; i < nums1.length; i++) {
            queue.add(new int[]{nums1[i], nums2[0], 0});
        }
        while (k > 0) {
            // 保证了 k 一定有效
            int[] poll = queue.poll();
            res.add(Arrays.asList(poll[0], poll[1]));
            if (poll[2] + 1 < nums2.length) {
                queue.add(new int[]{poll[0], nums2[poll[2] + 1], poll[2] + 1});
            }
            k--;
        }
        return res;
    }

}
