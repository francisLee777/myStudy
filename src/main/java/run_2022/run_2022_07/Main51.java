package run_2022.run_2022_07;

import java.util.ArrayList;
import java.util.List;

/**
 * N 皇后
 * @author lihaoyu
 * @date 2/27/2020 12:06 PM
 */
public class Main51 {

    // 不需要二维 map
     int[] visited;
    List<List<String>> list = new ArrayList<>();

    private  boolean validate(int row, int col){
        for(int i = 0; i < row; i++){
            // 检查竖着
            if(visited[i] == col) return false;
            // 检查斜着
            if(Math.abs(i-row) == Math.abs(visited[i] - col)) return false;
        }
        return true;
    }

     void print(){
         ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i < visited.length; i++) {
           StringBuilder sb = new StringBuilder();
            for (int j = 0; j < visited.length; j++) {
                if(visited[i] == j)   sb.append("Q");
                else sb.append(".");
            }
            temp.add(sb.toString());
        }
         list.add(temp);
     }

     void fun(int row){
        if(row == visited.length){
             print();
            return;
        }
        for(int col = 0; col < visited.length; col++){
            if(validate(row,col)){
                visited[row] = col;
                fun(row+1);
                // 不回溯也行，因为validate时候没计算后面的值
                visited[row] = 0;
            }
        }

    }

    public  List<List<String>> solveNQueens(int n) {
        visited = new int[n];
        fun(0);
        return list;
    }

    public static void main(String[] args) {

    }

}
