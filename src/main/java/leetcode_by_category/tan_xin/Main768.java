package leetcode_by_category.tan_xin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 arr 。
 * 将 arr 分割成若干 块 ，并将这些块分别进行排序。之后再连接起来，使得连接的结果和按升序排序后的原数组相同。
 * 返回能将数组分成的最多块数？
 * 输入：arr = [2,1,3,4,4]
 * 输出：4
 * 解释：
 * 可以把它分成两块，例如 [2, 1], [3, 4, 4]。
 * 然而，分成 [2, 1], [3], [4], [4] 可以得到最多的块数。
 *
 * @author lihaoyu
 * @date 2023/2/13 22:35
 */
public class Main768 {


    public static void main(String[] args) {
        Main768 m = new Main768();
        System.out.println(m.maxChunksToSorted(new int[]{1, 2, 0, 3}));
    }

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
