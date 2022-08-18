package run_2022.run_2022_07;

/**
 * @author lihaoyu
 * @date 2022/7/10 19:21
 */
public class Main48 {


    public static void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length == 1) return;
        int []temp = new int[matrix.length];
        int n = 0,len = matrix.length;
        while(2 * n + 1 < matrix.length){
            for(int i = n; i < matrix.length -n;i++){
                temp[i] = matrix[n][i];
            }
            for(int i = n; i < matrix.length -n;i++){
                matrix[n][len-1-i] =   matrix[i][n] ;
            }
            for(int i = n; i < matrix.length -n;i++){
                matrix[i][n]  =  matrix[len-n-1][i];
            }
            for(int i = n; i < matrix.length -n;i++){
                matrix[len-n-1][i] = matrix[len-1-i][len-1-n];
            }
            for(int i = n; i < matrix.length -n;i++){
                matrix[len-1-i][len-1-n] = temp[len-i-1];
            }
            n++;
        }
    }


    public static void main(String[] args) {
        int[][] temp = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(temp);
        for (int[] ints : temp) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
    }
}
