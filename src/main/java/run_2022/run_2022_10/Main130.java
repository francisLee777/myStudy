package run_2022.run_2022_10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @author lihaoyu
 * @date 2022/10/5 09:20
 */
public class Main130 {

    boolean[][] visited;

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(visited[i][j] || board[i][j] == 'X'){
                    continue;
                }
                LinkedList<int[]> list = new LinkedList<>();
                List<int[]> tempList = new ArrayList<>();
                list.addLast(new int[]{i,j});
                tempList.add(new int[]{i,j});
                visited[i][j] = true;
                boolean isFlag = edge(i,j,m,n);
                while(!list.isEmpty()){
                    int[] ints = list.pollFirst();
                    // 四个方向
                    if(func(ints,board,list,tempList)) isFlag = true;
                }
                // 最后看下 flag 是不是联通的，如果不是，把所有 tempList 里面的换成X
                if(!isFlag){
                    for (int[] ints : tempList) board[ints[0]][ints[1]] = 'X';
                }
            }
        }
    }

    boolean func(int[] ints, char[][] board, LinkedList<int[]> list,List<int[]> tempList){
        boolean flag = false;
        int i = ints[0], j = ints[1], m = board.length,n=board[0].length;
        int [][]position = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        for (int[] pos : position) {
            if( valid(i+pos[0],j+pos[1],m,n) &&!visited[i+pos[0]][j+pos[1]] && board[i+pos[0]][j+pos[1]] == 'O'){
                list.addLast(new int[]{i+pos[0],j+pos[1]});
                tempList.add(new int[]{i+pos[0],j+pos[1]});
                visited[i+pos[0]][j+pos[1]] = true;
                if(edge(i+pos[0],j+pos[1],m,n)) flag = true;
            }
        }
        return flag;
    }

    boolean edge(int i, int j, int m, int n){
     if(i == 0 || j == 0 || i == m-1 || j == n-1) return true;
     return false;
    }

    boolean valid(int i, int j, int m, int n){
        return i >= 0 && i < m && j >= 0 && j < n;
    }




    public static void main(String[] args) {
new Main130().solve( new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}});
        TreeSet<Integer> set = new TreeSet<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        set.add(5);
        set.add(3);
        set.add(1);
        set.add(6);
//        System.out.println(set.ceiling(9));
        queue.add(new int[]{3,2});
        queue.add(new int[]{4,2});
        System.out.println(queue.poll()[0]);
    }

}
