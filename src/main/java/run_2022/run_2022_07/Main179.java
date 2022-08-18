package run_2022.run_2022_07;


import java.util.ArrayList;
import java.util.List;

/**
 * @author lihaoyu
 * @date 2022/7/24 21:16
 */
public class Main179 {

    public static String largestNumber(int[] nums) {
      List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
      list.sort((o1, o2) -> (o2.toString()+o1.toString()).compareTo((o1.toString()+o2.toString())));
      StringBuilder sb = new StringBuilder();
      list.forEach(sb::append);
      if (sb.charAt(0) == '0') return "0";
      return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(Main179.largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
