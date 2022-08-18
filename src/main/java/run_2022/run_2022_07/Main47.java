package run_2022.run_2022_07;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * @author lihaoyu
 * @date 2022/7/10 19:50
 */
public class Main47 {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> temp = new ArrayDeque<>();
    int[] nums;
    boolean []used ;
    private void fun(int k){
        if(k == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            //  && used[i-1] 也可以，但剪枝不彻底
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            temp.addLast(nums[i]);
            used[i] = true;
          fun(k+1);
          temp.removeLast();
            used[i] = false;
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        used = new boolean[nums.length];
        fun(0);
        return  res;
    }

    public static void main(String[] args) {
        System.out.println(new Main47().permuteUnique(new int[]{1,3,3}));

    }
}
