package run_2022.run_2022_10;

import interview.ms.First;

/**
 * 填充每个节点的下一个右侧节点指针 II
 *
 * @author lihaoyu
 * @date 2022/10/4 09:09
 */
public class Main117 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    // 填充每个节点的下一个右侧节点指针 II
    public Node connect(Node root) {
        Node res = root;
        while(root != null){
            Node firstDummy = new Node(1), temp = firstDummy;
            while (root != null) {
                if(root.left != null) {temp.next = root.left; temp = temp.next;}
                if(root.right != null) {temp.next = root.right; temp = temp.next;}
                root = root.next;
            }
            root = firstDummy.next;
        }
    return res;
    }

    public static void main(String[] args) {

    }
}
