package leetcode_by_category.tan_xin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lihaoyu
 * @date 2023/2/7 13:29
 */
public class Main769 {

    public static void main(String[] args) {
        Main769 m = new Main769();
        System.out.println(m.maxChunksToSorted(new int[]{1, 2, 0, 3}));
    }

    // [1,4,3,6,0,7,8,2,5]
    public int maxChunksToSorted(int[] arr) {
        int[] tempArr = new int[arr.length];
        System.arraycopy(arr, 0, tempArr, 0, arr.length);
        Arrays.sort(tempArr);
        // 做对比
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0, res = 0, temp;

        while (start < arr.length) {
            // 从 src 开始, 一个一个
            temp = map.getOrDefault(arr[start], 0);
            map.put(arr[start], temp + 1);
            if (temp == -1) {
                map.remove(arr[start]);
            }

            // 看下 desc
            temp = map.getOrDefault(tempArr[start], 0);
            map.put(tempArr[start], temp - 1);
            if (temp == 1) {
                map.remove(tempArr[start]);
                if (map.size() == 0) res++;
            }
            start++;
        }
        return res;
    }
}
