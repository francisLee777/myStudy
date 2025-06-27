package run_2022.run_2022_07;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 表达式计算，手动收藏
 *
 * @author lihaoyu
 * @date 2022/7/30 10:25
 */
public class Main227 {

    Map<Character, Integer> map = new HashMap<Character, Integer>() {
        {
            put('-', 1);
            put('+', 1);
            put('*', 2);
            put('/', 2);
        }
    };

    public static void main(String[] args) {
        // System.out.println(new Main224().calculate("1+1*2*3*(1+1)"));
        System.out.println(new Main227().calculate("   (1+(4+5+2)-3)+(6+8)"));
        // 添加大括号测试用例
        System.out.println(new Main227().calculate("   (1+{(4+5+2)-3})+(6+8)"));
    }

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

    public int calculate(String s) {
        // 去除空格, 并统一括号
        s = s.replace(" ", "").replace('{', '(').replace('}', ')');
        if (s.length() == 0)
            return 0;
        Stack<Integer> number = new Stack<>();
        // 对首个字符是负号的特殊处理
        if (s.charAt(0) == '-')
            number.add(0);
        Stack<Character> op = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 是数字 直接入栈然后继续
            if (c >= '0' && c <= '9') {
                int j = i + 1;
                while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9')
                    j++;
                number.add(Integer.parseInt(s.substring(i, j)));
                i = j - 1;
                continue;
            }
            // 操作符了，对括号里面首个字符是负号的特殊处理
            if (i > 0 && (s.charAt(i - 1) == '(' && c == '-')) {
                number.add(0);
            }
            if (c == '(') {
                op.push(c);
                continue;
            }
            if (c == ')') {
                // 右括号，一直计算
                while (op.peek() != '(')
                    cal(number, op);
                op.pop();
                continue;
            }
            // + - * /
            // 使用 containsKey 增加鲁棒性，防止 op.peek() 不在 map 中导致异常
            while (!op.isEmpty() && map.containsKey(op.peek()) && map.get(op.peek()) >= map.get(c)) {
                cal(number, op);
            }
            op.push(c);
        }
        while (!op.isEmpty())
            cal(number, op);
        return number.pop();
    }
}
