package run_2022.run_2022_09;

import algorithm.temp.Temp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lihaoyu
 * @date 2022/9/28 14:03
 */
public class Main498 {



    //
    public int[] findDiagonalOrder(int[][] mat) {
        int raw = mat.length, col = mat[0].length;
        int[] res = new int[raw * col];
        List<List<Integer>> list = new ArrayList<>();
        for ( int i = 0 ; i < raw ; i++){
            list.add(new ArrayList<>());
            List<Integer>   temp = list.get(i);
            for(int j = i,c=0; j >= 0&&c<col ; j--,c++){
                temp.add(mat[j][c]);
            }
        }
        int tempCount = list.size();
        for ( int i = 1 ; i < col ; i++){
           list.add(new ArrayList<>());
            List<Integer>   temp = list.get(tempCount+i-1);
            for(int j = i,c=raw-1; j < col &&c>=0 ; j++,c--){
                temp.add(mat[c][j]);
            }
        }
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if((i % 2) == 0){
                // 正向
                for (Integer integer : list.get(i)) {
                    res[index++] = integer;
                }
            }else{
                // 反向
                for (int j = list.get(i).size() - 1; j >= 0; j--) {
                    res[index++] = list.get(i).get(j);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] diagonalOrder = new Main498().findDiagonalOrder(new int[][]{{
                1, 2, 3
        }, {4, 5, 6},
                {7, 8, 9}});
        for (int i : diagonalOrder) {
            System.out.print(i+" ");

        }
    }
}
