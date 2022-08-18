package run_2022.run_2022_07;

import java.util.TreeSet;

/**
 * @author lihaoyu
 * @date 2022/7/16 10:57
 */
public class Main3 {


    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] temp = new int[1024];
        int res = 1,left = 0 , right = 1,tempLen = 1;
        temp[s.charAt(left)] = 1;
        while(right < s.length()){
            if(temp[s.charAt(right)] == 0 || temp[s.charAt(right)] < left){
                tempLen++;
                res = Math.max(res,tempLen);
            }else{
                left = temp[s.charAt(right)];
                tempLen = right - left + 1;
            }
            temp[s.charAt(right)] = right+1;
            right++;
        }
        return res;
    }


    public static void main(String[] args) {
        TreeSet set = new TreeSet();
        set.add(1);
        set.add(1);
        System.out.println(set.size());
        System.out.println(Main3.lengthOfLongestSubstring("tmmzuxt"));
        System.out.println(Main3.lengthOfLongestSubstring("aaa"));
    }
}
