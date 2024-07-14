package leetcode_by_category.stack_and_queue;

/*
括号问题
给你⼀个括号字符串 s，它只包含字符 '(' 和 ')'。⼀个括号字符串被称为平衡的当它满⾜：
1、任何左括号 '(' 必须对应两个连续的右括号 '))'。
2、左括号 '(' 必须在对应的连续两个右括号 '))' 之前。
⽐⽅说 "())"，"())(())))" 和 "(())())))" 都是平衡的，")()"，"()))" 和 "(()))" 都是不平衡
的。
你可以在任意位置插⼊字符 '(' 和 ')'，请你返回让 s 平衡的最少插⼊次数。
 */
public class Main1541 {

    public static void main(String[] args) {
        Main1541 main1541 = new Main1541();
        System.out.println(main1541.minInsertions("(()))"));
        System.out.println(main1541.minInsertions("()("));
        System.out.println(main1541.minInsertions("(()))"));
    }

    public int minInsertions(String s) {
        int res = 0;
        int num = 0; // 需要的右括号的数量
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (num <= 0) {
                    // 说明左边右括号太多，需要补充左括号
                    res++;
                    num++;
                } else {
                    num--;
                }
            }

            if (s.charAt(i) == '(') {
                num += 2;
                if (num % 2 == 1) {
                    num--;
                    res++;
                }
            }
        }
        return res + Math.abs(num);
    }
}
