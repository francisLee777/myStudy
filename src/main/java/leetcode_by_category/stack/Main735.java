package leetcode_by_category.stack;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author lihaoyu
 * @date 2022/12/6 23:17
 */
public class Main735 {

    public int[] asteroidCollision(int[] asteroids){
        Stack<Integer> stack = new Stack<>();
        for (int num : asteroids) {
            if(stack.isEmpty() || stack.peek() * num > 0 || (stack.peek() < 0 && num > 0)){
                stack.add(num);
                continue;
            }
            // 需要出栈的场景
            while(!stack.isEmpty() && (stack.peek() > 0 && num < 0) && Math.abs(stack.peek()) < Math.abs(num)){
                stack.pop();
            }
            if(stack.isEmpty()){
                stack.add(num);
                continue;
            }
            if((stack.peek() > 0 && num < 0) && Math.abs(stack.peek()) == Math.abs(num)){
                stack.pop();
                continue;
            }
            if((stack.peek() > 0 && num < 0) && Math.abs(stack.peek()) > Math.abs(num)){
                continue;
            }
            stack.add(num);
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            res[i] = stack.get(i);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
