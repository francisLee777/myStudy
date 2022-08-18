package run_2022.run_2022_07;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author lihaoyu
 * @date 2022/7/18 20:56
 */
public class Main827 {

 Map<Integer, Integer> map = new HashMap<>();
 int count = 2,maxRes = 0;
    public int largestIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int temp = fun(grid,i,j);
                map.put(count++,temp) ;
                maxRes = Math.max(maxRes,temp);
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
            if(grid[i][j] != 0) continue;
                Set<Integer> set = new HashSet<>();
                int tempCount = 0;
                if(fun2(grid,i-1,j)) set.add(grid[i-1][j]);
                if(fun2(grid,i+1,j)) set.add(grid[i+1][j]);
                if(fun2(grid,i,j-1)) set.add(grid[i][j-1]);
                if(fun2(grid,i,j+1)) set.add(grid[i][j+1]);
                for (Integer y : set) {
                    tempCount += map.getOrDefault(y,0);
                }
                maxRes = Math.max(maxRes,tempCount+1);
            }
            }
        return maxRes;
    }

    private boolean fun2(int[][] grid, int i,int j){
        return !(i >= grid.length || i < 0 || j < 0 || j >= grid[0].length || grid[i][j] == 0);
    }

    private int fun(int[][] grid, int i,int j){
        if(i >= grid.length || i < 0 || j < 0 || j >= grid[0].length || grid[i][j] != 1) return 0;
        grid[i][j] = count;
        return 1+fun(grid,i+1,j)+fun(grid,i-1,j)+fun(grid,i,j+1)+fun(grid,i,j-1);
    }
}
