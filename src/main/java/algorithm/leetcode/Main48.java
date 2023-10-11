package algorithm.leetcode;

/**
 * 给定一个 n×n 的二维矩阵表示一个图像。
 * <p>
 * 将图像顺时针旋转 90 度。
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 *
 * @author lihaoyu
 * @date 2020/11/18 10:13 上午
 */
public class Main48 {

    public static void main(String[] args) {

        Main48 main48 = new Main48();
        int[][] nums = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        main48.print(nums);
        main48.rotate(nums);
        main48.print(nums);
    }


    public void rotate(int[][] matrix) {
        int level = matrix.length / 2;
        for (int i = 0; i < level; i++) {
            for (int j = i; j < matrix.length - i - 1; j++) {
                fun(matrix, i, j);
            }
        }
    }

    public void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public void fun(int[][] nums, int i, int j) {
        int n = nums.length, temp = nums[i][j];
        nums[i][j] = nums[n - j - 1][i];
        nums[n - j - 1][i] = nums[n - i - 1][n - j - 1];
        nums[n - i - 1][n - j - 1] = nums[j][n - i - 1];
        nums[j][n - i - 1] = temp;
    }

}
