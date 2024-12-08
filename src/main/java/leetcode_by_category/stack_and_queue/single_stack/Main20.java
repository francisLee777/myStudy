package leetcode_by_category.stack_and_queue.single_stack;


import java.util.Stack;

public class Main20 {

    // 小括号、中括号、大括号组合起来的括号有效性
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                case '[':
                case '{':
                    stack.add(s.charAt(i));
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') return false;
                    else stack.pop();
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') return false;
                    else stack.pop();
                    break;
                case '}':
                    if (stack.isEmpty() || stack.peek() != '{') return false;
                    else stack.pop();
                    break;
            }
        }
        return stack.isEmpty();
    }
    /**
     * 一个字符串合法括号字符串的条件:
     * 1. 左右括号数量相等;
     * 2. 任意一个位置左括号的数量都大于等于右括号的数量。
     */

    /**
     * 定义一个函数，检验字符串是否为合法括号字符串
     *
     * @param str 待检验的字符串
     * @return boolean 类型，是/否合法括号字符串
     */
    boolean isValid2(String str) {
        // 待匹配的左括号数量
        int left = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                left++;
            } else {
                // 遇到右括号
                left--;
            }

            // 右括号太多
            if (left == -1)
                return false;
        }
        // 是否所有的左括号都被匹配了
        return left == 0;
    }
}
