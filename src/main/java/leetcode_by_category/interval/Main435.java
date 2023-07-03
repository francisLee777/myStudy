package leetcode_by_category.interval;


import java.util.Arrays;
import java.util.Comparator;

/*
给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。

 */
public class Main435 {
    // 区间问题
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        int count = 1;
        // 先排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        // 遍历
        int right = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] >= right) {
                // 本来就没重叠
                right = interval[1];
                count++;
            }
        }
        return intervals.length - count;
    }

    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
    }
}
