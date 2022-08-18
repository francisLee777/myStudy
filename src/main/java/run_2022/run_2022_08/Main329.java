package run_2022.run_2022_08;


/**
 * @author lihaoyu
 * @date 2022/8/17 23:47
 */
public class Main329 {
    int[][] path,matrix;
    int chang, kuan;
    int max = 1;

    public int longestIncreasingPath(int[][] matrix) {
    this.matrix = matrix;
    chang = matrix[0].length;
    kuan = matrix.length;
        path = new int[kuan][chang];
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[0].length; j++) {
                path[i][j] = 1;
            }
        }
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[0].length; j++) {
                func(i,j,1);
            }
        }
        return max;
    }


    void func(int i, int j, int count){
        max = Math.max(max,count);
         fun(i,j,i+1,j,count);
         fun(i,j,i-1,j,count);
         fun(i,j,i,j+1,count);
         fun(i,j,i,j-1,count);
    }


    void fun(int i, int j, int x, int y, int count){
        if(x >= 0 && x < kuan && y >=0 && y < chang &&
                matrix[i][j] < matrix[x][y] && path[x][y] < count+1){
            path[x][y] = Math.max( path[x][y],count+1);
            func(x,y,count+1);
        }
    }
}
