package run_2022.run_2022_07;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lihaoyu
 * @date 2022/7/27 23:03
 */
public class Main241 {
    char[] cs;

    List<Integer> fun(String expression, int start, int end){
        List<Integer> ans = new ArrayList<>();
        boolean flag = false;
        for (int i = start; i <= end; i++) {
            if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9'){
                continue;
            }else{
                flag = true;
            }

            List<Integer> l1 =  fun(expression,start,i-1), l2 = fun(expression,i+1,end);
            for (int a : l1) {
                for (int b : l2) {
                    int cur = 0;
                    if (cs[i] == '+') cur = a + b;
                    else if (cs[i] == '-') cur = a - b;
                    else cur = a * b;
                    ans.add(cur);
                }
            }
        }
return ans;
    }


    public List<Integer> diffWaysToCompute(String expression) {
        cs = expression.toCharArray();
        return fun(expression,0, cs.length - 1);
    }



}
