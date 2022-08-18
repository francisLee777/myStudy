package run_2022.run_2022_07;


/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * @author lihaoyu
 * @date 2022/7/9 17:00
 */
public class Main7 {

    public static int reverse(int x) {
        boolean flag = false;
        if (x == Integer.MIN_VALUE){
            return 0;
        }
        if (x < 0) {
            flag = true;
            x = - x;
        }
        if (x == 0 ) return 0;
        while(x % 10 == 0){
            x /= 10;
        }
        StringBuilder str = new StringBuilder(String.valueOf(x));
        str.reverse();
        if (!flag){
            String max = String.valueOf(Integer.MAX_VALUE);
            String s = str.toString();
            if (s.compareTo(max) > 0 && s.length() == max.length()){
                return 0;
            }
        }else{
            String min = String.valueOf(Integer.MIN_VALUE);
            min = min.substring(1);
            String s = str.toString();
            if (s.compareTo(min) > 0 && s.length() == min.length()){
                return 0;
            }
        }
       int res =  Integer.parseInt(str.toString());
       if(flag){
           res = -res;
       }
        return res;
    }


    public static void main(String[] args) {
Main7.reverse(-2147483648);
    }
}
