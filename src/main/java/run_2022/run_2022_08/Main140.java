package run_2022.run_2022_08;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lihaoyu
 * @date 2022/8/17 23:29
 */
public class Main140 {

    Set<String> set = new HashSet<>();
    List<String> tempList = new ArrayList<>();
    List<String> res = new ArrayList<>();

  void  func(String s,  int start){
      if (String.join("",tempList).equals(s)){
          res.add(String.join(" ",tempList));
          return;
      }
      if(start >= s.length()) return;
      for (int i = start; i < s.length(); i++){
          String t = s.substring(start,i+1);
          if(set.contains(t)){
              tempList.add(t);
              func(s,i+1);
              tempList.remove(tempList.size()-1);
          }
      }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        set.addAll(wordDict);
        func(s,0);
        return res;
    }

    public static void main(String[] args) {
        List<String> sss = Arrays.asList("cat","cats","and","sand","dog");
        System.out.println(new Main140().wordBreak("catsanddog", sss));
    }
}
