package leetcode_by_category.double_pointer_and_slice_window;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author lihaoyu
 * @date 2022/11/15 19:11
 */
public class Main763 {
    static  ArrayList<Integer> fun(String s){
        ArrayList<Integer> list = new ArrayList<>();
        int[] maxIndex = new int[26];
        Arrays.fill(maxIndex,-1);
        for (int i = 0; i < s.length(); i++) {
            maxIndex[s.charAt(i) - 'a'] = Math.max(i,maxIndex[s.charAt(i) - 'a']);
        }
        int left = 0, right = 0;
        while(right < s.length()){
            for(int i = left;i<=right && right < s.length();i++){
                right = Math.max(maxIndex[s.charAt(i) - 'a'],right);
            }
            list.add(right - left + 1);
            left = right+1;
            right = left;
        }
        return list;
    }


    public static void main(String[] args) {
        System.out.println(fun("ababcbacadefegdehijhklij"));
    }
}
