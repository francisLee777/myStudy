package run_2022.run_2022_07;

import java.util.LinkedList;

/**
 * @author lihaoyu
 * @date 2022/7/7 21:56
 */



public class Tree {
    class Node{
        String key;
        Node left,right;
    }

    public void preOrderRecursive(Node root){
        if (root == null) return;
        System.out.println(root.key);
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }

    // 非递归后序
    public void preOrderNotRecursive(Node root){
        LinkedList<Node> list1 = new LinkedList<>();
        LinkedList<Node> list2 = new LinkedList<>();
        Node temp;
        while(root != null || !list1.isEmpty()){
            while(root != null){
                list1.addFirst(root);
                root = root.left;
            }
            if(!list1.isEmpty()){
                temp = list1.pollFirst();
                list2.addFirst(temp);
            }

        }
    }


    public int maxArea(int[] height) {
        if (height == null || height.length == 0 ) return 0;
        int left = 0 , right = height.length -1, res = Math.min(height[left],height[right]) * (right - left) ;
        while(left != right){
            if (height[left] >= height[right]){
                right--;
            }else{
                left++;
            }
            res = Math.max(res,Math.min(height[left],height[right]) * (right - left));
        }
        return res;
    }

}
