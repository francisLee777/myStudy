package algorithm.leetcode;

/**
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，要求：多次调用查找函数 get
 * 将答案缓存起来
 * @author lihaoyu
 * @date 3/3/2020 8:20 PM
 */
public class Main304 {


    // 一维求 sum(i,j) 可用 dp[j] - dp[i]   这个思想可以扩展到二维
    //   sum(i1,j1,i2,j2) = dp[i2][j2] - dp[i1][j2] - dp[i2][j1] + dp[i1][j1]
    private int[][] dp;

    public Main304(int[][] matrix) {
        int lenX = matrix.length, lenY = matrix[0].length;
        dp = new int[lenX+1][lenY+1];
        for(int i = 1; i <= lenX; i++)
            for(int j = 1; j <= lenY; j++)
                // 计算 dp 的手法
                dp[i][j] = dp[i-1][j] + dp[i][j-1] + matrix[i-1][j-1] - dp[i-1][j-1] ;


    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2+1][col2+1] - dp[row1][col2+1] - dp[row2+1][col1] + dp[row1][col1];
    }
}
