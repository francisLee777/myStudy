package run_2022.run_2022_09;


/**
 * @author lihaoyu
 * @date 2022/9/28 17:51
 */
public class Main562 {

    // 最长的连续1线段 加锁的题目

    int n,m,max;

       int lc(int[][] a) {
        n = a.length;
        m = a[0].length;
        temp(a,1);
        temp(a,2);
        temp(a,3);
        temp(a,4);
 return max;
    }


    // 调用前拷贝一份  a
    void temp(int[][] a,int flag){
        int[][] b = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                b[i][j] = a[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                fun(b,i,j,1,flag);
            }
        }
    }

    void fun(int[][] a , int i,int j,int count, int flag){
        if(i < 0 || i >= n || j < 0 || j >= m || a[i][j] == 0 || a[i][j] > 1) return;
        a[i][j] = count;
        max = Math.max(max,count);
        switch (flag){
            case 1: fun(a,i+1,j,count+1,flag);return;
            case 2:fun(a,i,j+1,count+1,flag);return;
            case 3:fun(a,i+1,j+1,count+1,flag);return;
            case 4:fun(a,i+1,j-1,count+1,flag);return;
            default:return;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Main562().lc(new int[][]{{0, 1, 1}, {0, 1, 0}, {1, 0, 0}}));
    }
}
