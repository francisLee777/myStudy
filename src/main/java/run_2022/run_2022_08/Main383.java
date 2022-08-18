package run_2022.run_2022_08;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lihaoyu
 * @date 2022/8/14 16:39
 */
public class Main383 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            map.put(ransomNote.charAt(i),map.getOrDefault(ransomNote.charAt(i),0)+1);
        }
        int count = map.size();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
           int temp =  map2.getOrDefault(magazine.charAt(i),0)+1;
            map2.put(magazine.charAt(i),temp);

            // 和第一个 map 比较
           if(temp == map.getOrDefault(magazine.charAt(i),0)){
               if(--count == 0){
                   return true;
               }

           }
        }
        return  false;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "aab"));
    }
}
