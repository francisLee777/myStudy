package leetcode_by_category.stack_and_queue;

import java.util.Stack;

public class Main921 {

    public static void main(String[] args) {
        Main921 main921 = new Main921();
        System.out.println(main921.minAddToMakeValid("()))(("));
    }

    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add('(');
            } else {
                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else
                    stack.add(')');
            }
        }
        return stack.size();
    }
}
