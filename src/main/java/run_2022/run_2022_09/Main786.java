package run_2022.run_2022_09;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author lihaoyu
 * @date 2022/9/21 23:15
 */
public class Main786 {

    class Node{
        int row; // 行做分子， 共有 n-1 行  从0开始
        int col; // 做分母，共有 n - row -1 列， 从 row + 1 开始

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }


    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> ((arr[o1.row] + 0.0) / arr[o1.col]) - ((arr[o2.row] + 0.0) / arr[o2.col]) < 0 ? 1 : -1);
        // 大顶堆
        for (int i = 0; i < arr.length - 1; i++) {
            queue.add(new Node(i,i+1));
        }
        int count = (arr.length * (arr.length - 1) )/2 - k + 1 ;
        Node node = null;
        while(!queue.isEmpty() && count != 0){

            node = queue.poll();
            if (node.col < arr.length - 1) queue.add(new Node(node.row,node.col+1));
            count--;
//            System.out.println(arr[node.row]+" "+arr[node.col]);
        }
//        System.out.println("答案"+arr[node.row]+" / "+arr[node.col]);
        return new int[]{arr[node.row],arr[node.col]};
    }


    public static void main(String[] args) {
        new Main786().kthSmallestPrimeFraction(new int[]{1,2,3,5},3);
    }
}
