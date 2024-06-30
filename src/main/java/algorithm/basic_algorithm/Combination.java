package algorithm.basic_algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lihaoyu
 * @date 2019/12/20 11:34
 */
public class Combination {

    private static final int count = 3;
    private static final List<List<Integer>> res = new ArrayList<>();
    private static final List<Integer> tempList = new ArrayList<>();

    // 求组合数 选择数
    private static void fun(int[] nums, int i) {
        if (tempList.size() == count) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int j = i; j < nums.length; j++) {
            tempList.add(nums[j]);
            fun(nums, j + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        fun(new int[]{1, 2, 3, 4, 5}, 0);
        System.out.println(res);
    }
}
