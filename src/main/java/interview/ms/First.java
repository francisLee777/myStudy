package interview.ms;

/**
 * @author lihaoyu
 * @date 2019/11/29 12:42
 */
public class First {

    // 微软 第二场面试   第一个题两个链表交点   第二题 非递归后序遍历树   第三题 编辑距离优化空间

    private static void fun(String s1, String s2){
        int len1 = s1.length(), len2 = s2.length();
        // dp[i][j] = Math.min(dp[i-1][j]+1, dp[i][j-1]+1, dp[i-1][i+1]+flag)
        // dp[][] 中 上一个元素，前一个元素，斜对角元素
        int[] dp = new int[len2+1];
        for(int i = 0; i <= len2; i++){
            dp[i] = i;
        }
        for(int i = 1; i <= len1; i++){
            int dp_s1 = i;
            for(int j = 1; j <= len2; j++){


            }
        }


    }

}
