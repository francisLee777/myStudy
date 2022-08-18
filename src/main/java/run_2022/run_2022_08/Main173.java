package run_2022.run_2022_08;


import java.util.Stack;

/**
 * @author lihaoyu
 * @date 2022/8/13 20:49
 */
public class Main173 {

    Stack<TreeNode> stack = new Stack<>();
    TreeNode root ,p ;

    class TreeNode{
        int val;
         TreeNode left,right;
    }

    public Main173(TreeNode root) {
        // 先初始化
        this.root = root;
        p = root;
        while(p != null){
            stack.push(p);
            p = p.left;
        }
        // 最后p为null
    }

    public int next() {
        int res = 0;
        while(p != null){
            stack.push(p);
            p = p.left;
        }
        if(!stack.isEmpty()){
            p =  stack.pop();
            res = p.val;
            p = p.right;
        }
        return res;
    }

    public boolean hasNext() {
        return !stack.isEmpty() || p != null;
    }
}
