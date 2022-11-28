package leetcode_by_category.stack.single_stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author lihaoyu
 * @date 2022/11/24 20:56
 */
public class Main84 {
    public int largestRectangleArea(int[] heights) {
        // 升序排列
        int[] tempInt = new int[heights.length + 1];
        System.arraycopy(heights, 0, tempInt, 0, heights.length);
        tempInt[tempInt.length - 1] = 0;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tempInt.length; i++) {
            while (!stack.isEmpty() && tempInt[stack.peek()] >= tempInt[i]) {
                int current = stack.pop();
                // 这里需要思考一下
                int top = stack.isEmpty() ? -1 : stack.peek();
                max = Math.max(max, (i - top - 1) * tempInt[current]);
            }
            stack.push(i);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Main84().largestRectangleArea(new int[] { 1, 10, 1000, 10000, 6000 }));
    }
}
