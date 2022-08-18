package run_2022.run_2022_07;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lihaoyu
 * @date 2022/7/10 11:38
 */
public class Main39 {


    private static void fun(List<List<Integer>> res,List<Integer> tempList,int[] candidates,int tempCount, int target, int start){
        if(tempCount > target) return;
        for (int i = start; i < candidates.length; i++) {
            tempList.add(candidates[i]);
            tempCount += candidates[i];
            if (tempCount == target){
                res.add(new ArrayList<>(tempList));
            }
            fun(res,tempList,candidates,tempCount,target,i);
            tempList.remove(tempList.size() - 1);
            tempCount -= candidates[i];
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
            if(candidates == null || candidates.length == 0 ) return res;
        fun(res,new ArrayList<>(),candidates,0,target,0);
        return res;
    }


    public static void main(String[] args) {
        Main39.combinationSum(new int[]{2,3,6,7},7);
    }
}
