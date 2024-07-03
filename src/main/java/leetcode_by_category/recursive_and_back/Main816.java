package leetcode_by_category.recursive_and_back;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入: "(123)"
 * 输出: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
 * 输入: "(00011)"
 * 输出:  ["(0.001, 1)", "(0, 0.011)"]
 *
 * @author lihaoyu
 * @date 2023/12/4 15:00
 */
public class Main816 {
    List<String> resList = new ArrayList<>();

    // 先划分 , 然后再填充,    因为逗号有且仅有一个
    public static void main(String[] args) {
        Main816 main816 = new Main816();
        System.out.println(main816.ambiguousCoordinates("(11000)"));
    }

    public List<String> ambiguousCoordinates(String s) {
        s = s.substring(1, s.length() - 1);
        for (int i = 0; i < s.length() - 1; i++) {
            // i 后面能加逗号吗， 不能的话继续. 如果分隔之后的两个字符串，前缀是0且最后一个字符也是0[长度大于1]，那么就不能分割。
            if (s.charAt(0) == '0' && s.charAt(i) == '0' && i >= 1 || s.charAt(s.length() - 1) == '0' && s.charAt(i + 1) == '0' && i < s.length() - 2) {
                continue;
            }
            // 可以分割，两边的要相乘
            List<String> fun1 = fun(s, 0, i);
            List<String> fun2 = fun(s, i + 1, s.length() - 1);
            for (String left : fun1) {
                for (String right : fun2) {
                    resList.add("(" + left + ", " + right + ")");
                }
            }
        }
        return resList;
    }

    List<String> fun(String str, int start, int end) {
        List<String> res = new ArrayList<>();
        if (start == end) {
            res.add(str.substring(start, start + 1));
            return res;
        }
        // 如果第一个元素是0，那么只能放0后面
        if (str.charAt(start) == '0') {
            res.add(str.charAt(start) + "." + str.substring(start + 1, end + 1));
            return res;
        }
        res.add(str.substring(start, end + 1));
        // 如果最后有一个0，那么则加不了小数点
        if (str.charAt(end) == '0') {
            return res;
        }
        // 前后都没0，小数点可以随便加
        for (int i = start; i < end; i++) {
            res.add(str.substring(start, i + 1) + "." + str.substring(i + 1, end + 1));
        }
        return res;
    }
}