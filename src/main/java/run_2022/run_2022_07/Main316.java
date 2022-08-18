package run_2022.run_2022_07;

import java.util.Stack;

/**
 * @author lihaoyu
 * @date 2022/7/24 21:27
 */
public class Main316 {


    public String removeDuplicateLetters(String s) {
        int[] a = new int[256],b = new int[256];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i)]++;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (b[c] == 0){
                while(!stack.isEmpty() && stack.peek() > c && a[stack.peek()] > 0){
                    b[stack.pop()] = 0;
                }
                b[c] = 1;
                stack.add(c);
            }
            a[c]--;
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
