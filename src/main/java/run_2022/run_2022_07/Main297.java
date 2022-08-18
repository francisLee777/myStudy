package run_2022.run_2022_07;


import java.util.Stack;

/**
 * @author lihaoyu
 * @date 2022/7/29 10:22
 */
public class Main297 {

      class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
          TreeNode(int x) { val = x; }
  }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        fun(root);
        sb.deleteCharAt(0);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        for (int i = split.length - 1; i >= 0; i--) {
            stack.push(split[i]);
        }
        return fun2();
    }

  StringBuilder sb = new StringBuilder();
    Stack<String> stack = new Stack<>();
  void fun(TreeNode root){
      if(root == null){
          sb.append(",X");
          return;
      }
      sb.append(",").append(root.val);
      fun(root.left);
      fun(root.right);
  }

    TreeNode fun2(){
      if(stack.isEmpty() ) return null;
      String a = stack.pop();
      if ("X".equals(a))return null;
       TreeNode node = new TreeNode(Integer.parseInt(a));
        node.left = fun2();
        node.right = fun2();
        return node;
    }

    public static void main(String[] args) {

    }
}
