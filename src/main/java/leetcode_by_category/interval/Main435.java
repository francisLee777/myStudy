package leetcode_by_category.interval;


import java.util.Arrays;

/*
给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。

 */
public class Main435 {


    // 区间问题
    public static int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        // 先排序
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            return -o1[1] + o2[1];
        });
        // 遍历
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= right) {
                // 本来就没重叠
                right = intervals[i][1];
                continue;
            }
            // 有重叠了
            count++;
            // 在里面了
            if (intervals[i][1] <= right) {
                right = intervals[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
    }
}
