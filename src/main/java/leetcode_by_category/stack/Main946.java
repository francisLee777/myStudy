package leetcode_by_category.stack;

import java.util.Stack;

public class Main946 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < popped.length; i++) {
            while (stack.isEmpty() || stack.peek() != popped[i]) {
                if (index >= pushed.length)
                    return false;
                stack.add(pushed[index++]);
            }
            stack.pop();
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Main946 main946 = new Main946();
    }

}
