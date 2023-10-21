package run_2022.run_2022_07;

import java.util.PriorityQueue;

/**
 * 手动收藏   用单调队列
 * @author lihaoyu
 * @date 2022/7/17 14:46
 */
public class Main239 {

    class Node implements Comparable<Node>{
        int val;
        int index;

        public Node(int val, int index){
            this.index = index;
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return val == node.val;
        }

        @Override
        public int hashCode() {
            int result = val;
            result = 31 * result + index;
            return result;
        }

        @Override
        public int compareTo(Node o) {
            if(val != o.val) return val-o.val;
            return index - o.index;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
    PriorityQueue<Node> queue = new PriorityQueue<>();
        int[] res = new int[]{nums.length -k+1};
        for (int i = 0; i < k; i++) {
            queue.add(new Node(nums[i],i));
        }
        for (int i = 0; i < res.length; i++) {
            res[i++] = queue.peek().val;
//            queue.
        }

return res;
    }


    public static void main(String[] args) {

    }
}
