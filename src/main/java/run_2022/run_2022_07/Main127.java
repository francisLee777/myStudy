package run_2022.run_2022_07;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author lihaoyu
 * @date 2022/7/31 17:34
 */
public class Main127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       if(! wordList.contains(endWord)){
           return 0;
       }
        Set<String> set = new HashSet<>();
        LinkedList<String> queue = new LinkedList<>();
        set.add(beginWord);
        queue.addLast(beginWord);
        int count = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.pollFirst();
                for (int j = 0; j < wordList.size(); j++) {
                    String s2 = wordList.get(j);
                    if(set.contains(s2))continue;
                    if(canConvert(str,s2)){
                        // 可以加入
                        if(s2.equals(endWord)) return count+1;
                        set.add(s2);
                        queue.addLast(s2);
                    }
                }
            }
            count++;
        }
return 0;
    }

    // s1  到  s2 是否可转换
    boolean canConvert(String s1, String s2){
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)){
                count++;
            }
            if (count > 1) return false;
        }
        return count==1;
    }

}
