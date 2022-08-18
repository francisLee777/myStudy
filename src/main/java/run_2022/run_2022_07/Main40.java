package run_2022.run_2022_07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。 
 * @author lihaoyu
 * @date 2022/7/10 12:18
 */
public class Main40 {


    private static void fun(List<List<Integer>> res,List<Integer> tempList, int[] candidates,int tempCount , int target,int start ){
        if (target < tempCount) return;
        if (tempCount == target){
            res.add(new ArrayList<>(tempList));
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < tempCount + candidates[i]) return;
            if(i > start && candidates[i] == candidates[i-1]){
                continue;
            }
            tempList.add(candidates[i]);
            fun(res,tempList,candidates,tempCount + candidates[i],target,i+1);
            tempList.remove(tempList.size() - 1);
        }
    }


    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        if(candidates == null || candidates.length == 0 ) return res;
        fun(res,new ArrayList<>(),candidates,0,target,0);
        return res;
    }


    public static void main(String[] args) {
        System.out.println(Main40.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }
}
