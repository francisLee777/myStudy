package leetcode_by_category.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @author lihaoyu
 * @date 2022/12/6 21:49
 */
public class Main726 {

    class Node {
        String ele; // 元素
        int count; // 个数
        boolean flag; // 是否是 (

        public Node(String ele, int count, boolean flag) {
            this.ele = ele;
            this.count = count;
            this.flag = flag;
        }
    }

    String countOfAtoms(String formula) {
        Stack<Node> stack = new Stack<>();
        // 首先要分词
        for (int i = 0; i < formula.length(); i++) {
            // 左括号直接进去
            if (formula.charAt(i) == '(') {
                stack.add(new Node("", 0, true));
                continue;
            }
            // 如果是大写字母，那么元素的开始
            if (Character.isUpperCase(formula.charAt(i))) {
                int j = i + 1;  // 循环直到遇到非小写字母
                while (j < formula.length() && Character.isLowerCase(formula.charAt(j))) {
                    j++;
                }
                String ele = formula.substring(i, j);
                int k = j;
                // 数量，可能没有，默认为 1
                while (k < formula.length() && Character.isDigit(formula.charAt(k))) {
                    k++;
                }
                int num = 1;
                if (k != j) {
                    num = Integer.parseInt(formula.substring(j, k));
                }
                stack.add(new Node(ele, num, false));
                i = j - 1; // 赋值循环位置
                continue;
            }
            // 右括号，后面跟的不一定是数字。出栈计算
            if (formula.charAt(i) == ')') {
                // 把数字取出来
                int k = i + 1;
                // 数量，可能没有，默认为 1
                while (k < formula.length() && Character.isDigit(formula.charAt(k))) {
                    k++;
                }
                int num = 1;
                if(k != i+1) num = Integer.parseInt(formula.substring(i + 1, k));
                List<Node> tempList = new ArrayList<>();
                while (!stack.isEmpty() && !stack.peek().flag) {
                    // 里面的元素都乘以倍数
                    Node node = stack.pop();
                    node.count *= num;
                    tempList.add(node);
                }
                // 把 ( 弹出来
                if (!stack.isEmpty()) stack.pop();
                // 再放回去，顺序没有关系
                stack.addAll(tempList);
                i = k - 1; // 赋值循环位置
            }
        }
        //  最后处理   先聚合，再排序
        TreeMap<String, Node> map = new TreeMap<>();
        for (Node node : stack) {
            Node temp = map.getOrDefault(node.ele, new Node(node.ele, 0, false));
            temp.count += node.count;
            map.put(node.ele, temp);
        }

        StringBuilder sb = new StringBuilder();
        map.forEach((k,v)->{
            sb.append(k);
            if(v.count != 1)sb.append(v.count);}
        );
        return sb.toString();
    }


    public static void main(String[] args) {
        Main726 main726 = new Main726();
        System.out.println(main726.countOfAtoms("(OH)"));
    }
}
