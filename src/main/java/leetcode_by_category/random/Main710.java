package leetcode_by_category.random;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
给定一个整数 n 和一个 无重复 黑名单整数数组 blacklist 。设计一种算法，从 [0, n - 1] 范围内的任意整数中选取一个 未加入 黑名单 blacklist 的整数。
任何在上述范围内且不在黑名单 blacklist 中的整数都应该有 同等的可能性 被返回。
优化你的算法，使它最小化调用语言 内置 随机函数的次数。
实现 Solution 类:
Solution(int n, int[] blacklist) 初始化整数 n 和被加入黑名单 blacklist 的整数
int pick() 返回一个范围为 [0, n - 1] 且不在黑名单 blacklist 中的随机整数
例如 Solution solution = new Solution(7, [2, 3, 5]);
solution.pick();   返回0，任何[0,1,4,6]的整数都可以。注意，对于每一个pick的调用，
                   0、1、4和6的返回概率必须相等(即概率为1/4)。
 */
public class Main710 {

    public static void main(String[] args) {
        Main710 main710 = new Main710();
        int[] blacklist = new int[]{5, 4, 2};
        Solution solution = new Solution(7, blacklist);
    }

    static class Solution {
        int[] blacklist;
        int size;
        Random random = new Random();
        Map<Integer, Integer> map;

        public Solution(int n, int[] blacklist) {
            this.blacklist = blacklist;
            size = n - blacklist.length;
            // 先排序
            Arrays.sort(this.blacklist);
            // 从后往前替换
            map = new HashMap<>();
            // index 是被换的位移
            int index = n - 1;
            for (int i = this.blacklist.length - 1; i >= 0; i--) {
                map.put(this.blacklist[i], map.getOrDefault(index, index));
                index--;
            }
        }

        public int pick() {
            int num = random.nextInt(size);
            return map.getOrDefault(num, num);
        }
    }
}
