package leetcode_by_category.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lihaoyu
 * @date 2023/1/6 23:20
 */
public class Main834 {

    class Node {
        int val;
        int count; // 所有子节点的数量
        int res; // 当前结果的答案
        List<Node> list;

        public Node(int val) {
            this.val = val;
            list = new ArrayList<>();
        }

    }

    Map<Integer,Node> c2p = new HashMap<>();
    Map<Integer, Node> allNode = new HashMap<>();
    int[] res ;


    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        res = new int[n];
        for (int[] edge : edges) {
            Node tempP = new Node(edge[0]);
            Node tempC = new Node(edge[1]);
            allNode.put(edge[0],tempP);
            allNode.put(edge[1],tempC);
        }
        // 先构建一个树
        for (int[] edge : edges) {
            Node root = allNode.get(edge[0]);
            root.list.add(allNode.get(edge[1]));
            c2p.put(edge[1],allNode.get(edge[0]));
        }
        // 找根节点
        Node root = null;
        for (Integer integer : allNode.keySet()) {
            if (!c2p.containsKey(integer)){
                root = allNode.get(integer);
                break;
            }
        }
        // 递归，计算子节点数量。
        temp(root,1);
        // 从根节点开始计算
        res[root.val] = root.res;
        for (Node node : root.list) {
            cal(node,root);
        }
        return res;
    }



    void cal(Node node, Node parent){
        if(node == null || parent == null) return;
        // parent 的子节点中，除了 node 的子节点数量
        int count = 0;
        for (Node temp : parent.list) {
            if(temp.val == node.val) continue;
            count += temp.count;
        }
        node.res  = parent.res + count + parent.list.size() - 1 - node.count;
        res[node.val] = node.res;
        for (Node gg : node.list) {
            cal(gg,node);
        }
    }

    int temp(Node root,int depth){
        if(root == null) return 0;
        int count = 0;
        for (Node node : root.list) {
            int temp1 = temp(node,depth+1);
            count += temp1;
            root.res += temp1 + node.res;
        }
        root.count = count;
        return count + 1;
    }


    public static void main(String[] args) {
Main834 main834 = new Main834();
        int[] ints = main834.sumOfDistancesInTree(6, new int[][]{{0, 1}, {0,2},{2,3},{2,4},{2,5}});
        for (int so : ints) {
            System.out.print(so+" ");
        }
    }
}
