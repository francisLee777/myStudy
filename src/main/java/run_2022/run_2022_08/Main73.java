package run_2022.run_2022_08;

/**
 * @author lihaoyu
 * @date 2022/8/14 17:10
 */
public class
Main73 {

    public static void main(String[] args) {
        Main73 main73 = new Main73();
        int[][] ints = {{1, 1, 2, 0}, {3, 0, 5, 2}, {1, 3, 1, 5}};
        main73.fun(ints);
        main73.setZeroes(ints);
        main73.fun(ints);
    }

    void fun(int[][] ints) {
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i + " ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    public void setZeroes(int[][] matrix) {
        int xLen = matrix[0].length, yLen = matrix.length;
        // 第一行和第一列有没有0
        boolean row = false, column = false;
        // 先遍历第一行
        for (int i = 0; i < xLen; i++) {
            if (matrix[0][i] == 0) row = true;
        }
        for (int i = 0; i < yLen; i++) {
            if (matrix[i][0] == 0) column = true;
        }

        for (int i = 1; i < yLen; i++) {
            for (int j = 1; j < xLen; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        fun(matrix);
        // 最后进行填充0
        for (int i = 1; i < yLen; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < xLen; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < xLen; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < yLen; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        // 看下第一行
        if (row) {
            for (int i = 0; i < xLen; i++) {
                matrix[0][i] = 0;
            }
        }

        if (column) {
            for (int i = 0; i < yLen; i++) {
                matrix[i][0] = 0;
            }
        }
    }


}
