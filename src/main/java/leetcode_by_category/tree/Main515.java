package leetcode_by_category.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 515. 在每个树行中找最大值
 *
 * @author lihaoyu
 * @date 2023/11/21 17:36
 */
public class Main515 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        fun(root, 0);
        return res;
    }

    void fun(TreeNode root, int depth) {
        if (root == null) return;
        if (res.size() <= depth) {
            res.add(root.val);
        } else {
            res.set(depth, Math.max(res.get(depth), root.val));
        }
        fun(root.left, depth + 1);
        fun(root.right, depth + 1);
    }

}