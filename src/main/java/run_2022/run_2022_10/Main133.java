package run_2022.run_2022_10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author lihaoyu
 * @date 2022/10/5 15:43
 */
public class Main133 {

    public class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if(node == null) return node;
        Map<Integer, Node> visited = new HashMap<>();
        Map<Integer, Node> visited2 = new HashMap<>();
        Node newRoot = new Node(node.val,new ArrayList<>());
        LinkedList<Node> list = new LinkedList<>();
        list.addLast(node);
        LinkedList<Node> list2 = new LinkedList<>();
        list2.addLast(newRoot);
        while(!list.isEmpty()){
           Node poll =  list.pollFirst();
           Node temp = list2.pollFirst();
           if(visited.containsKey(poll.val)) continue;
            visited.put(temp.val,temp);
            visited2.put(temp.val,temp);
            for (Node neighbor : poll.neighbors) {
                    Node add = visited2.getOrDefault(neighbor.val,new Node(neighbor.val,new ArrayList<>()));
                    visited2.put(add.val,add);
                    temp.neighbors.add(add);
                    list.addLast(neighbor);
                    list2.addLast(add);
                }
        }
        return newRoot;
    }


    void fun(){
        Node node1 = new Node(1,new ArrayList<>());
        Node node2 = new Node(2,new ArrayList<>());
        Node node3 = new Node(3,new ArrayList<>());
        Node node4 = new Node(4,new ArrayList<>());
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        Node node = cloneGraph(node1);
        System.out.println(node);
    }



    public static void main(String[] args) {
        Main133 main133 = new Main133();
main133.fun();
    }

}
