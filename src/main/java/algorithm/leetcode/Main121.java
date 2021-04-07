package algorithm.leetcode;

/**
 * 121. 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * @author lihaoyu
 * @date 2021/4/5 23:00
 */
public class Main121 {

    public int maxProfit(int[] prices) {
    if(prices == null || prices.length <= 1) return 0;
        int min = prices[0], res = 0;
        for (int i = 1; i < prices.length; i++) {
           min = Math.min(min, prices[i]);
           res = Math.max(res, prices[i] - min);
        }
        return res;
    }


    public static void main(String[] args) {

    }
}

