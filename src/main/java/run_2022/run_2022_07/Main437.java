package run_2022.run_2022_07;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lihaoyu
 * @date 2022/7/31 21:28
 */
public class Main437 {

     class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
         }

    // 路径和   方法：前缀和
    int count2 = 0,target;
    void fun2(TreeNode root, long sum, Map<Long, Integer> map){
        if(root == null) return;
        long curSum = sum + root.val;
        count2 +=  map.getOrDefault(curSum - target,0);
        map.put( sum + root.val,map.getOrDefault(sum + root.val,0)+1);
        fun2(root.left, curSum, map);
        fun2(root.right, curSum, map);
        map.put( sum + root.val,map.getOrDefault(sum + root.val,1)-1);
    }

    public int pathSum2(TreeNode root, int targetSum) {
        target = targetSum;
        Map<Long, Integer> map  =  new HashMap<>(256);
        map.put(0L,1);
        fun2(root,0,map);
        return count2;
    }




         int count = 0;

     void fun(TreeNode root, long targetSum){
         if(root == null) return ;
         targetSum -= root.val;
         if(targetSum == 0) count++;
         fun(root.left,targetSum);
         fun(root.right,targetSum);
     }

    public int pathSum(TreeNode root, int targetSum) {
         if(root == null) return 0;
        fun(root,targetSum);
       pathSum(root.left,targetSum);
       pathSum(root.right,targetSum);
       return count;
    }




}
