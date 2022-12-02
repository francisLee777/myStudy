package leetcode_by_category.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main1048 {

    public int longestStrChain(String[] words) {
        int[] dp = new int[words.length];
        Arrays.fill(dp, 1);
        List<String> asList = Arrays.asList(words);
        asList.sort((s1, s2) -> s1.length() - s2.length());
        int res = 1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == words[0].length())
                continue; // 初始的几个跳过
            // 往前找长度小一的
            for (int j = i - 1; j >= 0 && words[i].length() - words[j].length() <= 1; j--) {
                if (words[i].length() == words[j].length())
                    continue;
                // 找到了
                if (fun(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(res, dp[i]);
                }
            }

        }
        return res;
    }

    // s1 长度比 s2 小1 顺序比较，只能有一个不相等
    boolean fun(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (count > 1)
                return false;
            if (count == 0 && s1.charAt(i) == s2.charAt(i) || count == 1 && s1.charAt(i) == s2.charAt(i + 1))
                continue;
            if (s1.charAt(i) != s2.charAt(i)) {
                i--;
                count++;
            }
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        Main1048 main1048 = new Main1048();
        System.out.println(main1048.longestStrChain(new String[] { "abcd", "dbqca" }));
    }
}
