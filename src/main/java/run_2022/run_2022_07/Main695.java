package run_2022.run_2022_07;

/**
 * @author lihaoyu
 * @date 2022/7/18 20:51
 */
public class Main695 {

    public int maxAreaOfIsland(int[][] grid) {
            int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                res = Math.max(res,fun(grid,i,j));
            }
        }
            return res;
    }

    private int fun(int[][] grid, int i,int j){
        if(i >= grid.length || i < 0 || j < 0 || j >= grid[0].length || grid[i][j] != 1) return 0;
        grid[i][j] = 2;
        return 1+fun(grid,i+1,j)+fun(grid,i-1,j)+fun(grid,i,j+1)+fun(grid,i,j-1);
    }

}
