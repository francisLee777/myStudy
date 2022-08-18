package run_2022.run_2022_07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lihaoyu
 * @date 2022/7/16 16:51
 */
public class Main187 {


    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>(256);
        for (int i = 0; i <= s.length()-10; i++) {
            String temp = s.substring(i,i+10);
            Integer sss = map.getOrDefault(temp, 0);
            if(sss == 1){
                list.add(temp);
            }
            map.put(temp,sss+1);
        }
        return list;
    }


    public static void main(String[] args) {
        System.out.println(Main187.findRepeatedDnaSequences("AAAAAAAAAAA"));
    }
}
