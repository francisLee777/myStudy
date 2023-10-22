package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 * @author lihaoyu
 * @date 2019/12/20 15:16
 */
public class Main39 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return res;
        }
        fun(candidates,0,target,new ArrayList<>(),res);
        return res;
    }

    private static void fun(int[] nums, int j, int target, List<Integer> tempList, List<List<Integer>> res){
        if(j >= nums.length)return;
        if(target == 0){
            res.add(new ArrayList<>(tempList));
            return;
        }
        if(target < 0){
            return;
        }
        // 不好的写法  1. dfs树过大，没剪枝   2. 有重复路径，当输入有重复数字时不正确
        for(int i = j; i < nums.length; i++){
            tempList.add(nums[i]);
            fun(nums,i,target-nums[i],tempList,res);
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = combinationSum(new int[]{2, 3,2, 5}, 8);
        System.out.println(list);
    }
}
