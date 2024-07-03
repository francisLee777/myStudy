package leetcode_by_category.stack_and_queue;

import java.util.Stack;

public class Main1003 {

    public static void main(String[] args) {
        Main1003 main1003 = new Main1003();
        System.out.println(main1003.isValid("abccba"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stack.add(c);
            while (!stack.isEmpty() && stack.peek() == 'c') {
                // 前两个必须是 a b
                stack.pop();
                if (stack.isEmpty() || stack.pop() != 'b')
                    return false;
                if (stack.isEmpty() || stack.pop() != 'a')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
