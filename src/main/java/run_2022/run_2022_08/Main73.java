package run_2022.run_2022_08;

/**
 * @author lihaoyu
 * @date 2022/8/14 17:10
 */
public class
Main73 {

    boolean fun(int[][] matrix,int i, int j){
        for (int x = i+1; x < matrix.length; x++) {
            for (int y = i+1; y < matrix[x].length; y++) {
                if(matrix[x][y] == 0) return true;
            }
        }
        return false;
    }

    public void setZeroes(int[][] matrix) {



    }

}
