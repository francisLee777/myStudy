package leetcode_by_category.tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author lihaoyu
 * @date 2022/12/21 21:23
 */
public class Main1028 {
    // 第一个元素是深度，第二个是数字
    LinkedList<int[]> list = new LinkedList<>();


    public TreeNode recoverFromPreorder(String traversal) {
    //
        if(traversal.length() == 0)return null;
        int start=0,end = 0;
        for (; end < traversal.length(); end++) {
            if(!Character.isDigit(traversal.charAt(end))) break;
        }
        list.addLast(new int[]{0,Integer.parseInt(traversal.substring(start,end))});
        while (end < traversal.length()){
            start = end;
            for (; end < traversal.length(); end++) {
                if(traversal.charAt(end)!='-') break;
            }
            int depth = traversal.substring(start,end).length();
            start = end;
            for (; end < traversal.length(); end++) {
                if(!Character.isDigit(traversal.charAt(end))) break;
            }
            list.addLast(new int[]{depth,Integer.parseInt(traversal.substring(start,end))});
        }
        return fun(0);
    }

    TreeNode fun(int depth){
        if(list.isEmpty() || list.peek()[0] != depth) return null;
        TreeNode root = new TreeNode(list.poll()[1]);
        root.left = fun(depth+1);
        root.right = fun(depth+1);
return root;
    }

    public static void main(String[] args) {
Main1028 main1028 = new Main1028();
main1028.recoverFromPreorder("1-2--3--4-5--6--7");
    }
}
