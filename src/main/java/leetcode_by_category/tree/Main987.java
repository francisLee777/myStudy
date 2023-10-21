package leetcode_by_category.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lihaoyu
 * @date 2022/12/7 18:16
 */
public class Main987 {

    class Node {
        int depth;
        int index;
        TreeNode treeNode;

        public Node(int depth, int index, TreeNode treeNode) {
            this.depth = depth;
            this.index = index;
            this.treeNode = treeNode;
        }
    }

    public List<List<Integer>> fun(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        // 层序遍历
        List<Node> tempList = new ArrayList<>();
        List<List<Node>> tempRes = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, root));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.pollFirst();
                tempList.add(node);
                if (node.treeNode.left != null)
                    queue.addLast(new Node(node.depth + 1, node.index - 1, node.treeNode.left));
                if (node.treeNode.right != null)
                    queue.addLast(new Node(node.depth + 1, node.index + 1, node.treeNode.right));
            }
        }
        tempList.sort((o1,o2)->{
            if(o1.depth == o2.depth && o1.index == o2.index) return o1.treeNode.val - o2.treeNode.val;
            if(o1.index != o2.index) return o1.index - o2.index;
            return o1.depth - o2.depth;
        });
        for (Node node : tempList) {
            if(tempRes.isEmpty()){
                tempRes.add(new ArrayList<>());
                tempRes.get(0).add(node);
                continue;
            }
            if(node.index != tempRes.get(tempRes.size() -1).get(0).index){
                tempRes.add(new ArrayList<>());
            }
            tempRes.get(tempRes.size() -1).add(node);
        }
        for (List<Node> list : tempRes) {
            res.add(new ArrayList<>());
            for (Node node : list) {
                res.get(res.size()-1).add(node.treeNode.val);
            }
        }
        return res;
    }


    public static void main(String[] args) {

    }
}
