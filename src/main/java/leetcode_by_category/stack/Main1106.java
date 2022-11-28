package leetcode_by_category.stack;

import java.util.Stack;

/*
 * 1106. 解析布尔表达式
给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。

有效的表达式需遵循以下约定：

"t"，运算结果为 True
"f"，运算结果为 False
"!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT）
"&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND）
"|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR）
示例 1：

输入：expression = "!(f)"
输出：true
示例 2：

输入：expression = "|(f,t)"
输出：true
示例 3：

输入：expression = "&(t,f)"
输出：false
示例 4：

输入：expression = "|(&(t,f,t),!(t))"
输出：false 
 */
public class Main1106 {

    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> tempStack = new Stack<>();
        // expression = "("+expression+")";
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == ',')
                continue;
            if (expression.charAt(i) != ')') {
                stack.add(expression.charAt(i));
                continue;
            }
            while (true) {
                Character c = stack.pop();
                if (c != '(') {
                    tempStack.add(c);
                } else {
                    // 操作符出来
                    Character op = stack.pop();

                    boolean tempRes = true;
                    Character temp = tempStack.pop();
                    if (temp == 'f')
                        tempRes = false;
                    else
                        tempRes = true;
                    if (op == '&')
                        while (!tempStack.isEmpty()) {
                            temp = tempStack.pop();
                            if (temp == 'f')
                                tempRes = tempRes & false;
                            else
                                tempRes = tempRes & true;
                        }
                    else if (op == '|')
                        while (!tempStack.isEmpty()) {
                            temp = tempStack.pop();
                            if (temp == 'f')
                                tempRes = tempRes | false;
                            else
                                tempRes = tempRes | true;
                        }
                    else if (op == '!') {
                        tempRes = !tempRes;
                    }
                    // 最后放回去
                    if (tempRes)
                        stack.add('t');
                    else
                        stack.add('f');
                    break;
                }
            }
        }
        return stack.peek() == 'f' ? false : true;
    }

    public static void main(String[] args) {
        Main1106 main1106 = new Main1106();
        System.out.println(main1106.parseBoolExpr("|(f,t)"));

    }
}
