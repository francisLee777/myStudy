package leetcode_by_category.tree;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 手动收藏 mark
 *        1
 *   2         3
 *     4
 *
 * 给出二叉树的根节点 root，树上每个节点都有一个不同的值。如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。返回森林中的每棵树。你可以按任意顺序组织答案。
 * @author lihaoyu
 * @date 2022/12/20 10:54
 */
public class Main1110 {
    Set<Integer> set;
    List<TreeNode> res;


    // 答案，一次递归， 使用递归函数的返回值是精髓
    public List<TreeNode> delNodes2(TreeNode root, int[] to_delete) {
        res = new ArrayList<>();
        set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }
        goodFun(root,true);
        return res;
    }

    // isRoot , 可能是不是新森林的根节点
    boolean goodFun(TreeNode root,boolean isRoot){
        if(root == null) return false;
        if(isRoot && !set.contains(root.val)){
            res.add(root);
        }
        isRoot = set.contains(root.val);
        if (goodFun(root.left,isRoot)){
            root.left = null;
        }
        if (goodFun(root.right,isRoot)){
            root.right = null;
        }
        return isRoot;
    }



    // 下面是自己写的
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        res = new ArrayList<>();
         set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }
        // 遍历树，遇到删除的数就置 0
        fun(root);
        if(root != null && root.val != 0) res.add(root);
        fun2(root);
        for (TreeNode re : res) {
            fun3(re);
        }
        return res;
    }

        void fun(TreeNode root){
            if(root == null) return;
            if(set.contains(root.val)){
                root.val = 0;
            }
            fun(root.left);
            fun(root.right);
        }

    void fun2(TreeNode root){
        if(root == null) return;
        if (root.val == 0) {
            if(root.left != null && root.left.val != 0) res.add(root.left);
            if(root.right != null && root.right.val != 0) res.add(root.right);
        }
        fun2(root.left);
        fun2(root.right);
    }

    void fun3(TreeNode root){
        if(root == null) return;
        if(root.left != null && root.left.val == 0) root.left = null;
        if(root.right != null && root.right.val == 0) root.right = null;
        fun3(root.left);
        fun3(root.right);
    }



    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        Main1110 main1110 = new Main1110();
        main1110.delNodes(node1,new int[]{3});
    }
}
