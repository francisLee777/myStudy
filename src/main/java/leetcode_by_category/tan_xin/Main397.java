package leetcode_by_category.tan_xin;

/**
 * 给一个正整数 n ，你可以做如下操作：
 * 如果 n 是偶数，则用 n / 2替换 n 。
 * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 * 返回 n 变为 1 所需的 最小替换次数 。
 *
 * @author lihaoyu
 * @date 2023/2/27 13:36
 */
public class Main397 {


    public static void main(String[] args) {
        Main397 aaa = new Main397();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(aaa.integerReplacement(2147483647));
    }

    public int integerReplacement(int n) {
        // 8-3 7-4 4-2
        int res = 0;
        long a = n;
        while (a != 1) {
            // 偶数直接走
            if ((a & 1) == 0) {
                a = a / 2;
                res++;
                continue;
            }
            // 奇数， 加1还是减1   看前一位
            if (a == 3) {
                a = a - 1;
            } else if ((a & 3) == 1) {
                a = a - 1;
            } else {
                a = a + 1;
            }
            res++;
        }
        return res;
    }
}
