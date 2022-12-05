package leetcode_by_category.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main1006 {

    // 计算一次
    void cal(Stack<Integer> number, Stack<Character> op) {
        if (number.size() < 2 || op.isEmpty())
            return;
        Integer pop1 = number.pop();
        Integer pop2 = number.pop();
        Character pop = op.pop();
        switch (pop) {
            case '+':
                number.push(pop1 + pop2);
                break;
            case '-':
                number.push(pop2 - pop1);
                break;
            case '*':
                number.push(pop1 * pop2);
                break;
            case '/':
                number.push(pop2 / pop1);
                break;
            default:
        }
    }

    public int clumsy(int n) {
        // 操作优先级
        Map<Character, Integer> map = new HashMap();
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int flag = 0, res = 1;
        // 不需要初始化

        for (int i = n; i >= 1; i--) {
            // 数字直接入栈
            nums.add(i);
            if (i == 1)
                break; // 最后一个没操作符
            char op = '*';
            switch (flag) {
                case 0:
                    op = '*';
                    break;
                case 1:
                    op = '/';
                    break;
                case 2:
                    op = '+';
                    break;
                case 3:
                    op = '-';
                    break;
                default:
                    break;
            }
            flag = (flag + 1) % 4;
            // 当操作数的优先级小于等于栈顶时，出栈运算
            while (!ops.isEmpty() && map.get(op) <= map.get(ops.peek())) {
                cal(nums, ops);
            }
            ops.add(op);
        }
        while (!ops.isEmpty())
            cal(nums, ops);
        return nums.pop();
    }

    public static void main(String[] args) {
        Main1006 main1006 = new Main1006();

    }

}
