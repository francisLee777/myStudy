package leetcode_by_category.interval;

import java.util.Arrays;
import java.util.Comparator;

// 2023年06月22日09:40:05
// 输入：points = [[10,16],[2,8],[1,6],[7,12]]
//输出：2
//解释：气球可以用2支箭来爆破:
//-在x = 6处射出箭，击破气球[2,8]和[1,6]。
//-在x = 11处发射箭，击破气球[10,16]和[7,12]。
public class Main452 {

    public static void main(String[] args) {

    }

    public int findMinArrowShots(int[][] points) {
        // 按照 x 轴先排序
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        // 然后开始遍历
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length - 1; j++) {
                // 看一下结尾
            }

        }


        return 0;
    }
}
