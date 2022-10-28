package run_2022.run_2022_10;

import algorithm.temp.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author lihaoyu
 * @date 2022/10/4 10:27
 */
public class Main126 {


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        LinkedList<List<String>> list = new LinkedList<>();
        List<List<String>> res = new ArrayList<>();
        Set<String> visited = new HashSet<String>(){{add(beginWord);}};
        boolean isDone = false;
        Set<String> set = new HashSet<>(wordList.size());
        set.addAll(wordList);
        ArrayList<String> tt  = new ArrayList<String>(){{add(beginWord);}};
        list.addLast(tt);
          while(!list.isEmpty()){
              int size = list.size();
              Set<String> subVisited = new HashSet<>();
              // 弹出 size 次
              for (int i = 0; i < size; i++) {
                  List<String> tempList = list.pollFirst();
                  String tempStr = tempList.get(tempList.size() - 1);
                  // 找一下路径
                  for (String s : set) {
                      if(visited.contains(s)) continue;
                      if(canConvert(s,tempStr)){
                          // 找到了
                        tempList.add(s);
                        list.addLast(new ArrayList<>(tempList));
                        tempList.remove(tempList.size()-1);
                          // 结束
                          if(s.equals(endWord)){
                              isDone = true;
                              res.add(list.get(list.size()-1));
                          }
                          // 访问过的节点
                          subVisited.add(s);
                      }

                  }
              }
              visited.addAll(subVisited);
              if(isDone) break;
          }
        return res;
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

    public static void main(String[] args) {
        System.out.println(new Main126().findLadders("hit", "cog", new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))));
    }
}
